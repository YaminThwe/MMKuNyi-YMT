package com.padcmyanmar.mmkunyi.view.pods

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.padcmyanmar.mmkunyi.delegate.BeforeLoginDelegate
import kotlinx.android.synthetic.main.view_pod_before_login.view.*

class BeforeLoginViewPod: RelativeLayout {

    private lateinit var jDelegate: BeforeLoginDelegate

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onFinishInflate() {
        super.onFinishInflate()

        loginButton.setOnClickListener { jDelegate.onTapLogin() }
        registerButton.setOnClickListener { jDelegate.onTapRegister() }
    }

    fun setDelegate( beforeLoginDelegate : BeforeLoginDelegate)
    {
        jDelegate=beforeLoginDelegate
    }
}