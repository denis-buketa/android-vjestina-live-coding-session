package five.denisbuketa.androidvjestina.mock

import com.raywenderlich.android.jetnotes.domain.model.ColorModel
import com.raywenderlich.android.jetnotes.domain.model.NoteModel

val mockedNotes: List<NoteModel> =
    listOf(
        NoteModel(
            id = 1,
            title = "Title 1",
            content = "Content 1",
            isCheckedOff = null,
            ColorModel.DEFAULT_COLORS[0]
        ),
        NoteModel(
            id = 2,
            title = "Title 2",
            content = "Content 2",
            isCheckedOff = true,
            ColorModel.DEFAULT_COLORS[1]
        ),
        NoteModel(
            id = 3,
            title = "Title 3",
            content = "Content 3",
            isCheckedOff = false,
            ColorModel.DEFAULT_COLORS[2]
        )
    )