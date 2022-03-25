package five.denisbuketa.androidvjestina.ui.theme

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import five.denisbuketa.androidvjestina.ui.NoteColor

@ExperimentalMaterialApi
@Composable
fun Note(
    modifier: Modifier = Modifier,
    note: NoteModel,
    onNoteClick: (NoteModel) -> Unit = {},
    onNoteCheckedChange: (NoteModel) -> Unit = {}
) {
    Card(
        shape = RoundedCornerShape(4.dp),
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth(),
        backgroundColor = MaterialTheme.colors.surface
    ) {
        ListItem(
            text = { Text(text = note.title, maxLines = 1) },
            secondaryText = { Text(text = note.content, maxLines = 1) },
            icon = {
                NoteColor(
                    color = note.color,
                    size = 40.dp,
                    border = 1.dp
                )
            },
            trailing = {
                if (note.isCheckedOff != null) {
                    Checkbox(
                        checked = note.isCheckedOff,
                        onCheckedChange = { isChecked ->
                            val newNoteState = note.copy(isCheckedOff = isChecked)
                            onNoteCheckedChange.invoke(newNoteState)
                        },
                        modifier = Modifier.padding(8.dp)
                    )
                }
            },
            modifier = Modifier.clickable { onNoteClick.invoke(note) }
        )
    }
}

@ExperimentalMaterialApi
@Preview
@Composable
fun NotePreview() {
    Note(note = NoteModel(1, "Android Vjestina", "Napraviti prezentaciju", null, Color.Red))
}

data class NoteModel(
    val id: Long,
    val title: String,
    val content: String,
    val isCheckedOff: Boolean?,
    val color: Color
)
