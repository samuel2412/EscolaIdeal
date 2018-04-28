package com.example.samuel.escolaideal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;


public class SearchActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

    }


    public void buscar(View view) {

        EditText teste = (EditText) findViewById(R.id.siglaText);
        String sigla = teste.getText().toString();
         Intent i = new android.content.Intent(SearchActivity.this, ResponseActivity.class);

        Bundle b = new Bundle();
	    b.putString("key1", sigla);
        i.putExtras(b);
         startActivity(i);
    }

}
