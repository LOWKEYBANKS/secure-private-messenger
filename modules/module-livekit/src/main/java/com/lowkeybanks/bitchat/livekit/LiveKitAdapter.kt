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
        // Create Room instance
        room = LiveKit.create(context)

        // Configure listener
        room?.events?.collect { event ->
            when (event) {
                is RoomEvent.Connected -> isConnected.value = true
                is RoomEvent.Disconnected -> isConnected.value = false
                is RoomEvent.TrackSubscribed -> {
                    if (event.track is AudioTrack) {
                        audioTrack.value = event.track as AudioTrack
                    }
                }
                else -> {}
            }
        }

        // Connect to room
        room?.connect(
            url = "wss://livekit-server-$roomId.onion",
            token = token,
            options = Room.Options(
                adaptiveStream = true,
                dynacast = true
            )
        )
    }
}
