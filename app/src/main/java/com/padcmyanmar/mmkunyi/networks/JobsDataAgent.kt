package com.padcmyanmar.mmkunyi.networks

import com.google.gson.Gson
import com.padcmyanmar.mmkunyi.events.ErrorEvent
import com.padcmyanmar.mmkunyi.events.SuccessEvent
import com.padcmyanmar.mmkunyi.networks.responses.GetJobListsResponse
import com.padcmyanmar.mmkunyi.utils.JobsConstants
import okhttp3.OkHttpClient
import org.greenrobot.eventbus.EventBus
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class JobsDataAgent {

    companion object {
        private var INSTANCE: JobsDataAgent? = null
        fun getInstance(): JobsDataAgent {
            if (INSTANCE == null) {
                INSTANCE = JobsDataAgent()
            }
            val i = INSTANCE
            return i!!
        }
    }

    private val jobsApi: JobsApi

    private constructor() {
        val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build()
        val retrofit = Retrofit.Builder()
                .baseUrl(JobsConstants.API_BASE)
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .client(okHttpClient)
                .build()

        jobsApi = retrofit.create(JobsApi::class.java)
    }

    fun loadJobLists(accessToken: String, page: Int) {
        val newsResponseCall = jobsApi.loadJobList(page, accessToken)
        newsResponseCall.enqueue(object : Callback<GetJobListsResponse> {
            override fun onFailure(call: Call<GetJobListsResponse>?, t: Throwable?) {
                EventBus.getDefault().post(ErrorEvent.ApiErrorEvent(t))
            }

            override fun onResponse(call: Call<GetJobListsResponse>, response: Response<GetJobListsResponse>) {
                val newsResponse: GetJobListsResponse? = response.body()
                if (newsResponse != null
                        && newsResponse.getCode() == 200
                        && newsResponse.getJobsList().isNotEmpty()) {
                    val newsLoadedEvent = SuccessEvent.JobsListLoadedEvent(newsResponse.getJobsList())
                    EventBus.getDefault().post(newsLoadedEvent)
                } else {
                    if(newsResponse != null)
                        EventBus.getDefault().post(SuccessEvent.EmptyDataEvent(newsResponse.getMessage()))
                    else
                        EventBus.getDefault().post(SuccessEvent.EmptyDataEvent())
                }
            }
        })
    }

}