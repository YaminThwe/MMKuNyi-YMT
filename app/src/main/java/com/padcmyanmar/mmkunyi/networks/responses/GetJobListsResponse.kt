package com.padcmyanmar.mmkunyi.networks.responses

import com.google.gson.annotations.SerializedName
import com.padcmyanmar.mmkunyi.data.vos.JobsVO

class GetJobListsResponse {

    @SerializedName("code")
    private val code: Int = 0

    @SerializedName("message")
    private val message: String? = null

    @SerializedName("apiVersion")
    private val apiVersion: String? = null

    @SerializedName("jobs")
    private var jobs: List<JobsVO>? = null

    fun getCode(): Int {
        return code
    }

    fun getMessage(): String? {
        return message
    }

    fun getApiVersion(): String? {
        return apiVersion
    }

    fun getJobsList(): List<JobsVO> {
        if (jobs == null) {
            jobs = ArrayList<JobsVO>()
        }
        val jobListVal = jobs
        return  jobListVal!!
    }
}