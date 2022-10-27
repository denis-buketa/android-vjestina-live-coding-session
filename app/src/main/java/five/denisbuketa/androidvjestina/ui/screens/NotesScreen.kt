package five.denisbuketa.androidvjestina.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.raywenderlich.android.jetnotes.domain.model.NoteModel
import five.denisbuketa.androidvjestina.mock.mockedNotes
import five.denisbuketa.androidvjestina.navigation.Screen
import five.denisbuketa.androidvjestina.ui.components.Note

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NotesScreen(navController: NavController) {
    val notes: List<NoteModel> by remember { mutableStateOf(mockedNotes) }

    if (notes.isNotEmpty()) {
        NotesList(
            notes = notes,
            onNoteCheckedChange = {
                // TODO
            },
            onNoteClick = {
                navController.navigate(Screen.SaveNote.route)
            }
        )
    }
}

@Composable
private fun NotesList(
    notes: List<NoteModel>,
    onNoteCheckedChange: (NoteModel) -> Unit,
    onNoteClick: (NoteModel) -> Unit
) {
    LazyColumn {
        items(count = notes.size) { noteIndex ->
            val note = notes[noteIndex]
            Note(
                note = note,
                onNoteClick = onNoteClick,
                onNoteCheckedChange = onNoteCheckedChange,
                isSelected = false
            )
        }
    }
}

@Preview
@Composable
private fun NotesListPreview() {
    NotesList(
        notes = listOf(
            NoteModel(1, "Note 1", "Content 1", null),
            NoteModel(2, "Note 2", "Content 2", false),
            NoteModel(3, "Note 3", "Content 3", true)
        ),
        onNoteCheckedChange = {},
        onNoteClick = {}
    )
}