package com.padcmyanmar.mmkunyi.events

import android.support.v7.app.AppCompatActivity
import org.greenrobot.eventbus.EventBus

open class BaseEvent:AppCompatActivity() {
    override fun onStart() {
        super.onStart()
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this)
        }
    }

    override fun onStop() {
        super.onStop()
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this)
        }
    }
}