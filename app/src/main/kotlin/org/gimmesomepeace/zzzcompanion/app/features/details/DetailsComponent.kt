package org.gimmesomepeace.zzzcompanion.app.features.details

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.MutableStateFlow
import org.gimmesomepeace.zzzcompanion.core.model.ids.CharacterId

class DetailsComponent(
    componentContext: ComponentContext,
    characterId: CharacterId
): ComponentContext by componentContext {
    val state = MutableStateFlow(characterId)
}