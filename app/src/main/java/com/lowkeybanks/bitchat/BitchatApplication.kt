package com.lowkeybanks.bitchat

import android.app.Application
import com.lowkeybanks.bitchat.crypto.LibsodiumWrapper
import com.lowkeybanks.bitchat.services.TorService
import com.lowkeybanks.bitchat.livekit.LiveKitAdapter
import com.lowkeybanks.bitchat.payments.CashuWallet
import com.lowkeybanks.bitchat.payments.ZeusAdapter

class BitchatApplication : Application() {
    
    lateinit var cryptoWrapper: LibsodiumWrapper
    lateinit var cashuWallet: CashuWallet
    lateinit var zeusAdapter: ZeusAdapter
    lateinit var liveKitAdapter: LiveKitAdapter
    
    override fun onCreate() {
        super.onCreate()
        
        // Initialize core components
        cryptoWrapper = LibsodiumWrapper()
        cashuWallet = CashuWallet()
        
        // Start Tor service
        startService(Intent(this, TorService::class.java))
    }
}
