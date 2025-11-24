package com.bitchat.android.crypto

import android.util.Log

object SodiumLoader {
    private const val TAG = "SodiumLoader"

    /**
     * Attempt to load common libsodium library names installed in the APK.
     * Safe to call early in Application.onCreate() — returns true if loaded.
     */
    fun load(): Boolean {
        val candidates = listOf("sodium", "sodiumjni", "libsodium", "liblibsodium")
        for (name in candidates) {
            try {
                System.loadLibrary(name)
                Log.i(TAG, "Loaded native library: $name")
                return true
            } catch (e: UnsatisfiedLinkError) {
                // try next candidate
            } catch (e: Exception) {
                // ignore other errors
            }
        }
        Log.w(TAG, "No libsodium native library loaded; falling back to Java crypto where available.")
        return false
    }
}
