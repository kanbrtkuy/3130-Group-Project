package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class NoteEditorActivity extends AppCompatActivity {

    int noteId;
    String userID;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_editor);


        final EditText editText = findViewById(R.id.editText);

        Intent intent = getIntent();
        noteId = intent.getIntExtra("noteId", -1);

        if (noteId != -1) {
            editText.setText(Addschedule.notes.get(noteId));
        } else {
            Addschedule.notes.add("");
            noteId = Addschedule.notes.size()-1;
            Addschedule.arrayAdapter.notifyDataSetChanged();
        }

        editText.addTextChangedListener(new TextWatcher() {
            final String ediText = editText.getText().toString().trim();

            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {

                Addschedule.notes.set(noteId, String.valueOf(charSequence));
                Addschedule.arrayAdapter.notifyDataSetChanged();
                /*SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.example.project", Context.MODE_PRIVATE);
                HashSet<String> set = new HashSet<>(Addschedule.notes);
                sharedPreferences.edit().putStringSet("Note", set).apply();*/
                /*userID = fAuth.getCurrentUser().getUid();*/
                /*DocumentReference documentReference = fStore.collection("users").document(Register.userID);
                Map<String, Object> user = new HashMap<>();
                user.put("Note", editText);*/


            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }
}
