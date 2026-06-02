package me.gimmesomepeace.zzzcompanion.browser

import me.gimmesomepeace.zzzcompanion.catalog.CharactersCatalogState

internal data class CharactersBrowserState(
    val grid: CharactersCatalogState = CharactersCatalogState(),
)