package com.padcmyanmar.mmkunyi.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.padcmyanmar.mmkunyi.R
import com.padcmyanmar.mmkunyi.R.id.tvPostedDate
import com.padcmyanmar.mmkunyi.data.vos.JobsVO
import com.padcmyanmar.mmkunyi.delegate.JobsDelegate
import kotlinx.android.synthetic.main.activity_job_details.view.*
import kotlinx.android.synthetic.main.view_holder_jobs_list.*
import kotlinx.android.synthetic.main.view_holder_jobs_list.view.*

class JobsListViewHolder(itemView: View, private val jobsDelegate: JobsDelegate) : BaseViewHolder<JobsVO>(itemView) {
    override fun setData(data: JobsVO) {

        kuNyiData = data

        itemView.tvShortDescription!!.text = data.shortDesc
        itemView.tvPlace!!.text = data.location
        itemView.tvAmount!!.text = data.offerAmount!!.amount.toString()
        itemView.tvDuration!!.text = data.offerAmount!!.duration

        val tvPostDate=itemView.resources.getString(R.string.posted_date, data.postedDate!!)
        itemView.tvPostedDate!!.text = tvPostDate


    }


    override fun onClick(p0: View?) {
        jobsDelegate.onTapJobList(kuNyiData)
    }
}