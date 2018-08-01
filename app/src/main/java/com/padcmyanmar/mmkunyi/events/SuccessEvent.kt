package com.padcmyanmar.mmkunyi.events

import com.padcmyanmar.mmkunyi.data.vos.JobsVO

class SuccessEvent {

    class JobsListLoadedEvent(val loadedJobNews : List<JobsVO>)

    class EmptyDataEvent(val errorMsg: String? = "Empty Body Response")
}