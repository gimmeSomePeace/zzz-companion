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
import org.zzzcompanion.characters.domain.usecase.GetCharactersStateUseCase
import org.zzzcompanion.characters.repository.AttributeRepository
import org.zzzcompanion.characters.repository.CharacterRepository
import org.zzzcompanion.characters.repository.FactionRepository
import org.zzzcompanion.characters.repository.RarityRepository
import org.zzzcompanion.characters.repository.SpecialityRepository
import org.zzzcompanion.characters.repository.UserCharacterRepository
import org.zzzcompanion.characters.ui.CharacterUiMapper
import org.zzzcompanion.characters.viewmodel.CharactersListComponent
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

    val mapper = CharacterUiMapper(
        factionRepository = factionRepository,
        specialityRepository = specialityRepository,
        attributeRepository = attributeRepository,
        rarityRepository = rarityRepository,
        characterRepository = characterRepository
    )

    val getCharactersStateUseCase = GetCharactersStateUseCase(characterRepository, userCharacterRepository)
    val component =  CharactersListComponent(
        userCharacterRepository = userCharacterRepository,
        characterRepository = characterRepository,
        factionRepository = factionRepository,
        attributeRepository = attributeRepository,
        specialityRepository = specialityRepository,
        rarityRepository = rarityRepository,

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
