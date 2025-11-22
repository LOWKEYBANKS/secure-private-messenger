package com.lowkeybanks.bitchat.crypto

import com.squareup.sqldelight.drivers.sqlitedriver.SqliteDriver
import org.libsodium.jni.NaCl
import org.libsodium.jni.Sodium

class LibsodiumWrapper {
    
    companion object {
        init {
            System.loadLibrary("sodiumjni")
        }
    }
    
    // Ed25519 Identity Keys
    fun generateEd25519KeyPair(): Ed25519KeyPair {
        val publicKey = ByteArray(32)
        val secretKey = ByteArray(64)
        Sodium.crypto_sign_keypair(publicKey, secretKey)
        return Ed25519KeyPair(publicKey, secretKey)
    }
    
    // X25519 Ephemeral Keys
    fun generateX25519KeyPair(): X25519KeyPair {
        val publicKey = ByteArray(32)
        val secretKey = ByteArray(32)
        Sodium.crypto_box_keypair(publicKey, secretKey)
        return X25519KeyPair(publicKey, secretKey)
    }
    
    // AES-256-GCM Encryption
    fun encryptAES256GCM(plaintext: ByteArray, key: ByteArray): AEGResult {
        require(key.size == 32) { "Key must be 32 bytes" }
        
        val ciphertext = ByteArray(plaintext.size + 16)
        val nonce = ByteArray(12)
        val mac = ByteArray(16)
        
        Sodium.randombytes_buf(nonce, nonce.size)
        Sodium.crypto_aead_aes256gcm_encrypt(ciphertext, mac, plaintext, plaintext.size, null, 0, null, nonce, key)
        
        return AEGResult(ciphertext, nonce, mac)
    }
    
    data class Ed25519KeyPair(val publicKey: ByteArray, val secretKey: ByteArray)
    data class X25519KeyPair(val publicKey: ByteArray, val secretKey: ByteArray)
    data class AEGResult(val ciphertext: ByteArray, val nonce: ByteArray, val mac: ByteArray)
}
