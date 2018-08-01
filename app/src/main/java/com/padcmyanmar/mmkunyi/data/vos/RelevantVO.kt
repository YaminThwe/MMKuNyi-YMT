package com.padcmyanmar.mmkunyi.data.vos

import com.google.gson.annotations.SerializedName

class RelevantVO(@SerializedName("relevancyPercentage") var relevancyPercentage:Double = 0.0,

                 @SerializedName("seekerId") var seekerId:Int = 0,

                 @SerializedName("seekerName") var seekerName:String = "",

                 @SerializedName("seekerProfilePicUrl") var seekerProfilePicUrl:String = "",

                 @SerializedName("seekerSkill") var seekerSkill:List<SeekerVO> = ArrayList(),

                 @SerializedName("whyRelevant") var whyRelevant:String = ""
                 ) {
}