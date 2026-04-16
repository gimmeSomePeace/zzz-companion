package org.gimmesomepeace.zzzcompanion.presentation.ui.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun <T> SelectBox(
    label: String,
    options: List<T>,
    selectedOption: T,
    onOptionSelected: (T) -> Unit,
    itemContent: @Composable (T) -> Unit
) {
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
            itemContent(selectedOption)
        }

       DropdownMenu(
           expanded = expanded,
           onDismissRequest = { expanded = false }
       ) {
           options.forEach { item ->
               DropdownMenuItem(
                   onClick = {
                       onOptionSelected(item)
                       expanded = false
                   }
               ) {
                   itemContent(item)
               }
           }
       }
   }
}
