package com.bitchat.android.net

import okhttp3.OkHttpClient
import okhttp3.Dns
import java.net.InetSocketAddress
import java.net.Proxy
import java.util.concurrent.TimeUnit
import java.net.InetAddress

/**
 * Centralized OkHttp provider that forces traffic through a local Tor SOCKS5 proxy.
 * Replace ad-hoc OkHttpClient() usage with OkHttpProvider.torHttpClient()
 */

object OkHttpProvider {

    // Force DNS resolution to localhost so SOCKS proxy handles DNS
    private val torDns = Dns { hostname ->
        arrayOf(InetAddress.getByName("127.0.0.1"))
    }

    /**
     * Returns an OkHttpClient configured with a SOCKS proxy (default 127.0.0.1:9050).
     * Adjust timeouts per needs.
     */
    fun torHttpClient(socksHost: String = "127.0.0.1", socksPort: Int = 9050): OkHttpClient {
        val proxy = Proxy(Proxy.Type.SOCKS, InetSocketAddress(socksHost, socksPort))
        return OkHttpClient.Builder()
            .proxy(proxy)
            .dns(torDns)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .callTimeout(60, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .build()
    }

    /**
     * Convenience client for non-Tor testing (do not use in production).
     */
    fun defaultClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .build()
    }
}
