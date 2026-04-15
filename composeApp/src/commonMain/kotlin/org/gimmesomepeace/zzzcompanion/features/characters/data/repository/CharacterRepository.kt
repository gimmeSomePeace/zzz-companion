package org.gimmesomepeace.zzzcompanion.features.characters.data.repository

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.gimmesomepeace.zzzcompanion.features.characters.data.entities.AttributeId
import org.gimmesomepeace.zzzcompanion.features.characters.data.entities.Character
import org.gimmesomepeace.zzzcompanion.features.characters.data.entities.CharacterId
import org.gimmesomepeace.zzzcompanion.features.characters.data.entities.FactionId
import org.gimmesomepeace.zzzcompanion.features.characters.data.entities.RarityId
import org.gimmesomepeace.zzzcompanion.features.characters.data.entities.SpecialityId


class CharacterRepository {
    private val _characters = MutableStateFlow<List<org.gimmesomepeace.zzzcompanion.features.characters.data.entities.Character>>(emptyList())
    val characters: StateFlow<List<org.gimmesomepeace.zzzcompanion.features.characters.data.entities.Character>> = _characters.asStateFlow()

    init {
        _characters.value = listOf(
            _root_ide_package_.org.gimmesomepeace.zzzcompanion.features.characters.data.entities.Character(
                _root_ide_package_.org.gimmesomepeace.zzzcompanion.features.characters.data.entities.CharacterId("1"),
                "Korin",
                _root_ide_package_.org.gimmesomepeace.zzzcompanion.features.characters.data.entities.FactionId("1"),
                _root_ide_package_.org.gimmesomepeace.zzzcompanion.features.characters.data.entities.AttributeId("1"),
                _root_ide_package_.org.gimmesomepeace.zzzcompanion.features.characters.data.entities.SpecialityId("1"),
                _root_ide_package_.org.gimmesomepeace.zzzcompanion.features.characters.data.entities.RarityId("1"),
                "https://sunderarmor.com/ZZZ/Character/thumb_corin.png"
            ),
            _root_ide_package_.org.gimmesomepeace.zzzcompanion.features.characters.data.entities.Character(
                _root_ide_package_.org.gimmesomepeace.zzzcompanion.features.characters.data.entities.CharacterId("2"),
                "Alice Thymefield",
                _root_ide_package_.org.gimmesomepeace.zzzcompanion.features.characters.data.entities.FactionId("2"),
                _root_ide_package_.org.gimmesomepeace.zzzcompanion.features.characters.data.entities.AttributeId("2"),
                _root_ide_package_.org.gimmesomepeace.zzzcompanion.features.characters.data.entities.SpecialityId("2"),
                _root_ide_package_.org.gimmesomepeace.zzzcompanion.features.characters.data.entities.RarityId("2"),
                "https://sunderarmor.com/ZZZ/Character/thumb_alice.png"
            )
        )
    }

    fun getAll(): List<org.gimmesomepeace.zzzcompanion.features.characters.data.entities.Character> { return _characters.value }
    fun getById(id: org.gimmesomepeace.zzzcompanion.features.characters.data.entities.CharacterId): org.gimmesomepeace.zzzcompanion.features.characters.data.entities.Character? = _characters.value.firstOrNull { it.id == id }
}