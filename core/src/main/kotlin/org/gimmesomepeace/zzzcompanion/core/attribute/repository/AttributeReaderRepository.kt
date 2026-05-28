package org.gimmesomepeace.zzzcompanion.core.attribute.repository

import org.gimmesomepeace.zzzcompanion.core.attribute.Attribute
import org.gimmesomepeace.zzzcompanion.core.attribute.AttributeFilters
import org.gimmesomepeace.zzzcompanion.core.attribute.AttributeId
import org.gimmesomepeace.zzzcompanion.core.shared.repository.PaginationRepository
import org.gimmesomepeace.zzzcompanion.core.shared.repository.ReaderRepository

interface AttributeReaderRepository:
    ReaderRepository<Attribute, AttributeId>,
    PaginationRepository<Attribute, AttributeFilters>