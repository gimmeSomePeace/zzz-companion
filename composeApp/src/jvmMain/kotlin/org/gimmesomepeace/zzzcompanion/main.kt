package org.gimmesomepeace.zzzcompanion

import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import org.gimmesomepeace.zzzcompanion.features.browser.internal.aggregator.ReferenceAggregator
import org.gimmesomepeace.zzzcompanion.data.repository.AttributeRepositoryImpl
import org.gimmesomepeace.zzzcompanion.data.repository.CharacterRepositoryImpl
import org.gimmesomepeace.zzzcompanion.data.repository.CharacterUserDataRepositoryImpl
import org.gimmesomepeace.zzzcompanion.data.repository.FactionRepositoryImpl
import org.gimmesomepeace.zzzcompanion.data.repository.RarityRepositoryImpl
import org.gimmesomepeace.zzzcompanion.data.repository.SpecialityRepositoryImpl
import org.gimmesomepeace.zzzcompanion.data.storage.local.attribute.FakeAttributeLocalDataSource
import org.gimmesomepeace.zzzcompanion.data.storage.local.character.FakeCharacterLocalDataSource
import org.gimmesomepeace.zzzcompanion.data.storage.local.characteruserdata.FakeCharacterUserDataLocalDataSource
import org.gimmesomepeace.zzzcompanion.data.storage.local.faction.FakeFactionLocalDataSource
import org.gimmesomepeace.zzzcompanion.data.storage.local.rarity.FakeRarityLocalDataSource
import org.gimmesomepeace.zzzcompanion.data.storage.local.speciality.FakeSpecialityLocalDataSource
import org.gimmesomepeace.zzzcompanion.features.browser.usecase.AddCharacterToOwnedUseCase
import org.gimmesomepeace.zzzcompanion.features.browser.usecase.GetCharacterContextsUseCase
import org.gimmesomepeace.zzzcompanion.features.browser.CharactersListComponent
import org.gimmesomepeace.zzzcompanion.features.browser.CharactersStore
import org.jetbrains.compose.resources.painterResource
import zzz_companion.composeapp.generated.resources.Res
import zzz_companion.composeapp.generated.resources.icon


fun main() {
    val lifecycle = LifecycleRegistry()
    val context = DefaultComponentContext(lifecycle = lifecycle)


    val fakeCharacterLocalDataSource = FakeCharacterLocalDataSource()
    val characterRepository = CharacterRepositoryImpl(fakeCharacterLocalDataSource)

    val fakeFactionLocalDataSource = FakeFactionLocalDataSource()
    val factionRepository = FactionRepositoryImpl(fakeFactionLocalDataSource)

    val fakeAttributeLocalDataSource = FakeAttributeLocalDataSource()
    val attributeRepository = AttributeRepositoryImpl(fakeAttributeLocalDataSource)

    val fakeSpecialityLocalDataSource = FakeSpecialityLocalDataSource()
    val specialityRepository = SpecialityRepositoryImpl(fakeSpecialityLocalDataSource)

    val fakeRarityLocalDataSource = FakeRarityLocalDataSource()
    val rarityRepository = RarityRepositoryImpl(fakeRarityLocalDataSource)

    val referenceAggregator = ReferenceAggregator(
        factionRepository = factionRepository,
        attributeRepository = attributeRepository,
        specialityRepository = specialityRepository,
        rarityRepository = rarityRepository
    )

    val fakeCharacterUserDataLocalDataSource = FakeCharacterUserDataLocalDataSource()
    val characterUserDataRepository = CharacterUserDataRepositoryImpl(fakeCharacterUserDataLocalDataSource)

    val addCharacterToOwnedUseCase = AddCharacterToOwnedUseCase(characterUserDataRepository)
    val getCharacterContextsUseCase = GetCharacterContextsUseCase(characterRepository, characterUserDataRepository)

    val charactersStore = CharactersStore(
        getCharacterContextsUseCase = getCharacterContextsUseCase,
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
