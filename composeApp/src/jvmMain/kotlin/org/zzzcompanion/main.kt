package org.zzzcompanion

import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import org.jetbrains.compose.resources.painterResource
import org.zzzcompanion.features.characters.data.repository.AttributeRepository
import org.zzzcompanion.features.characters.data.repository.CharacterRepository
import org.zzzcompanion.features.characters.data.repository.FactionRepository
import org.zzzcompanion.features.characters.data.repository.RarityRepository
import org.zzzcompanion.features.characters.data.repository.ReferenceRepository
import org.zzzcompanion.features.characters.data.repository.SpecialityRepository
import org.zzzcompanion.features.characters.data.repository.UserCharacterRepository
import org.zzzcompanion.features.characters.domain.CharactersListComponent
import org.zzzcompanion.features.characters.mappers.CharacterUiMapper
import zzz_companion.composeapp.generated.resources.Res
import zzz_companion.composeapp.generated.resources.icon


fun main() {
    val lifecycle = LifecycleRegistry()
    val context = DefaultComponentContext(lifecycle = lifecycle)

    val characterRepository = CharacterRepository()
    val userCharacterRepository = UserCharacterRepository()
    val factionRepository = FactionRepository()
    val attributeRepository = AttributeRepository()
    val specialityRepository = SpecialityRepository()
    val rarityRepository = RarityRepository()

    val referenceRepository = ReferenceRepository(
        characterRepository = characterRepository,
        factionRepository = factionRepository,
        attributeRepository = attributeRepository,
        specialityRepository = specialityRepository,
        rarityRepository = rarityRepository
    )

    val mapper = CharacterUiMapper(
        factionRepository = factionRepository,
        specialityRepository = specialityRepository,
        attributeRepository = attributeRepository,
        rarityRepository = rarityRepository,
        characterRepository = characterRepository
    )

    val component = CharactersListComponent(
        userCharacterRepository = userCharacterRepository,
        referenceRepository.referenceData,
        mapper = mapper,
        componentContext = context
    )

    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "ZZZ Companion",
            icon = painterResource(Res.drawable.icon),
            state = rememberWindowState(
                width = 1200.dp,
                height = 600.dp,
                position = WindowPosition.Aligned(Alignment.Center),
            )
        ) {
            App(component)
        }
    }
}
