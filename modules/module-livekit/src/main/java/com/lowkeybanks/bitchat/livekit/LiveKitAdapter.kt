package com.lowkeybanks.bitchat.livekit

import io.livekit.android.LiveKit
import io.livekit.android.Room
import io.livekit.android.events.RoomEvent
import io.livekit.android.room.track.AudioTrack
import kotlinx.coroutines.flow.MutableStateFlow

class LiveKitAdapter(private val context: android.content.Context, private val torProxy: String) {
    
    private var room: Room? = null
    val isConnected = MutableStateFlow(false)
    val audioTrack = MutableStateFlow<AudioTrack?>(null)
    
    suspend fun joinRoom(roomId: String, token: String) {
        room = LiveKit.create(
            applicationContext = context,
            url = "wss://livekit-server-$roomId.onion", // Tor hidden service
            token = token,
            options = Room.Options(
                connectTimeoutMs = 10000,
                enableNetworkQuality = true,
                proxy = torProxy // SOCKS5 via Tor
            )
        )
        
        room?.addListener { event ->
            when (event) {
                is RoomEvent.Connected -> isConnected.value = true
                is RoomEvent.Disconnected -> isConnected.value = false
                is RoomEvent.TrackSubscribed -> {
                    if (event.track is AudioTrack) {
                        audioTrack.value = event.track
                    }
                }
            }
        }
        
        room?.connect()
    }
}
