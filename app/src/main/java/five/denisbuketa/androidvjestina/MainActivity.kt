package five.denisbuketa.androidvjestina

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import five.denisbuketa.androidvjestina.ui.NewNoteScreen
import five.denisbuketa.androidvjestina.ui.NotesScreen
import five.denisbuketa.androidvjestina.ui.Router
import five.denisbuketa.androidvjestina.ui.Screen
import five.denisbuketa.androidvjestina.ui.theme.AndroidvjestinaTheme

class MainActivity : ComponentActivity() {

    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidvjestinaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    when (Router.currentScreen) {
                        Screen.NotesScreen -> NotesScreen()
                        Screen.NewNotesScreen -> NewNoteScreen()
                    }


                }
            }
        }
    }
}