package org.gimmesomepeace.zzzcompanion

import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import org.gimmesomepeace.zzzcompanion.aggregator.ReferenceAggregator
import org.gimmesomepeace.zzzcompanion.data.repository.DefaultAttributeRepository
import org.gimmesomepeace.zzzcompanion.data.repository.DefaultCharacterRepository
import org.gimmesomepeace.zzzcompanion.data.repository.DefaultFactionRepository
import org.gimmesomepeace.zzzcompanion.data.repository.DefaultOwnedCharacterRepository
import org.gimmesomepeace.zzzcompanion.data.repository.DefaultRarityRepository
import org.gimmesomepeace.zzzcompanion.data.repository.DefaultSpecialityRepository
import org.gimmesomepeace.zzzcompanion.data.storage.local.attribute.FakeAttributeLocalDataSource
import org.gimmesomepeace.zzzcompanion.data.storage.local.character.FakeCharacterLocalDataSource
import org.gimmesomepeace.zzzcompanion.data.storage.local.faction.FakeFactionLocalDataSource
import org.gimmesomepeace.zzzcompanion.data.storage.local.ownedcharacter.FakeOwnedCharacterLocalDataSource
import org.gimmesomepeace.zzzcompanion.data.storage.local.rarity.FakeRarityLocalDataSource
import org.gimmesomepeace.zzzcompanion.data.storage.local.speciality.FakeSpecialityLocalDataSource
import org.gimmesomepeace.zzzcompanion.data.util.UuidIdGenerator
import org.gimmesomepeace.zzzcompanion.domain.usecase.AddCharacterToOwnedUseCase
import org.gimmesomepeace.zzzcompanion.domain.usecase.GetCharacterContextsUseCase
import org.gimmesomepeace.zzzcompanion.presentation.component.CharactersListComponent
import org.gimmesomepeace.zzzcompanion.presentation.component.CharactersActionHandler
import org.gimmesomepeace.zzzcompanion.presentation.component.CharactersStore
import org.gimmesomepeace.zzzcompanion.presentation.filter.CharactersFilterController
import org.jetbrains.compose.resources.painterResource
import zzz_companion.composeapp.generated.resources.Res
import zzz_companion.composeapp.generated.resources.icon


fun main() {
    val lifecycle = LifecycleRegistry()
    val context = DefaultComponentContext(lifecycle = lifecycle)


    val fakeCharacterLocalDataSource = FakeCharacterLocalDataSource()
    val characterRepository = DefaultCharacterRepository(fakeCharacterLocalDataSource)

    val fakeOwnedLocalDataSource = FakeOwnedCharacterLocalDataSource()
    val ownedCharacterRepository = DefaultOwnedCharacterRepository(fakeOwnedLocalDataSource)

    val fakeFactionLocalDataSource = FakeFactionLocalDataSource()
    val factionRepository = DefaultFactionRepository(fakeFactionLocalDataSource)

    val fakeAttributeLocalDataSource = FakeAttributeLocalDataSource()
    val attributeRepository = DefaultAttributeRepository(fakeAttributeLocalDataSource)

    val fakeSpecialityLocalDataSource = FakeSpecialityLocalDataSource()
    val specialityRepository = DefaultSpecialityRepository(fakeSpecialityLocalDataSource)

    val fakeRarityLocalDataSource = FakeRarityLocalDataSource()
    val rarityRepository = DefaultRarityRepository(fakeRarityLocalDataSource)

    val referenceAggregator = ReferenceAggregator(
        factionRepository = factionRepository,
        attributeRepository = attributeRepository,
        specialityRepository = specialityRepository,
        rarityRepository = rarityRepository
    )


    val idGenerator = UuidIdGenerator()
    val addCharacterToOwnedUseCase = AddCharacterToOwnedUseCase(ownedCharacterRepository, idGenerator)
    val getCharacterContextsUseCase = GetCharacterContextsUseCase(characterRepository, ownedCharacterRepository)

    val charactersActionHandler = CharactersActionHandler(addCharacterToOwnedUseCase)
    val filterController = CharactersFilterController()

    val charactersStore = CharactersStore(
        getCharacterContextsUseCase = getCharacterContextsUseCase,
        referenceAggregator = referenceAggregator,
        filterController = filterController,
        addCharacterToOwnedUseCase = addCharacterToOwnedUseCase,
    )

    val component = CharactersListComponent(
        actionHandler = charactersActionHandler,
        componentContext = context,
        charactersStore = charactersStore,
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
