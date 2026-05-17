package org.gimmesomepeace.zzzcompanion.features.browser.factory

import com.arkivanov.decompose.ComponentContext
import org.gimmesomepeace.zzzcompanion.features.browser.CharactersListComponent

interface CharactersListComponentFactory {
    fun createComponent(componentContext: ComponentContext): CharactersListComponent
}
