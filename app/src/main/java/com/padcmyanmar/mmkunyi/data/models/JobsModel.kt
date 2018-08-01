package com.padcmyanmar.mmkunyi.data.models

import com.padcmyanmar.mmkunyi.data.vos.JobsVO
import com.padcmyanmar.mmkunyi.events.SuccessEvent
import com.padcmyanmar.mmkunyi.networks.JobsDataAgent
import com.padcmyanmar.mmkunyi.utils.JobsConstants
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class JobsModel {

    companion object {
        //sigleton
        private var INSTANCE: JobsModel? = null

        fun getInstance(): JobsModel {
            if (INSTANCE == null) {
                INSTANCE = JobsModel()
            }

            val i = INSTANCE
            return i!!
        }
    }

    private constructor() {
        EventBus.getDefault().register(this)
    }

    private var jobsPage: Int = 1
    private var jobsData: HashMap<Int, JobsVO> = HashMap()

    fun loadJobs() {
        JobsDataAgent.getInstance().loadJobLists(JobsConstants.ACCESS_TOKEN, jobsPage)
    }

    fun getJobsById(jobsId: Int): JobsVO?
    {
        return jobsData.get(jobsId)
    }

    fun forceLoadJobs() {
        jobsPage = 1
        jobsData = HashMap()
        JobsDataAgent.getInstance().loadJobLists(JobsConstants.ACCESS_TOKEN, jobsPage)
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onJobsLoadedEvent(newsLoadedEvent: SuccessEvent.JobsListLoadedEvent) {
        for (jobs: JobsVO in newsLoadedEvent.loadedJobNews) {
           jobsData[jobs.jobPostId] = jobs
        }
    }

}