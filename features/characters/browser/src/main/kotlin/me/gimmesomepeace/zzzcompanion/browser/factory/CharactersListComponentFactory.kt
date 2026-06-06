package me.gimmesomepeace.zzzcompanion.browser.factory

import com.arkivanov.decompose.ComponentContext
import me.gimmesomepeace.zzzcompanion.browser.CharactersBrowserComponent
import me.gimmesomepeace.zzzcompanion.core.character.CharacterId

interface CharactersListComponentFactory {
    fun createComponent(
        componentContext: ComponentContext,
        goToCharacterDetails: (CharacterId) -> Unit,
    ): CharactersBrowserComponent
}
