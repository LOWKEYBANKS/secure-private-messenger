package com.lowkeybanks.bitchat.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.lowkeybanks.bitchat.livekit.LiveKitAdapter

class LiveKitService : Service() {

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        // Service initialization
    }
}
