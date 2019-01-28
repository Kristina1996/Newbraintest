package com.example.krist.newbraintest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;

import android.view.View;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ActivityListTests extends AppCompatActivity {

    Button button;
    String id;

    private FirebaseListAdapter<Test> adapter;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    final DatabaseReference table_test = database.getReference("Test");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_tests);

        button = (Button)findViewById(R.id.button);

        displayTests();
    }

    private void displayTests() {

        ListView listTests = (ListView)findViewById(R.id.listTests);
        adapter = new FirebaseListAdapter<Test>(this, Test.class, R.layout.item_test, table_test) {
            @Override
            protected void populateView(View v, Test model, int position) {

                TextView tvName, tvScore;
                final Button button;

                tvName = (TextView)v.findViewById(R.id.tvName);
                button = (Button) v.findViewById(R.id.button);

                tvName.setText(model.getName());
                final String id = adapter.getRef(position).getKey();

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent listQuestions = new Intent(ActivityListTests.this, ActivityListQuestions.class);
                        listQuestions.putExtra("IdTest", id);
                        startActivity(listQuestions);
                    }
                });

                //id = adapter.getRef(position).getKey();

                /**button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent listQuestions = new Intent(ActivityListTests.this, ActivityListQuestions.class);
                        listQuestions.putExtra("IdTest", id);
                        startActivity(listQuestions);
                    }
                });**/
            }
        };
        listTests.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_signout)
        {
            Intent sign = new Intent(ActivityListTests.this, MainActivity.class);
            startActivity(sign);
        }

        if (item.getItemId() == R.id.menu_tests)
        {
            Intent tests = new Intent(ActivityListTests.this, ActivityListTests.class);
            startActivity(tests);
        }

        if (item.getItemId() == R.id.menu_menu)
        {
            Intent menu = new Intent(ActivityListTests.this, ActivityChooseProject.class);
            startActivity(menu);
        }
        return true;
    }
}
