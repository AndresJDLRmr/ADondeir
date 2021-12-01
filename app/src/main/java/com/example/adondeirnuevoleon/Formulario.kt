package com.example.adondeirnuevoleon

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import org.w3c.dom.Text
import java.util.*

class Formulario : AppCompatActivity() {
    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    private val user: FirebaseUser? = FirebaseAuth.getInstance().currentUser
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)
        val addComentBtn: Button = findViewById<Button>(R.id.btnRegitroComentario)
        val dateText: EditText = findViewById<EditText>(R.id.editTextDate)
        val commentText: EditText = findViewById<EditText>(R.id.commentEditText)
        //spinner
        val spinner: Spinner = findViewById(R.id.spinner)
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.planets_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }
        addComentBtn.setOnClickListener {
            val date = dateText.text.toString()
            val comment = commentText.text.toString()
            val place = spinner.selectedItem.toString()
            val userEmail = user?.email.toString()
            val addComment = hashMapOf(
                "place" to place,
                "comment" to comment,
                "date" to date,
                "postedBy" to userEmail
            )
            db.collection("comments").add(addComment)
                .addOnSuccessListener { task ->
                    Toast.makeText(this, "Comentario Añadido Exitosamente", Toast.LENGTH_LONG)
                    dateText.setText("")
                    commentText.setText("")
                }
        }
    }
    }
