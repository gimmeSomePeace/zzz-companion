package org.gimmesomepeace.zzzcompanion.app

import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import org.gimmesomepeace.zzzcompanion.app.features.browser.CharactersListComponent
import org.gimmesomepeace.zzzcompanion.app.features.browser.internal.aggregator.ReferenceAggregator
import org.gimmesomepeace.zzzcompanion.data.attribute.memory.InMemoryAttributeRepository
import org.gimmesomepeace.zzzcompanion.data.character.memory.InMemoryCharacterRepository
import org.gimmesomepeace.zzzcompanion.data.characteruserdata.memory.InMemoryCharacterUserDataRepository
import org.gimmesomepeace.zzzcompanion.data.faction.memory.InMemoryFactionRepository
import org.gimmesomepeace.zzzcompanion.data.rariry.memory.InMemoryRarityRepository
import org.gimmesomepeace.zzzcompanion.data.speciality.memory.InMemorySpecialityRepository
import org.gimmesomepeace.zzzcompanion.app.features.browser.usecase.AddCharacterToOwnedUseCase
import org.gimmesomepeace.zzzcompanion.app.features.browser.usecase.GetCharactersPageUseCase
import org.gimmesomepeace.zzzcompanion.app.features.browser.CharactersStore


fun main() {
    val lifecycle = LifecycleRegistry()
    val context = DefaultComponentContext(lifecycle = lifecycle)


    val characterRepository = InMemoryCharacterRepository()
    val factionRepository = InMemoryFactionRepository()
    val attributeRepository = InMemoryAttributeRepository()
    val specialityRepository = InMemorySpecialityRepository()
    val rarityRepository = InMemoryRarityRepository()
    val characterUserDataRepository = InMemoryCharacterUserDataRepository()

    val referenceAggregator = ReferenceAggregator(
        factionRepository = factionRepository,
        attributeRepository = attributeRepository,
        specialityRepository = specialityRepository,
        rarityRepository = rarityRepository
    )


    val addCharacterToOwnedUseCase = AddCharacterToOwnedUseCase(characterUserDataRepository)
    val getCharactersPageUseCase = GetCharactersPageUseCase(characterRepository, characterUserDataRepository)

    val charactersStore = CharactersStore(
        getCharactersPageUseCase = getCharactersPageUseCase,
        referenceAggregator = referenceAggregator,
        addCharacterToOwnedUseCase = addCharacterToOwnedUseCase,
    )

    val component = CharactersListComponent(
        componentContext = context,
        charactersStore = charactersStore,
    )

    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "ZZZ Companion",
            icon = painterResource("icon.ico"),
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
