package com.padcmyanmar.mmkunyi.data.vos

import com.google.gson.annotations.SerializedName

class ViewedVO(@SerializedName("seekerId") var seekerId:Int = 0,

               @SerializedName("seekerName") var seekerName:String ="",

               @SerializedName("seekerProfilePicUrl") var seekerProfilePicUrl:String = "",

               @SerializedName("seekerSkill") var seekerSkill:List<SeekerVO> = ArrayList(),

               @SerializedName("viewedTimeStamp") var viewedTimeStamp: String = ""
               ) {
}