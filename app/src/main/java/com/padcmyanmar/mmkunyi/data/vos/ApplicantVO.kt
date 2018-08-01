package com.padcmyanmar.mmkunyi.data.vos

import com.google.gson.annotations.SerializedName

class ApplicantVO(@SerializedName("appliedDate") var appliedDate:String ="",

                  @SerializedName("canLowerOfferAmount") var canLowerOfferAmount:Boolean = false,

                  @SerializedName("seekerId") var seekerId:Int = 0,

                  @SerializedName("seekerName") var seekerName:String = "",

                  @SerializedName("seekerProfilePicUrl") var seekerProjilePicUrl:String="",

                  @SerializedName("seekerSkill") var seekerSkill:List<SeekerVO> = ArrayList(),

                  @SerializedName("whyShouldHire") var whyShouldHire:List<WhyShouldHireVO> = ArrayList()
                  )