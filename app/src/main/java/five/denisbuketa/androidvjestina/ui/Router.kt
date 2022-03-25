package five.denisbuketa.androidvjestina.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

sealed class Screen() {
    object NotesScreen : Screen()
    object NewNotesScreen : Screen()
}

object Router {
    var currentScreen: Screen by mutableStateOf(Screen.NotesScreen)

    fun navigateTo(destination: Screen) {
        currentScreen = destination
    }
}