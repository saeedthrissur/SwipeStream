package com.swipestream.extractor

import com.swipestream.model.FeedItem

interface IExtractor {
    val platform: String
    suspend fun search(query: String, filters: Map<String, String> = emptyMap()): List<FeedItem>
    suspend fun getFeed(sourceId: String, pageToken: String? = null): List<FeedItem>
    suspend fun getItem(itemId: String): FeedItem?
}
