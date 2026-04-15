package org.zzzcompanion

import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import org.gimmesomepeace.zzzcompanion.App
import org.gimmesomepeace.zzzcompanion.features.characters.data.repository.AttributeRepository
import org.gimmesomepeace.zzzcompanion.features.characters.data.repository.CharacterRepository
import org.gimmesomepeace.zzzcompanion.features.characters.data.repository.FactionRepository
import org.gimmesomepeace.zzzcompanion.features.characters.data.repository.RarityRepository
import org.gimmesomepeace.zzzcompanion.features.characters.data.repository.ReferenceRepository
import org.gimmesomepeace.zzzcompanion.features.characters.data.repository.SpecialityRepository
import org.gimmesomepeace.zzzcompanion.features.characters.data.repository.UserCharacterRepository
import org.gimmesomepeace.zzzcompanion.features.characters.domain.CharactersFilterMatcher
import org.gimmesomepeace.zzzcompanion.features.characters.domain.CharactersListComponent
import org.gimmesomepeace.zzzcompanion.features.characters.presentation.CharactersActionHandler
import org.gimmesomepeace.zzzcompanion.features.characters.presentation.CharactersFilterController
import org.gimmesomepeace.zzzcompanion.features.characters.presentation.CharactersPresenter
import org.jetbrains.compose.resources.painterResource
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

    val charactersActionHandler = CharactersActionHandler(userCharacterRepository)
    val filterController = CharactersFilterController()
    val matcher = CharactersFilterMatcher()
    val charactersPresenter = CharactersPresenter(
        matcher = matcher,
    )

    val component = CharactersListComponent(
        userCharacterRepository = userCharacterRepository,
        referenceData = referenceRepository.referenceData,
        actionHandler = charactersActionHandler,
        componentContext = context,
        charactersPresenter = charactersPresenter,
        filterController = filterController
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
