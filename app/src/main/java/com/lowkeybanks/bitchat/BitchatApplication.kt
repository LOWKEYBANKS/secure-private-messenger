package com.lowkeybanks.bitchat

import android.app.Application
import android.content.Intent
import com.lowkeybanks.bitchat.services.TorService
import kotlinx.coroutines.launch
import com.lowkeybanks.bitchat.tor.TorMode
import com.lowkeybanks.bitchat.livekit.LiveKitAdapter
import com.lowkeybanks.bitchat.payments.CashuWallet
import com.lowkeybanks.bitchat.payments.ZeusAdapter

class BitchatApplication : Application() {
    
    lateinit var encryptionService: com.lowkeybanks.bitchat.crypto.EncryptionService
    lateinit var cashuWallet: CashuWallet
    lateinit var zeusAdapter: ZeusAdapter
    lateinit var liveKitAdapter: LiveKitAdapter
    
    override fun onCreate() {
        super.onCreate()
        
        // Initialize Tor
        com.lowkeybanks.bitchat.tor.TorManager.init(this)
        kotlinx.coroutines.CoroutineScope(kotlinx.coroutines.Dispatchers.IO).launch {
            com.lowkeybanks.bitchat.tor.TorManager.applyMode(this@BitchatApplication, com.lowkeybanks.bitchat.tor.TorMode.ON)
        }

        // Initialize core components
        val sodiumLoaded = com.lowkeybanks.bitchat.crypto.SodiumLoader.load()
        if (!sodiumLoaded) {
            android.util.Log.e("BitchatApplication", "Failed to load Libsodium")
        }

        encryptionService = com.lowkeybanks.bitchat.crypto.EncryptionService(this)
        cashuWallet = CashuWallet()
        
        // Initialize adapters
        liveKitAdapter = LiveKitAdapter(this, "127.0.0.1:9060")
        zeusAdapter = ZeusAdapter("127.0.0.1:9060")
        
        // Start Tor service (legacy service, might be redundant with TorManager but keeping for now)
        // startService(Intent(this, TorService::class.java)) 
        // Commented out legacy service as TorManager handles Arti now
    }
}
