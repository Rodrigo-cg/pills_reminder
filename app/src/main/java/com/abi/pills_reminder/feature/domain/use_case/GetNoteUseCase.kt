package com.abi.pills_reminder.feature.domain.use_case


import com.abi.pills_reminder.feature.domain.model.Note
import com.abi.pills_reminder.feature.domain.repository.NoteRepository


class GetNoteUseCase(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(id: Int): Note? {
        return repository.getNoteById(id)
    }
}