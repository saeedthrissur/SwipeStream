package com.swipestream.model

data class FeedItem(
    val id: String,
    val title: String,
    val platform: String,
    val url: String,
    val type: String // video/image/post
)
