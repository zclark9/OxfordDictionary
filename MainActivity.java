package com.example.yaboyzc.oxforddictionary;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {

    String word;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView box = findViewById(R.id.textView);


    }

    public void requestApiButtonClick(View v) {
        //final TextView box = findViewById(R.id.textView);
        //Toast.makeText(this,box.getText().toString(),Toast.LENGTH_LONG).show();
        final EditText text = findViewById(R.id.editText);
        word = dictionaryEntries(text.getText().toString());
        MyDictionaryRequest myDictionaryRequest = new MyDictionaryRequest(this);
        myDictionaryRequest.execute(word);

    }

    private String dictionaryEntries(String s) {
        final String language = "en";
        final String word = s;
        final String word_id = word.toLowerCase();
        return "https://od-api.oxforddictionaries.com:443/api/v1/entries/" + language + "/" + word_id;
    }
}
