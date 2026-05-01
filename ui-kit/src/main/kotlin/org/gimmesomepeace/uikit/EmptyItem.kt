package org.gimmesomepeace.uikit

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun EmptyItem() {
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(text = "-- Все --")
    }
}
