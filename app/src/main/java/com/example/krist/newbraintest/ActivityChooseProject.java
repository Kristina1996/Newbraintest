package com.example.krist.newbraintest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.unity3d.vrstandardassets.UnityPlayerActivity;

public class ActivityChooseProject extends AppCompatActivity {

    Button btnChooseUnity, btnChooseAndroid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_project);

        btnChooseUnity = (Button)findViewById(R.id.btnChooseUnity);
        btnChooseAndroid = (Button)findViewById(R.id.btnChooseAndroid);

        btnChooseUnity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityChooseProject.this, UnityPlayerActivity.class);
                startActivity(intent);
            }
        });

        btnChooseAndroid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signUp = new Intent(ActivityChooseProject.this, ActivityListTests.class);
                startActivity(signUp);
            }
        });
    }
}
