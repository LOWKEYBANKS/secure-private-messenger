package com.bitchat.android

import android.app.Application
import android.content.Intent
import android.util.Log
import com.bitchat.android.crypto.SodiumLoader

class BitchatApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // Load native libsodium if present
        val sodiumOk = SodiumLoader.load()
        if (!sodiumOk) {
            Log.w("BitchatApplication", "libsodium native not loaded. Native crypto acceleration disabled.")
        }

        // Attempt to start embedded Tor service if available.
        // Adapt the class name to your Tor service implementation (Orbot wrapper or TorService).
        try {
            // If you bundle Tor as a service class, start it here. Many projects use org.torproject.android.service.TorService
            val torClassName = "org.torproject.android.service.TorService"
            val torClazz = try { Class.forName(torClassName) } catch (e: Exception) { null }
            if (torClazz != null) {
                val torIntent = Intent(this, torClazz)
                startService(torIntent)
                Log.i("BitchatApplication", "Attempted to start Tor service: $torClassName")
            } else {
                Log.i("BitchatApplication", "Tor service class not found; skipping start.")
            }
        } catch (e: Exception) {
            Log.w("BitchatApplication", "Failed to start Tor service: ${e.message}")
        }
    }
}
