package me.gimmesomepeace.zzzcompanion.browser.factory

import com.arkivanov.decompose.ComponentContext
import me.gimmesomepeace.zzzcompanion.core.character.CharacterId
import me.gimmesomepeace.zzzcompanion.browser.CharactersBrowserComponent

interface CharactersListComponentFactory {
    fun createComponent(
        componentContext: ComponentContext,
        goToCharacterDetails: (CharacterId) -> Unit,
    ): CharactersBrowserComponent
}
