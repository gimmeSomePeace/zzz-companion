package org.gimmesomepeace.zzzcompanion.core.attribute

import org.gimmesomepeace.zzzcompanion.core.shared.repository.PaginationRepository
import org.gimmesomepeace.zzzcompanion.core.shared.repository.ReaderRepository

interface AttributeRepository:
    ReaderRepository<Attribute, AttributeId>,
    PaginationRepository<Attribute, AttributeFilters>
