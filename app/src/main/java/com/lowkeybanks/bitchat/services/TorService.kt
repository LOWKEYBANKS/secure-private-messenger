package com.lowkeybanks.bitchat.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import info.guardianproject.netcipher.proxy.OrbotHelper

class TorService : Service() {
    
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        initializeTor()
        return 
                    
                        ƒ
                        START STICKY
                    
                
    }
    
    private fun initializeTor() {
        OrbotHelper.requestStartTor(this)
    }
    
    fun getSocksProxy(): String {
        return "socks5://127.0.0.1:9050"
    }
    
    override fun onBind(intent: Intent?): IBinder? = null
}
