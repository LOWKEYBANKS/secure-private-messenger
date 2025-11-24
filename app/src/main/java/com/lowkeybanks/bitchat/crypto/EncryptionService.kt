package com.lowkeybanks.bitchat.crypto

import android.content.Context
import android.util.Log

class EncryptionService(private val context: Context) {
    
    companion object {
        private const val TAG = "EncryptionService"
    }
    
    init {
        val loaded = SodiumLoader.load()
        if (!loaded) {
            Log.e(TAG, "Failed to load Libsodium native library")
        } else {
            Log.d(TAG, "Libsodium loaded successfully")
        }
    }
    
    // Placeholder for actual crypto methods to be added later
    // based on user's full source code
}
