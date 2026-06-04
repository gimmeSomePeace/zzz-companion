package me.gimmesomepeace.zzzcompanion.core.attribute.repository

import me.gimmesomepeace.zzzcompanion.core.attribute.Attribute
import me.gimmesomepeace.zzzcompanion.core.attribute.AttributeFilters
import me.gimmesomepeace.zzzcompanion.core.attribute.AttributeId
import me.gimmesomepeace.zzzcompanion.core.shared.repository.PaginationRepository
import me.gimmesomepeace.zzzcompanion.core.shared.repository.ReaderRepository

interface AttributeReaderRepository :
    ReaderRepository<Attribute, AttributeId>,
    PaginationRepository<Attribute, AttributeFilters>
