package com.example.yaboyzc.oxforddictionary;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.logging.Handler;

import javax.net.ssl.HttpsURLConnection;




public class MyDictionaryRequest extends AsyncTask<String,Integer,String> {

    final String app_id = "cccd15dc";
    final String app_key = "f51721ace52300f02637f56e4865d4d0";
    String myUrl;
    Context context;


    MyDictionaryRequest(Context context) {

        this.context = context;

    }

    @Override
    protected String doInBackground(String... params) {

        myUrl = params[0];
        try {
            URL url = new URL(myUrl);
            HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.setRequestProperty("app_id", app_id);
            urlConnection.setRequestProperty("app_key", app_key);

            // read the output from the server
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();

            String line = null;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }

            return stringBuilder.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return e.toString();
        }
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        String def;
        try
        {
            JSONObject js = new JSONObject(s);
            JSONArray results = js.getJSONArray("results");

            JSONObject entries = results.getJSONObject(0);
            JSONArray aArray = entries.getJSONArray("lexicalEntries");

            JSONObject eEntries = aArray.getJSONObject(0);
            JSONArray e = eEntries.getJSONArray("entries");

            JSONObject jsonObject = e.getJSONObject(0);
            JSONArray sensesArray = jsonObject.getJSONArray("senses");

            JSONObject definition = sensesArray.getJSONObject(0);
            JSONArray de = definition.getJSONArray("definitions");

            def = de.getString(0);



            Toast.makeText(context,def,Toast.LENGTH_LONG).show();


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

}
