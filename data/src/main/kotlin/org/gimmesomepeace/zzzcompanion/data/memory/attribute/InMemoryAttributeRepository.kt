package org.gimmesomepeace.zzzcompanion.data.memory.attribute

import org.gimmesomepeace.zzzcompanion.core.attribute.Attribute
import org.gimmesomepeace.zzzcompanion.core.attribute.AttributeFilters
import org.gimmesomepeace.zzzcompanion.core.attribute.AttributeId
import org.gimmesomepeace.zzzcompanion.core.attribute.repository.AttributeReaderRepository
import org.gimmesomepeace.zzzcompanion.core.attribute.repository.AttributeWriterRepository
import org.gimmesomepeace.zzzcompanion.core.shared.repository.PageSize
import org.gimmesomepeace.zzzcompanion.data.memory.InMemoryRepository

private const val MAX_PAGE_SIZE = 100

class InMemoryAttributeRepository :
    InMemoryRepository<AttributeId, Attribute, AttributeFilters>({it.id}, Attribute::class, PageSize(MAX_PAGE_SIZE)),
    AttributeReaderRepository,
    AttributeWriterRepository
{
}
