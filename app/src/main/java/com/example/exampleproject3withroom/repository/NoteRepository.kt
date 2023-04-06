package com.example.exampleproject3withroom.repository

import androidx.annotation.WorkerThread
import com.example.exampleproject3withroom.room.NoteDAO
import com.example.exampleproject3withroom.model.Note
import kotlinx.coroutines.flow.Flow

class NoteRepository(private val noteDao : NoteDAO) {

    val myAllNotes : Flow<List<Note>> = noteDao.getAllNotes()

    @WorkerThread
    suspend fun insert(note : Note){ noteDao.insert(note) }

    @WorkerThread
    suspend fun update(note : Note){ noteDao.update(note) }

    @WorkerThread
    suspend fun delete(note : Note){ noteDao.delete(note) }

    @WorkerThread
    suspend fun deleteAllNotes(){ noteDao.deleteAllNotes() }


}