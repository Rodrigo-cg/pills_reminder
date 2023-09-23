package com.abi.pills_reminder.feature.presentation.notes

import com.abi.pills_reminder.feature.domain.model.Note
import com.abi.pills_reminder.feature.domain.util.NoteOrder


sealed class NotesEvent {
    data class Order(val noteOrder: NoteOrder): NotesEvent()
    data class DeleteNote(val note: Note): NotesEvent()
    object RestoreNote: NotesEvent()
    object ToggleOrderSection: NotesEvent()
}
