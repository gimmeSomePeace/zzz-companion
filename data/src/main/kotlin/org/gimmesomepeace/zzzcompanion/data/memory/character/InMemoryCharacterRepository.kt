package org.gimmesomepeace.zzzcompanion.data.memory.character

import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import org.gimmesomepeace.zzzcompanion.core.attribute.AttributeId
import org.gimmesomepeace.zzzcompanion.core.character.Character
import org.gimmesomepeace.zzzcompanion.core.character.CharacterFilters
import org.gimmesomepeace.zzzcompanion.core.character.CharacterId
import org.gimmesomepeace.zzzcompanion.core.character.repository.CharacterReaderRepository
import org.gimmesomepeace.zzzcompanion.core.character.repository.CharacterWriterRepository
import org.gimmesomepeace.zzzcompanion.core.faction.FactionId
import org.gimmesomepeace.zzzcompanion.core.rarity.Rarity
import org.gimmesomepeace.zzzcompanion.core.shared.repository.EntityAlreadyExistsException
import org.gimmesomepeace.zzzcompanion.core.shared.repository.EntityNotFoundException
import org.gimmesomepeace.zzzcompanion.core.shared.repository.Page
import org.gimmesomepeace.zzzcompanion.core.shared.repository.PageSize
import org.gimmesomepeace.zzzcompanion.core.speciality.SpecialityId
import org.gimmesomepeace.zzzcompanion.data.shared.paginate
import java.net.URI
import java.util.UUID
import kotlin.collections.plus
import kotlin.math.min

private const val MAX_PAGE_SIZE = 100

class InMemoryCharacterRepository :
    CharacterReaderRepository,
    CharacterWriterRepository
{
    private val mutex = Mutex()

    private var characters = listOf(
        Character.create(
            CharacterId(UUID.fromString("0f902410-e39f-440b-a0ba-4c485d3039cc")),
            "Korin",
            FactionId(UUID.fromString("f0a2b3ed-beda-4975-aa25-d9c1146ade00")),
            AttributeId(UUID.fromString("bd4779b3-36df-4280-81a8-59d77b8940ec")),
            SpecialityId(UUID.fromString("c108d8ae-7a2a-4e65-a8ed-56a721cba262")),
            Rarity.S,
            URI("https://sunderarmor.com/ZZZ/Character/thumb_corin.png")
        ),
        Character.create(
            CharacterId(UUID.fromString("c9faa28a-e555-4aa6-a219-6ac331644c0e")),
            "Alice Thymefield",
            FactionId(UUID.fromString("021583e1-1f01-488a-a842-bb2195e4cd6e")),
            AttributeId(UUID.fromString("59c71ade-975d-4cfd-b782-96560a5d6620")),
            SpecialityId(UUID.fromString("fcf982b1-67b6-4bbb-ba6f-b7d1ecab206c")),
            Rarity.A,
            URI("https://sunderarmor.com/ZZZ/Character/thumb_alice.png")
        )
    )

    override suspend fun getPage(
        pageSize: PageSize,
        cursor: String?,
        filters: CharacterFilters?
    ): Page<Character> = mutex.withLock {
        val pageSizeClamped = PageSize(min(pageSize.value, MAX_PAGE_SIZE))
        val filteredItems = if (filters != null) characters.applyFilters(filters) else characters

        return filteredItems.paginate(
            cursor = cursor,
            pageSize = pageSizeClamped,
        ) { character ->
            character.id.value.toString()
        }
    }

    override suspend fun get(id: CharacterId): Character = mutex.withLock {
        return characters.find { it.id == id } ?: throw EntityNotFoundException(Character::class, id.value)
    }

    override suspend fun find(id: CharacterId): Character? = mutex.withLock {
        return characters.find { it.id == id }
    }

    override suspend fun findByIds(
        ids: Collection<CharacterId>
    ): Map<CharacterId, Character> = mutex.withLock {
        return characters
            .filter { it.id in ids }
            .associateBy { it.id }
    }

    override suspend fun create(entity: Character) = mutex.withLock {
        if (characters.any { it.id == entity.id })
            throw EntityAlreadyExistsException(Character::class, entity.id)
        characters += entity
    }

    override suspend fun update(entity: Character) = mutex.withLock {
        val index = characters.indexOfFirst { it.id == entity.id }
        if (index == -1) throw EntityNotFoundException(Character::class, entity.id)

        characters = characters.map { if (it.id == entity.id) entity else it }
    }

    override suspend fun delete(entity: Character) = mutex.withLock {
        val sizeBefore = characters.size
        characters = characters.filter { it.id != entity.id }

        if (characters.size == sizeBefore)
            throw EntityNotFoundException(Character::class, entity.id)
    }
}
