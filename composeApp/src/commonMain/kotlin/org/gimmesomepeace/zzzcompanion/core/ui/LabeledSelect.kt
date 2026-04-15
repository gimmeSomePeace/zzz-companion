package org.gimmesomepeace.zzzcompanion.core.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun <T> LabeledSelect(
    label: String,
    options: List<T>,
    selectedOption: T,
    onOptionSelected: (T) -> Unit,
    itemContent: @Composable (T) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(label)
        _root_ide_package_.org.gimmesomepeace.zzzcompanion.core.ui.SelectBox(
            label = label,
            options = options,
            selectedOption = selectedOption,
            onOptionSelected = onOptionSelected,
            itemContent = itemContent
        )
    }
}
