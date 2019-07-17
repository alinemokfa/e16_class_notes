package com.codeclan.example.wordcounter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by sandy on 26/10/2016.
 */
public class InputActivity extends AppCompatActivity {

    EditText editText;
    Button buttonWordCount;
    Button buttonConcordance;
    WordCounter wordCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.text_to_scan);
        buttonWordCount = (Button)findViewById(R.id.button_scan);
        buttonConcordance = (Button)findViewById(R.id.button_concordance);

        wordCounter = new WordCounter();

    }

    private void showResultsScreen(String result) {
        Intent intent = new Intent(this, CountResultActivity.class);
        intent.putExtra("wordCountResult", result);
        startActivity(intent);
    }

    public void onWordCountButtonClick(View view) {
        String textToScan = editText.getText().toString();
        Log.d("WordCounter", "Counting words in : '" + textToScan + "'");

        WordCounter wordCounter = new WordCounter();
        int numberOfWords = wordCounter.getCount(textToScan);

        String resultString = "Number of words: " + Integer.toString(numberOfWords);

        showResultsScreen(resultString);
    }

    public void onConcordanceButtonClick(View view) {
        String textToScan = editText.getText().toString();
        Log.d("WordCounter", "Creating concordance for : '" + textToScan + "'");

        WordCounterExtended wordCounter = new WordCounterExtended(textToScan);
        String resultString = wordCounter.toString();

        showResultsScreen(resultString);
    }

}
