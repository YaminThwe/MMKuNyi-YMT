package com.padcmyanmar.mmkunyi.networks

import com.padcmyanmar.mmkunyi.networks.responses.GetJobListsResponse
import com.padcmyanmar.mmkunyi.utils.JobsConstants
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface JobsApi {

    @FormUrlEncoded
    @POST(JobsConstants.GET_JOBS)
    fun loadJobList(
            @Field("page") pageIndex: Int,
            @Field("access_token") accessToken:String): Call<GetJobListsResponse>
}