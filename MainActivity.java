package com.example.yaboyzc.oxforddictionary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText word  = findViewById(R.id.editText);
        final TextView text = findViewById(R.id.textView);
        final Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("editText", word.getText().toString());
                printCreator(text);

                //Log.d("textView", text.setText())

            }
        });


    }
    public void printCreator(TextView view) {
        //final TextView text = findViewById(R.id.textView);
        view.setText("Sherag big gay guy");
        //((TextView)findViewById(R.id.textView.).setText
    }
}
