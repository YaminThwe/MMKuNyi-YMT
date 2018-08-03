package com.padcmyanmar.mmkunyi.view.holders

import android.annotation.SuppressLint
import android.view.View
import com.padcmyanmar.mmkunyi.R
import com.padcmyanmar.mmkunyi.data.vos.JobsVO
import com.padcmyanmar.mmkunyi.delegate.JobsDelegate
import kotlinx.android.synthetic.main.view_holder_jobs_list.view.*

class JobsListViewHolder(itemView: View, private val jobsDelegate: JobsDelegate) : BaseViewHolder<JobsVO>(itemView) {
    @SuppressLint("StringFormatInvalid")
    override fun setData(data: JobsVO) {

        kuNyiData = data

        itemView.tvShortDescription!!.text = data.shortDesc
        itemView.tvPlace!!.text = data.location
        itemView.tvAmount!!.text = data.offerAmount!!.amount.toString()
        itemView.tvDuration!!.text = data.offerAmount!!.duration
        itemView.tvTitle!!.text = data.jobTags[0].tag

        val tvPostDate = itemView.resources.getString(R.string.posted_date, data.postedDate!!)
        itemView.tvPostedDate!!.text = tvPostDate

        val viewed = itemView.resources.getString(R.string.viewed, data.viewed.size)
        itemView.tvViewedInDetail!!.text = viewed

        val interested = itemView.resources.getString(R.string.interested, data.interested.size)
        itemView.tvInterestedInDetail!!.text = interested

        val applied= itemView.resources.getString(R.string.applied,data.applicant.size)
        itemView.tvAppliedInDetail!!.text = applied



    }


    override fun onClick(p0: View?) {
        jobsDelegate.onTapJobList(kuNyiData)
    }
}