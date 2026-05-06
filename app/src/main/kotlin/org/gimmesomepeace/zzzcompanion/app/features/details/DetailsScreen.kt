package org.gimmesomepeace.zzzcompanion.app.features.details

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState


@Composable
fun DetailsScreen(component: DetailsComponent) {
    val state = component.state.collectAsState()

    Column {
        Text("DetailsScreen")
        Text(state.value.toString())
    }
}