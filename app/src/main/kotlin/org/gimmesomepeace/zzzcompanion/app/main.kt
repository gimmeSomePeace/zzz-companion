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
import org.gimmesomepeace.zzzcompanion.data.memory.attribute.InMemoryAttributeRepository
import org.gimmesomepeace.zzzcompanion.data.memory.character.InMemoryCharacterRepository
import org.gimmesomepeace.zzzcompanion.data.memory.characteruserdata.InMemoryCharacterUserDataRepository
import org.gimmesomepeace.zzzcompanion.data.memory.faction.InMemoryFactionRepository
import org.gimmesomepeace.zzzcompanion.data.memory.rarity.InMemoryRarityRepository
import org.gimmesomepeace.zzzcompanion.data.memory.speciality.InMemorySpecialityRepository
import org.gimmesomepeace.zzzcompanion.app.features.browser.usecase.AddCharacterToOwnedUseCase
import org.gimmesomepeace.zzzcompanion.app.features.browser.usecase.GetCharactersPageUseCase
import org.gimmesomepeace.zzzcompanion.app.features.browser.CharactersStore
import org.gimmesomepeace.zzzcompanion.app.features.browser.internal.aggregator.ReferenceData
import org.gimmesomepeace.zzzcompanion.core.shared.Page


fun <T> loadAllPages(loader: (cursor: String?) -> Page<T>): List<T> {
    val result = mutableListOf<T>()
    var cursor: String? = null
    do {
        val page = loader(cursor)
        result += page.items
        cursor = page.nextCursor
    } while (cursor != null)

    return result
}


fun main() {
    val lifecycle = LifecycleRegistry()
    val context = DefaultComponentContext(lifecycle = lifecycle)

    val characterRepository = InMemoryCharacterRepository()
    val factionRepository = InMemoryFactionRepository()
    val attributeRepository = InMemoryAttributeRepository()
    val specialityRepository = InMemorySpecialityRepository()
    val rarityRepository = InMemoryRarityRepository()
    val characterUserDataRepository = InMemoryCharacterUserDataRepository()

    val factions = loadAllPages {cursor ->
        factionRepository.getPage(cursor)
    }
    val attributes = loadAllPages {cursor ->
        attributeRepository.getPage(cursor)
    }
    val specialities = loadAllPages {cursor ->
        specialityRepository.getPage(cursor)
    }

    val rarities = rarityRepository.getAll()
    val refs = ReferenceData(
        factions = factions,
        attributes = attributes,
        specialities = specialities,
        rarities = rarities,

        factionsById = factions.associateBy { it.id },
        attributesById = attributes.associateBy { it.id },
        specialitiesById = specialities.associateBy { it.id },
        raritiesById = rarities.associateBy { it.id }
    )


    val addCharacterToOwnedUseCase = AddCharacterToOwnedUseCase(characterUserDataRepository)
    val getCharactersPageUseCase = GetCharactersPageUseCase(characterRepository, characterUserDataRepository)

    val charactersStore = CharactersStore(
        getCharactersPageUseCase = getCharactersPageUseCase,
        addCharacterToOwnedUseCase = addCharacterToOwnedUseCase,
        refs = refs,
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
