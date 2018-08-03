package com.padcmyanmar.mmkunyi.adapters

import android.content.Context
import android.view.ViewGroup
import com.padcmyanmar.mmkunyi.R
import com.padcmyanmar.mmkunyi.data.vos.JobsVO
import com.padcmyanmar.mmkunyi.delegate.JobsDelegate
import com.padcmyanmar.mmkunyi.view.holders.JobsListViewHolder

class JobsListAdapter(context: Context, private val jobsDelegate: JobsDelegate) : BaseRecyclerAdapter<JobsListViewHolder, JobsVO>(context) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobsListViewHolder {

        val jobsItemView= jobsLayoutInflater.inflate(R.layout.view_holder_jobs_list,parent,false)
        return JobsListViewHolder(jobsItemView,jobsDelegate)
    }
}