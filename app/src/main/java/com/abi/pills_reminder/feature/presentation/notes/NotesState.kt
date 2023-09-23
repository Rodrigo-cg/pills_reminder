package com.abi.pills_reminder.feature.presentation.notes

import com.abi.pills_reminder.feature.domain.model.Note
import com.abi.pills_reminder.feature.domain.util.NoteOrder
import com.abi.pills_reminder.feature.domain.util.OrderType

data class NotesState(
    val notes:List<Note> = emptyList(),
    val noteOrder: NoteOrder =NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean=false

    )
