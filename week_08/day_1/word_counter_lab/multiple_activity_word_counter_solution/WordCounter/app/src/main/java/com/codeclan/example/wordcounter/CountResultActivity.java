package com.codeclan.example.wordcounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CountResultActivity extends AppCompatActivity {

    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_result);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String wordCountResult = extras.getString("wordCountResult");

        resultTextView = (TextView) findViewById(R.id.result_text_view);

        resultTextView.setText(wordCountResult);
    }

}
