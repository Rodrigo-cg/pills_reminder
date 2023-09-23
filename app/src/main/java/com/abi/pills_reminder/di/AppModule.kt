package com.abi.pills_reminder.di

import android.app.Application
import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.room.Room
import com.abi.pills_reminder.feature.data.data_source.NoteDatabase
import com.abi.pills_reminder.feature.data.repository.NoteRepositoryImpl
import com.abi.pills_reminder.feature.domain.repository.NoteRepository
import com.abi.pills_reminder.feature.domain.use_case.AddNotesUserCase
import com.abi.pills_reminder.feature.domain.use_case.DeleteNoteUseCase
import com.abi.pills_reminder.feature.domain.use_case.GetNoteUseCase
import com.abi.pills_reminder.feature.domain.use_case.GetNotesUseCase
import com.abi.pills_reminder.feature.domain.use_case.NoteUseCases


import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideNoteDatabase(app:Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME

        ).build()
    }
    @Provides
    @Singleton
    fun provideNoteRepository(db:NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotesUseCase = GetNotesUseCase(repository),
            deleteNoteUseCase = DeleteNoteUseCase(repository),
            addNotesUserCase = AddNotesUserCase(repository),
            getNoteUseCase = GetNoteUseCase(repository)
        )
    }
}