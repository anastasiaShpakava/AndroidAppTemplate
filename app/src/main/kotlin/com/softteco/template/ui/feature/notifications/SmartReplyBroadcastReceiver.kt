package com.softteco.template.ui.feature.notifications

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import timber.log.Timber

class SmartReplyBroadcastReceiver: BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
    if (p1?.action == "KKKKKKKKKKKKK") {
        val a =p1.getStringExtra("KKKKKKK")
        Timber.tag("inputted body text:").d(a)
    }
    }
}