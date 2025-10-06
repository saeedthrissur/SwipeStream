package com.swipestream.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.swipestream.data.SampleConfig

@Composable
fun SwipeStreamApp(config: SampleConfig, modifier: Modifier = Modifier) {
    // Simple scaffold for the starter: a full-screen swipe area placeholder
    Box(modifier = modifier.background(Color.Black)) {
        // Placeholder for the swipe feed
        Text(
            text = "SwipeStream — Starter (Dark AMOLED)",
            color = Color.White,
            modifier = Modifier
        )
    }
}
