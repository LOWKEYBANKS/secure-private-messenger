package com.bitchat.android.crypto

import android.util.Log

object SodiumLoader {
    private const val TAG = "SodiumLoader"

    /**
     * Try to load common possible sodium library names.
     * Returns true if a native library was successfully loaded.
     */
    fun load(): Boolean {
        val candidates = listOf("sodium", "sodiumjni", "libsodium")
        for (name in candidates) {
            try {
                System.loadLibrary(name)
                Log.i(TAG, "Loaded native library: $name")
                return true
            } catch (e: UnsatisfiedLinkError) {
                // try next
            } catch (e: Exception) {
                // unexpected; continue
            }
        }
        Log.w(TAG, "No libsodium library loaded - native crypto features disabled.")
        return false
    }
}
