package org.gimmesomepeace.zzzcompanion.app.features.browser.factory

import com.arkivanov.decompose.ComponentContext
import org.gimmesomepeace.zzzcompanion.app.features.browser.CharactersListComponent

interface CharactersListComponentFactory {
    fun createComponent(componentContext: ComponentContext): CharactersListComponent
}
