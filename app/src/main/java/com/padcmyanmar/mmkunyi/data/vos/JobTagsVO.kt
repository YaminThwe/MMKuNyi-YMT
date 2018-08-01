package com.padcmyanmar.mmkunyi.data.vos

import com.google.gson.annotations.SerializedName

class JobTagsVO(@SerializedName("desc") var desc:String = "",

                @SerializedName("jobCountWithTag") var jobCountWithTap:Int = 0,

                @SerializedName("tag") var tag:String = "",

                @SerializedName("tagId") var tagId:Int = 0
                ) {
}