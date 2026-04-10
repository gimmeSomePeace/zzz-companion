package org.zzzcompanion.features.characters.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.unit.dp
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import org.zzzcompanion.core.ui.grayscale


import org.zzzcompanion.features.characters.data.uiModels.CharacterDetails


@Composable
fun MissingThumbCharacter(character: CharacterDetails) {
    Column {
        Box(modifier = Modifier.size(120.dp)) {
            KamelImage(
                resource = asyncPainterResource(data = character.imageUrl),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                colorFilter = ColorFilter.grayscale()
            )

            KamelImage(
                resource = asyncPainterResource(data = character.speciality?.imageUrl ?: ""),
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.TopEnd)
                    .offset(x = (-4).dp, y = 4.dp),
                colorFilter = ColorFilter.grayscale()
            )

            KamelImage(
                resource = asyncPainterResource(data = character.attribute?.imageUrl ?: ""),
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.TopEnd)
                    .offset(x = (-28).dp, y = 4.dp),
                colorFilter = ColorFilter.grayscale()
            )
        }
        Text(character.name)
    }
}
