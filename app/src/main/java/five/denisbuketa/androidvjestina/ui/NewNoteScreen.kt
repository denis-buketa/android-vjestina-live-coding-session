package five.denisbuketa.androidvjestina.ui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun NewNoteScreen() {
    Text(text = "Hello from NewNote screen")
    BackPressHandler(onBackPressed = { Router.navigateTo(Screen.NotesScreen) })
}