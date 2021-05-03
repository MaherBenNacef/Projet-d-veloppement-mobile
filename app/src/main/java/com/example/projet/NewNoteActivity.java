package com.example.projet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class NewNoteActivity extends AppCompatActivity {
    public EditText title,description,phone;
    //public static String phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_close_24);
        title=findViewById(R.id.edit_text_title);
        description=findViewById(R.id.edit_text_description);
        phone=findViewById(R.id.edit_text_phone);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.new_note_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.save:
                saveNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void saveNote(){

        String titleNote=title.getText().toString();
        String descriptionNote=description.getText().toString();
        if (titleNote.trim().isEmpty() || descriptionNote.trim().isEmpty()){
            Toast.makeText(this,"Please insert a title and description",Toast.LENGTH_LONG).show();
        return;
        }
        CollectionReference notebookRef= FirebaseFirestore.getInstance()
                .collection("Notebook");
        FirebaseAuth firebaseAuth= FirebaseAuth.getInstance();
        String userId=firebaseAuth.getCurrentUser().getUid();

        if (phone.getText().toString()!=null){
            notebookRef.add(new Note(titleNote,descriptionNote,userId,phone.getText().toString()));
            Toast.makeText(this,"Item added",Toast.LENGTH_LONG).show();
            finish();
        }else {
            Toast.makeText(this,"you must add phone number !",Toast.LENGTH_LONG).show();
        }

    }


}