package com.example.krist.newbraintest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.R.attr.data;

public class ActivitySignUp extends AppCompatActivity {

    EditText edtLoginName, edtName, edtSurname, edtPassword;
    Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        edtLoginName = (EditText)findViewById(R.id.edtLoginName);
        edtName = (EditText)findViewById(R.id.edtName);
        edtSurname = (EditText)findViewById(R.id.edtSurname);
        edtPassword = (EditText)findViewById(R.id.edtPassword);


        btnSignUp = (Button)findViewById(R.id.btnSignUp);

        //Инициализируем Firebase
        FirebaseApp.initializeApp(this);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.child(edtLoginName.getText().toString()).exists()){
                            Toast.makeText(ActivitySignUp.this, "Такой логин уже был зарегистрирован", Toast.LENGTH_SHORT).show();
                        } else {
                            User user = new User(edtName.getText().toString(), edtSurname.getText().toString(), edtPassword.getText().toString());
                            table_user.child(edtLoginName.getText().toString()).setValue(user);
                            Toast.makeText(ActivitySignUp.this, "Регистрация прошла успешно", Toast.LENGTH_SHORT).show();
                            //finish();
                            Intent chooseProject = new Intent(ActivitySignUp.this, ActivityChooseProject.class);
                            startActivity(chooseProject);
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}
