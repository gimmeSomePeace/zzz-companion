package org.zzzcompanion.features.characters.ui

import org.zzzcompanion.features.characters.data.uiModels.CharacterDetails
import org.zzzcompanion.features.characters.data.uiModels.UserCharacterDetails


sealed interface CharacterUi {
    data class Owned(val data: UserCharacterDetails) : CharacterUi
    data class Missing(val data: CharacterDetails) : CharacterUi
}