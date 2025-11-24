package com.lowkeybanks.bitchat.crypto

object SodiumLoader {
    fun load(): Boolean {
        return try {
            System.loadLibrary("sodium")
            true
        } catch (e: UnsatisfiedLinkError) {
            try {
                System.loadLibrary("sodiumjni")
                true
            } catch (ex: Throwable) {
                false
            }
        }
    }
}
