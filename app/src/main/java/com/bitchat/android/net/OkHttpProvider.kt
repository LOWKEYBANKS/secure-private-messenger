package com.bitchat.android.net

import okhttp3.OkHttpClient
import okhttp3.Dns
import java.net.InetSocketAddress
import java.net.Proxy
import java.util.concurrent.TimeUnit
import java.net.InetAddress

/**
 * Provide OkHttp clients that route through a local Tor SOCKS proxy (default 127.0.0.1:9050).
 * Use OkHttpProvider.torHttpClient() everywhere you make network calls.
 */
object OkHttpProvider {

    // Basic DNS-over-Tor: we return localhost DNS (OkHttp will use the SOCKS proxy for outbound)
    private val torDns = Dns { hostname ->
        // Do not perform system DNS lookups which can leak — resolve to localhost to force SOCKS to handle DNS.
        arrayOf(InetAddress.getByName("127.0.0.1"))
    }

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
}
