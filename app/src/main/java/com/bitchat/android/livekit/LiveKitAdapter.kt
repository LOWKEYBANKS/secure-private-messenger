package com.bitchat.android.livekit

import com.bitchat.android.net.OkHttpProvider
import io.livekit.android.LiveKitClient
import io.livekit.android.RoomListener
import okhttp3.OkHttpClient

/**
 * Minimal LiveKit adapter using an OkHttp client that routes through Tor.
 * You will need to adapt to your LiveKit SDK version — this is a skeleton.
 */
class LiveKitAdapter(
    private val signalingUrl: String
) {
    private val okHttpClient: OkHttpClient = OkHttpProvider.torHttpClient()

    // Lazy instance - you will need to supply LiveKit client builder that accepts an OkHttpClient
    // For current LiveKit SDKs which accept custom engines/clients, pass okHttpClient to the builder.
    private var client: LiveKitClient? = null

    fun connect(token: String, listener: RoomListener) {
        // Pseudocode - adapt to your LiveKit SDK version
        // Example: LiveKitClient(signalingUrl, token, engine = OkHttpEngine(okHttpClient))
        client = LiveKitClient(signalingUrl, token/*, pass okHttpClient where supported */)
        client?.addRoomListener(listener)
        client?.connect()
    }

    fun disconnect() {
        client?.disconnect()
    }
}
