package com.padcmyanmar.mmkunyi.data.vos

import com.google.gson.annotations.SerializedName

class OfferAmountVO(@SerializedName("amount") var amount:Int = 0,

                    @SerializedName("duration") var duration: String = ""
                    ) {
}