package com.lowkeybanks.bitchat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        // Initialize BITCHAT++ components
        initializeApplication()
    }
    
    private fun initializeApplication() {
        val app = application as BitchatApplication
        
        // Generate identity keys
        val ed25519KeyPair = app.cryptoWrapper.generateEd25519KeyPair()
        val x25519KeyPair = app.cryptoWrapper.generateX25519KeyPair()
        
        // TODO: Initialize UI components
    }
}
