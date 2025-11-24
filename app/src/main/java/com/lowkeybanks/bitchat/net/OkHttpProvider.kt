package com.lowkeybanks.bitchat.net

import okhttp3.OkHttpClient
import java.net.InetSocketAddress
import java.net.Proxy
import java.util.concurrent.TimeUnit

object OkHttpProvider {
    fun torHttpClient(socksHost: String = "127.0.0.1", socksPort: Int = 9050): OkHttpClient {
        val proxy = Proxy(Proxy.Type.SOCKS, InetSocketAddress(socksHost, socksPort))
        return OkHttpClient.Builder()
            .proxy(proxy)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .callTimeout(60, TimeUnit.SECONDS)
            .build()
    }
}
