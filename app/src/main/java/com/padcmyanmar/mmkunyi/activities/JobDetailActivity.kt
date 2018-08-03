package com.padcmyanmar.mmkunyi.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.view.menu.MenuView
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.padcmyanmar.mmkunyi.R
import com.padcmyanmar.mmkunyi.data.models.JobsModel
import com.padcmyanmar.mmkunyi.data.vos.JobsVO
import com.padcmyanmar.mmkunyi.delegate.JobsDelegate
import com.padcmyanmar.mmkunyi.utils.JobsConstants
import kotlinx.android.synthetic.main.activity_job_details.*
import kotlinx.android.synthetic.main.view_holder_jobs_list.*
import kotlinx.android.synthetic.main.view_holder_jobs_list.view.*

class JobDetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_details)

        var jobsId: Int = intent.getIntExtra(JobsConstants.JOB_ID, 1)

        val jobsVO: JobsVO = JobsModel.getInstance().getJobsById(jobsId)!!
        BindData(jobsVO)


    }

    private var importantNote: String = ""
    private var requiredSkill: String = ""

    @SuppressLint("StringFormatInvalid", "SetTextI18n")
    private fun BindData(jobsVO: JobsVO?) {
        tvJobDescription!!.text = jobsVO?.fullDesc
        tvPlaceInDetail!!.text = jobsVO?.location
        tvAmountInDetail!!.text = jobsVO?.offerAmount!!.amount.toString()
        tvDurationInDetail!!.text = jobsVO?.offerAmount!!.duration
        tvJobTitle!!.text = jobsVO?.jobTags[0].desc
        tvEndDate!!.text = jobsVO?.jobDuration!!.jobEndDate
        tvStartDate!!.text = jobsVO?.jobDuration!!.jobStartDate
        tvTotalWorkDay!!.text = jobsVO?.jobDuration!!.totalWorkingDays.toString()
        tvDaysPerWeek!!.text = jobsVO?.jobDuration!!. workingDaysPerWeek.toString()
        tvHoursPerDay!!.text = jobsVO?.jobDuration!!.workingHoursPerDay.toString()

        val email = applicationContext.resources.getString(R.string.email, jobsVO?.email)
        tvEmail!!.text = email

        val phoneNo = applicationContext.resources.getString(R.string.phone, jobsVO?.phoneNo)
        tvPhoneNo!!.text = phoneNo

        if (jobsVO?.requiredSkill.size == 1) {
            tvRequiredSkill!!.text = jobsVO?.requiredSkill[0].skillName
        } else {
            requiredSkill += jobsVO?.requiredSkill[0].skillName
            for (requiredSkillId in 1 until jobsVO?.requiredSkill.size) {
                if (requiredSkillId != jobsVO?.requiredSkill.size) {
                    var skill: String = jobsVO?.requiredSkill[requiredSkillId].skillName
                    requiredSkill += "\n" + skill
                } else break
            }
            tvRequiredSkill!!.text = requiredSkill
        }

        if (jobsVO?.importantNotes.size == 1) {
            tvImportantNotes!!.text = jobsVO?.importantNotes[0]
        } else {
            importantNote += jobsVO?.importantNotes[0]
            for (importantNotesId in 1 until jobsVO?.importantNotes.size) {
                if (importantNotesId != jobsVO?.importantNotes.size) {
                    var notes: String = jobsVO?.importantNotes[importantNotesId]
                    importantNote += "\n" + notes
                } else break
            }
            tvImportantNotes!!.text = importantNote
        }

















    }


}

