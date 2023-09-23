package com.abi.pills_reminder.feature.domain.use_case

import com.abi.pills_reminder.feature.domain.model.Note
import com.abi.pills_reminder.feature.domain.repository.NoteRepository


class DeleteNoteUseCase (
    private  val repository: NoteRepository
){
    suspend operator fun invoke(note: Note){
        repository.deleteNote(note)
    }
}