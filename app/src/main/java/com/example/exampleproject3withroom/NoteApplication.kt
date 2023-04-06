package com.example.exampleproject3withroom

import android.app.Application
import com.example.exampleproject3withroom.repository.NoteRepository
import com.example.exampleproject3withroom.room.NoteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class NoteApplication : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { NoteDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { NoteRepository(database.getNoteDao()) }

}