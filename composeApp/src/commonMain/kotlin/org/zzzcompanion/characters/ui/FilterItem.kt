package org.zzzcompanion.characters.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource


@Composable
fun FilterItem(
    text: String,
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    Row(modifier.fillMaxWidth()) {
        KamelImage(
            resource = asyncPainterResource(data = imageUrl),
            contentDescription = null,
            modifier = Modifier.size(30.dp).align(Alignment.CenterVertically)
        )
        Text(text, style = TextStyle(), modifier = Modifier.align(Alignment.CenterVertically))
    } 
}
