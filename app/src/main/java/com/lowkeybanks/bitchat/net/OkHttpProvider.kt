package com.lowkeybanks.bitchat.net

import okhttp3.OkHttpClient
import java.net.InetSocketAddress
import java.net.Proxy
import java.util.concurrent.TimeUnit

object OkHttpProvider {
    @Volatile private var client: OkHttpClient? = null

    fun torHttpClient(socksHost: String = "127.0.0.1", socksPort: Int = 9060): OkHttpClient {
        return client ?: synchronized(this) {
            client ?: createClient(socksHost, socksPort).also { client = it }
        }
    }

    private fun createClient(socksHost: String, socksPort: Int): OkHttpClient {
        val proxy = Proxy(Proxy.Type.SOCKS, InetSocketAddress(socksHost, socksPort))
        return OkHttpClient.Builder()
            .proxy(proxy)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .callTimeout(60, TimeUnit.SECONDS)
            .build()
    }

    fun reset() {
        client = null
    }
}
