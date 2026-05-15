package org.gimmesomepeace.uikit.select

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun <T> SelectBox(options: List<SelectOption<T>>, selectedOption: SelectOption<T>, onOptionSelected: (T?) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { expanded = true }
    ) {
        Box(
            modifier = Modifier.fillMaxWidth().height(50.dp).padding(5.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            SelectItem(selectedOption.title, selectedOption.imageUrl)
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { item ->
                DropdownMenuItem(
                    text = { SelectItem(item.title, item.imageUrl) },
                    onClick = {
                        onOptionSelected(item.toValueOrNull())
                        expanded = false
                    }
                )
            }
        }
    }
}
