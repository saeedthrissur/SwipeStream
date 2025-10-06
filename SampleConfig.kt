package com.swipestream.data

data class SampleConfig(
    val appName: String = "SwipeStream",
    val theme: String = "dark_amoled",
    val mode: String = "mixed"
) {
    companion object {
        fun defaultConfig() = SampleConfig()
    }
}
