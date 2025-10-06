package com.swipestream.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.swipestream.model.FeedItem

@Composable
fun SwipeCard(item: FeedItem, onOpen: (FeedItem) -> Unit, modifier: Modifier = Modifier) {
    // Minimal stub for a swipe card composable
    Box(modifier = modifier.fillMaxSize()) {
        // The actual implementation would render video/image/text with overlays and gestures.
    }
}
