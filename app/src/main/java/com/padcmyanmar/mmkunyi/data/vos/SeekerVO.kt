package com.padcmyanmar.mmkunyi.data.vos

import com.google.gson.annotations.SerializedName

class SeekerVO(@SerializedName("skillId") var skillId:Int = 0,

               @SerializedName("skillName") var skillName:String = ""

) {
}