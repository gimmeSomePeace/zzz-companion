package org.gimmesomepeace.zzzcompanion.features.characters.ui

import org.gimmesomepeace.zzzcompanion.features.characters.data.uiModels.CharacterDetails
import org.gimmesomepeace.zzzcompanion.features.characters.data.uiModels.UserCharacterDetails


sealed interface CharacterUi {
    data class Owned(val data: UserCharacterDetails) : CharacterUi
    data class Missing(val data: CharacterDetails) : CharacterUi
}