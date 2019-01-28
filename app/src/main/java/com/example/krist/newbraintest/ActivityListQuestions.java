package com.example.krist.newbraintest;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ActivityListQuestions extends AppCompatActivity {

    String IdTest = "";
    String IdUser = "";

    Button btnAnswer1, btnAnswer2, btnAnswer3, btnAnswer4;
    TextView tvQuestionText;

    private FirebaseListAdapter<Question> adapter;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    final DatabaseReference table_question = database.getReference("Question");
    final DatabaseReference table_result = database.getReference("Result");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_questions);

        IdTest = getIntent().getStringExtra("IdTest");
        IdUser = getIntent().getStringExtra("IdUser");

        displayQuestions();
    }

    private void displayQuestions() {
        ListView listQuestions = (ListView) findViewById(R.id.listQuestions);

        adapter = new FirebaseListAdapter<Question>(this, Question.class, R.layout.item_question, table_question.orderByChild("id_test").equalTo(IdTest)) {
            @Override
            protected void populateView(View v, final Question model, int position) {

                TextView tvQuestionText;
                final Button btnAnswer1, btnAnswer2, btnAnswer3, btnAnswer4;

                tvQuestionText = (TextView) v.findViewById(R.id.tvQuestionText);

                btnAnswer1 = (Button) v.findViewById(R.id.btnAnswer1);
                btnAnswer2 = (Button) v.findViewById(R.id.btnAnswer2);
                btnAnswer3 = (Button) v.findViewById(R.id.btnAnswer3);
                btnAnswer4 = (Button) v.findViewById(R.id.btnAnswer4);

                tvQuestionText.setText(model.getQuestionText());

                btnAnswer1.setText(model.getAnswer1());
                btnAnswer2.setText(model.getAnswer2());
                btnAnswer3.setText(model.getAnswer3());
                btnAnswer4.setText(model.getAnswer4());

                final String IdQuestion = adapter.getRef(position).getKey();

                btnAnswer1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (model.getAnswer1().equals(model.getCorrectAnswer())) {
                            btnAnswer1.setBackgroundColor(Color.GREEN);
                        } else {btnAnswer1.setBackgroundColor(Color.RED);}

                        btnAnswer1.setEnabled(false);
                        btnAnswer2.setEnabled(false);
                        btnAnswer3.setEnabled(false);
                        btnAnswer4.setEnabled(false);
                    }
                });

                btnAnswer2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (model.getAnswer2().equals(model.getCorrectAnswer())) {
                            btnAnswer2.setBackgroundColor(Color.GREEN);
                        } else {btnAnswer2.setBackgroundColor(Color.RED);}

                        btnAnswer1.setEnabled(false);
                        btnAnswer2.setEnabled(false);
                        btnAnswer3.setEnabled(false);
                        btnAnswer4.setEnabled(false);
                    }
                });

                btnAnswer3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (model.getAnswer3().equals(model.getCorrectAnswer())) {
                            btnAnswer3.setBackgroundColor(Color.GREEN);
                        } else {btnAnswer3.setBackgroundColor(Color.RED);}

                        btnAnswer1.setEnabled(false);
                        btnAnswer2.setEnabled(false);
                        btnAnswer3.setEnabled(false);
                        btnAnswer4.setEnabled(false);
                    }
                });

                btnAnswer4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (model.getAnswer4().equals(model.getCorrectAnswer())) {
                            btnAnswer4.setBackgroundColor(Color.GREEN);
                        } else {btnAnswer4.setBackgroundColor(Color.RED);}

                        btnAnswer1.setEnabled(false);
                        btnAnswer2.setEnabled(false);
                        btnAnswer3.setEnabled(false);
                        btnAnswer4.setEnabled(false);
                    }
                });

            }
        };
        listQuestions.setAdapter(adapter);
    }
}
