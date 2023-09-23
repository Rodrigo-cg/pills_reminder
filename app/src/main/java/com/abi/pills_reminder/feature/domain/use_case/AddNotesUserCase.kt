package com.abi.pills_reminder.feature.domain.use_case

import com.abi.pills_reminder.feature.domain.model.InvalidNoteException
import com.abi.pills_reminder.feature.domain.model.Note
import com.abi.pills_reminder.feature.domain.repository.NoteRepository


class AddNotesUserCase(
    private val repository: NoteRepository
) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if(note.title.isBlank()) {
            throw InvalidNoteException("The title of the note can't be empty.")
        }
        if(note.content.isBlank()) {
            throw InvalidNoteException("The content of the note can't be empty.")
        }
        repository.insertNote(note)
    }
}