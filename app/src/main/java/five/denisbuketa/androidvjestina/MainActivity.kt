package five.denisbuketa.androidvjestina

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import five.denisbuketa.androidvjestina.navigation.Screen
import five.denisbuketa.androidvjestina.ui.*
import five.denisbuketa.androidvjestina.ui.theme.AndroidvjestinaTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidvjestinaTheme {
                val coroutineScope = rememberCoroutineScope()
                val scaffoldState: ScaffoldState = rememberScaffoldState()
                val navController = rememberNavController()

                Scaffold(
                    scaffoldState = scaffoldState,
                    topBar = { TopAppBar { Text("Android Vjestina") } },
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = Screen.Notes.route
                    ) {
                        composable(Screen.Notes.route) { NotesScreen(navController) }
                        composable(Screen.SaveNote.route) { SaveNoteScreen() }
                    }
                }
            }
        }
    }
}