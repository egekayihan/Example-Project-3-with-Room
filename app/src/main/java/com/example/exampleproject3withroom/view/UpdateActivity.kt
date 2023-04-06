package com.example.exampleproject3withroom.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.exampleproject3withroom.R

class UpdateActivity : AppCompatActivity() {

    lateinit var editTextTitle : EditText
    lateinit var editTextDesc : EditText
    lateinit var buttonCancel : Button
    lateinit var buttonSave : Button

    var currentId = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        supportActionBar?.title = "Update Note"

        editTextTitle = findViewById(R.id.editTextNoteTitleUpdate)
        editTextDesc = findViewById(R.id.editTextNoteDescUpdate)
        buttonCancel = findViewById(R.id.buttonCancelUpdate)
        buttonSave = findViewById(R.id.buttonSaveUpdate)

        getAndSetData()

        buttonCancel.setOnClickListener {
            Toast.makeText(applicationContext, "Nothing updated", Toast.LENGTH_SHORT).show()
            finish()
        }

        buttonSave.setOnClickListener {
            updateNote()
        }

    }

    fun updateNote(){

        val updatedTitle = editTextTitle.text.toString()
        val updatedDesc = editTextDesc.text.toString()

        val intent = Intent()
        intent.putExtra("updatedTitle", updatedTitle)
        intent.putExtra("updatedDesc", updatedDesc)

        if(currentId != -1){
            intent.putExtra("noteId", currentId)
            setResult(RESULT_OK, intent)
            finish()
        }

    }

    fun getAndSetData(){

        //get
        val currentTitle = intent.getStringExtra("currentTitle")
        val currentDesc = intent.getStringExtra("currentDesc")
        currentId = intent.getIntExtra("currentId", -1)

        //set
        editTextTitle.setText(currentTitle)
        editTextDesc.setText(currentDesc)
    }

}