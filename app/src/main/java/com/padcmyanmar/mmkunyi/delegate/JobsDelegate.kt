package com.padcmyanmar.mmkunyi.delegate

import com.padcmyanmar.mmkunyi.data.vos.JobsVO

interface JobsDelegate
{
    fun onTapJobList(jobList: JobsVO?)
}