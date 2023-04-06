package com.example.exampleproject3withroom.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.exampleproject3withroom.R

class NoteAddActivity : AppCompatActivity() {

    lateinit var editTextTitle : EditText
    lateinit var editTextDesc : EditText
    lateinit var buttonCancel : Button
    lateinit var buttonSave : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_add)

        supportActionBar?.title = "Add Note"

        editTextTitle = findViewById(R.id.editTextNoteTitle)
        editTextDesc = findViewById(R.id.editTextNoteDesc)
        buttonCancel = findViewById(R.id.buttonCancel)
        buttonSave = findViewById(R.id.buttonSave)

        buttonCancel.setOnClickListener {
            Toast.makeText(applicationContext, "Nothing saved", Toast.LENGTH_SHORT).show()
            finish()
        }

        buttonSave.setOnClickListener {
            saveNote()
        }

    }

    fun saveNote() {

        val noteTitle : String = editTextTitle.text.toString()
        val noteDesc : String = editTextDesc.text.toString()

        val intent = Intent()
        intent.putExtra("title", noteTitle)
        intent.putExtra("desc", noteDesc)
        setResult(RESULT_OK, intent)
        finish()

    }

}