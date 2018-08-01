package com.padcmyanmar.mmkunyi.data.vos

import com.google.gson.annotations.SerializedName

class WhyShouldHireVO(@SerializedName("msg") var msg:String = "",

                      @SerializedName("timestamp") var timestamp:String ="",

                      @SerializedName("whyShouldHireId") var whyShouldHireId:Int = 0
                      ) {
}