package com.padcmyanmar.mmkunyi.data.vos

import com.google.gson.annotations.SerializedName

class JobsVO (@SerializedName("applicant") var applicant: List<ApplicantVO> = ArrayList(),

              @SerializedName("availablePostCount") var availablePostCount:Int= 0,

              @SerializedName("email") var email : String = "",

              @SerializedName("fullDesc") var fullDesc:String="",

              @SerializedName("genderForJob") var genderForJob: Int = 0,

              @SerializedName("images") var images:List<String> = ArrayList(),

              @SerializedName("importantNotes") var importantNotes:List<String> = ArrayList(),

              @SerializedName("interested") var interested:List<InterestedVO> = ArrayList(),

              @SerializedName("isActive") var isActive:Boolean = false,

              @SerializedName("jobDuration") var jobDuration:JobDurationVO? = null,

              @SerializedName("jobPostId") var jobPostId:Int = 0,

              @SerializedName("jobTags") var jobTags:List<JobTagsVO> = ArrayList(),

              @SerializedName("location") var location:String = "",

              @SerializedName("makeMoneyRating") var makeMoneyRating: Int = 0,

              @SerializedName("offerAmount") var offerAmount: OfferAmountVO? = null,

              @SerializedName("phoneNo") var phoneNo: String = "",

              @SerializedName("postClosedDate") var postClosedDate:String = "",

              @SerializedName("postedDate") var postedDate: String = "",

              @SerializedName("relevant") var relevant:List<RelevantVO> = ArrayList(),

              @SerializedName("requiredSkill") var requiredSkill:List<RequiredSkillVO> = ArrayList(),

              @SerializedName("shortDesc") var shortDesc:String = "",

              @SerializedName("viewed") var viewed:List<ViewedVO> = ArrayList()
)

{
    fun getjobPostId(): Int{
        return jobPostId
    }
}