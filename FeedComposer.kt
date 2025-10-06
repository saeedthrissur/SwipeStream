package com.swipestream

import com.swipestream.model.FeedItem

object FeedComposer {
    // Simple composer stub: merge multiple feeds (local + online) - real implementation would be reactive
    fun mergeFeeds(vararg feeds: List<FeedItem>): List<FeedItem> {
        val result = mutableListOf<FeedItem>()
        feeds.forEach { result.addAll(it) }
        // Simple shuffle/weighting could be added here
        return result
    }
}
