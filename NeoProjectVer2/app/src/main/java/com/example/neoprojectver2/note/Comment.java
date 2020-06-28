package com.example.neoprojectver2.note;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.neoprojectver2.MainActivity;
import com.example.neoprojectver2.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;

public class Comment extends AppCompatActivity {

    private FloatingActionButton fab;
    private EditText comment;

    FirebaseFirestore fStore;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_comment);

        fab = findViewById(R.id.saveCommentNote);
        comment = findViewById(R.id.commentNoteContent);

        final String scheduleId = getIntent().getStringExtra("scheduleId");
        user = FirebaseAuth.getInstance().getCurrentUser();
        fStore = FirebaseFirestore.getInstance();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DocumentReference ref = fStore.collection("schedule").
                        document(user.getUid()).collection("mySchedule").
                        document(scheduleId);

                Map<String, Object> data = new HashMap<>();
                data.put("comment", comment.getText().toString());
                ref.set(data, SetOptions.merge());
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }
}
