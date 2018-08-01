package com.padcmyanmar.mmkunyi.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.padcmyanmar.mmkunyi.R
import com.padcmyanmar.mmkunyi.data.models.JobsModel
import com.padcmyanmar.mmkunyi.data.vos.JobsVO
import com.padcmyanmar.mmkunyi.delegate.JobsDelegate
import com.padcmyanmar.mmkunyi.utils.JobsConstants
import kotlinx.android.synthetic.main.activity_job_details.*

class JobDetailActivity: AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_details)

        var jobsId:Int = intent.getIntExtra(JobsConstants.JOB_ID,1)

        val jobsVO: JobsVO = JobsModel.getInstance().getJobsById(jobsId)!!
        BindData(jobsVO)


    }

    private fun BindData(jobsVO: JobsVO?) {
        tvJobDescription!!.text = jobsVO?.shortDesc
    }


}