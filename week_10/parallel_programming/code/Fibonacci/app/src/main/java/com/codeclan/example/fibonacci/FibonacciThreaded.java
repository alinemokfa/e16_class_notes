package com.codeclan.example.fibonacci;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FibonacciThreaded extends MenuActivity {

    EditText position;
    TextView answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        position = (EditText) findViewById(R.id.position);
        answer = (TextView) findViewById(R.id.answer);

        TextView desc = (TextView) findViewById(R.id.description);
        desc.setText(R.string.threaded_description);
    }

    public void solve(View view){
        Toast.makeText(this, R.string.waiting_for_answer, Toast.LENGTH_LONG).show();

        final int i = Integer.parseInt(position.getText().toString());

        //Anonoymous inner class (Runnable)





        new Thread(new Runnable(){
            @Override
            public void run() {
                final int result = Fibonacci.solve(i);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        answer.setText(Integer.toString(result));
                    }
                });
            }
        }).start();
    }
}
