package com.padcmyanmar.mmkunyi.data.vos

import com.google.gson.annotations.SerializedName

class JobDurationVO(@SerializedName("jobEndDate") var jobEndDate:String = "",

                    @SerializedName("jobStartDate") var jobStartDate:String = "",

                    @SerializedName("totalWorkingDays") var totalWorkingDays:Int = 0,

                    @SerializedName("workingDaysPerWeek") var workingDaysPerWeek:Int = 0,

                    @SerializedName("workingHoursPerDay") var workingHoursPerDay:Double = 0.0
                    ) {
}