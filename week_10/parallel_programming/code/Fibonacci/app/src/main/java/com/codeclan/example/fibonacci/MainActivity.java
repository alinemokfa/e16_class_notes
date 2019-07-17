package com.codeclan.example.fibonacci;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends MenuActivity {

    EditText position;
    TextView answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        position = (EditText) findViewById(R.id.position);
        answer = (TextView) findViewById(R.id.answer);

        TextView desc = (TextView) findViewById(R.id.description);



        desc.setText(R.string.non_threaded_description);
    }

    public void solve(View view){

        Edible e = new Edible() {
            @Override
            public void eat() {

            }
        };

        int i = Integer.parseInt(position.getText().toString());
        int result = Fibonacci.solve(i);

        answer.setText(Integer.toString(result));
    }
}