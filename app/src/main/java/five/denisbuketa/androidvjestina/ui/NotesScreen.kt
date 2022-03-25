package five.denisbuketa.androidvjestina.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import five.denisbuketa.androidvjestina.ui.theme.Note
import five.denisbuketa.androidvjestina.ui.theme.NoteModel

@ExperimentalMaterialApi
@Composable
fun NotesScreen() {

    var notes by remember {
        mutableStateOf(
            listOf(
                NoteModel(
                    id = 1,
                    title = "Title 1",
                    content = "Content 1",
                    isCheckedOff = null,
                    Color.Red
                ),
                NoteModel(
                    id = 2,
                    title = "Title 2",
                    content = "Content 2",
                    isCheckedOff = true,
                    Color.Blue
                ),
                NoteModel(
                    id = 3,
                    title = "Title 3",
                    content = "Content 3",
                    isCheckedOff = false,
                    Color.Green
                )
            )
        )
    }

    val scaffoldState: ScaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = { Text(text = "Android Vjestina", color = MaterialTheme.colors.onPrimary) },
                navigationIcon = {
                    IconButton(onClick = {/*onClick*/ }) {
                        Icon(
                            imageVector = Icons.Filled.List,
                            contentDescription = "Drawer Button"
                        )
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { Router.navigateTo(Screen.NewNotesScreen) },
                contentColor = MaterialTheme.colors.background
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Add Note Button"
                )
            }
        }
    ) {
        if (notes.isNotEmpty()) {
            NotesList(
                notes,
                onNoteCheckedChange = { updatedNote ->
                    val index = notes.indexOfFirst { it.id == updatedNote.id }
                    notes = notes.toMutableList().apply { set(index, updatedNote) }
                },
                onNoteClick = {

                }
            )
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun NotesList(
    notes: List<NoteModel>,
    onNoteCheckedChange: (NoteModel) -> Unit,
    onNoteClick: (NoteModel) -> Unit
) {
    LazyColumn {
        items(count = notes.size) { index ->
            val note = notes[index]
            Note(
                note = note,
                onNoteClick = onNoteClick,
                onNoteCheckedChange = onNoteCheckedChange
            )
        }
    }
}

@ExperimentalMaterialApi
@Preview
@Composable
fun NotesScreenPreview() {
    NotesScreen()
}

@ExperimentalMaterialApi
@Preview
@Composable
fun NotesListPreview() {
    NotesList(
        notes = listOf(
            NoteModel(
                id = 1,
                title = "Title 1",
                content = "Content 1",
                isCheckedOff = null,
                Color.Red
            ),
            NoteModel(
                id = 2,
                title = "Title 2",
                content = "Content 2",
                isCheckedOff = true,
                Color.Blue
            ),
            NoteModel(
                id = 3,
                title = "Title 3",
                content = "Content 3",
                isCheckedOff = false,
                Color.Green
            )
        ),
        onNoteCheckedChange = {},
        onNoteClick = {}
    )
}