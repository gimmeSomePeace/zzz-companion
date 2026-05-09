package org.gimmesomepeace.uikit.select

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun <T> LabeledSelect(
    label: String,
    options: List<SelectOption<T>>,
    selectedOption: SelectOption<T>,
    onOptionSelected: (T?) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(label)
        SelectBox(
            options = options,
            selectedOption = selectedOption,
            onOptionSelected = onOptionSelected
        )
    }
}
