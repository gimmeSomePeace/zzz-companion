package org.gimmesomepeace.zzzcompanion.app.features.browser.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import org.gimmesomepeace.uikit.grayscale
import org.gimmesomepeace.zzzcompanion.app.features.browser.model.CharacterListItemUi
import org.gimmesomepeace.zzzcompanion.core.character.CharacterId


@Composable
fun MissingThumbCharacter(
    character: CharacterListItemUi,
    onClick: (CharacterId) -> Unit
) {
    Column(modifier = Modifier.clickable { onClick(character.id) }) {
        Box(modifier = Modifier.size(120.dp)) {
            KamelImage(
                resource = asyncPainterResource(data = character.imageUrl),
                contentDescription = "Аватар персонажа",
                modifier = Modifier.fillMaxSize(),
                colorFilter = ColorFilter.grayscale()
            )

            KamelImage(
                resource = asyncPainterResource(data = character.speciality?.imageUrl ?: ""),
                contentDescription = "Изображение специализации",
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.TopEnd)
                    .offset(x = (-4).dp, y = 4.dp),
                colorFilter = ColorFilter.grayscale()
            )

            KamelImage(
                resource = asyncPainterResource(data = character.attribute?.imageUri ?: ""),
                contentDescription = "Изображение атрибута",
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
