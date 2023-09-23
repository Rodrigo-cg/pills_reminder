package com.abi.pills_reminder.feature.domain.use_case


data  class NoteUseCases (
    val getNotesUseCase:GetNotesUseCase,
    val deleteNoteUseCase:DeleteNoteUseCase,
    val addNotesUserCase: AddNotesUserCase,
    val getNoteUseCase: GetNoteUseCase
)