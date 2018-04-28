package com.example.samuel.escolaideal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;

public class ResponseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response);


        Bundle bundle = getIntent().getExtras();
        String sigla="";
		sigla= bundle.getString("key1");
        Resposta re = new Resposta();
        ArrayList<Escola> listaEscola = re.listaEscolas(sigla);
        //Log.d("ESCOLA",""+listaEscola.size());
        String resultado="";
        for(Escola e: listaEscola){
            resultado+=e.toString()+"\n";
        }



        TextView responseView =findViewById(R.id.responseView);
        responseView.setText(resultado);

    }
}
