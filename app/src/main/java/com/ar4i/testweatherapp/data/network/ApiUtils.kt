package com.ar4i.testweatherapp.data.network

import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class ApiUtils {
    companion object {
        val NETWORK_EXCEPTIONS = listOf(
            UnknownHostException::class.java,
            SocketTimeoutException::class.java,
            ConnectException::class.java
        )
    }
}