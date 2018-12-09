package com.example.samuel.escolaideal;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.android.gms.maps.model.LatLng;

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;

import java.util.ArrayList;

public class PesoActivity extends AppCompatActivity {
   private  ArrayList<DiscreteSeekBar> seekBars;
   private ArrayList<CheckBox> cb;
   private LatLng local;
   private String localId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peso);

        PlaceAutocompleteFragment autocompleteFragment = (PlaceAutocompleteFragment)
                getFragmentManager().findFragmentById(R.id.endereco);


        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {

            @Override

            public void onPlaceSelected(Place place) {
                // TODO: Get info about the selected place.
                local = place.getLatLng();
                localId = place.getId();
                Log.e("ITAU", "Place: " + localId);
                Log.e("ITAU", "Place: " + local);
            }


            @Override
            public void onError(Status status) {
                // TODO: Handle the error.
                Log.e("ITAU", "errroorroru" );
                Log.e("AUTOCOMPLETE", "An error occurred: " + status);
            }
        });


        setInterface();
        cb.get(0).setChecked(true);

    }


    public void setInterface() {
        seekBars = new ArrayList<DiscreteSeekBar>();
        cb = new ArrayList<CheckBox>();
        LinearLayout rl = (LinearLayout) findViewById(R.id.ln);
        String[] nomes= {
                "Distancia","Quadra Coberta","Dependências PNE","Laboratório de Informática","Laboratório de Ciências"
                ,"Energia Pública","Água Filtrada","Pátio Coberto","Berçário","Sala de Professores","Cantina"
                ,"Quadra descoberta","Biblioteca","Sala de Leitura","Sanitários PNE","Auditório"
                ,"Computadores","Parque Infantil","Pátio Descoberto","Refeitório","Sanitário Fora do Prédio"
                ,"Sanitário Dentro do Prédio","Internet","Regime Pré-Escola","Regime Fundamental","Regime Médio"
                ,"Regime Médio Profissional","Ensino EJA Fundamental","Ensino EJA para o jovem","Especial Creche"
                ,"Especial EJA Fundamental","Especial EJA Médio","Especial Médio Integrado","Especial Médio"
                ,"Especial Médio Profissional","Especial Pré-escola","Enem"
        } ;


        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(50, 0, 50, 30);

        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params2.setMargins(30, 0, 0, 0);



        //cria/adiciona os SeekBar no ArrayList
        for(int i=0;i<nomes.length;i++) {
            DiscreteSeekBar dsb = new DiscreteSeekBar(this);
            dsb.setMax(100);
            LinearLayout combo = new LinearLayout(this);
            combo.setOrientation(LinearLayout.HORIZONTAL);

            CheckBox checkBox = new CheckBox(this);

            TextView tv = new TextView(this);
            tv.setText(nomes[i]);
            tv.setTypeface(null, Typeface.BOLD);

            combo.setLayoutParams(params2);
            dsb.setLayoutParams(params);

            //checkBox.setId(i+(nomes.length*2));
            //tv.setId(i+nomes.length);
            //dsb.setId(i);

            combo.addView(checkBox);
            combo.addView(tv);

            cb.add(checkBox);
            seekBars.add(dsb);


            rl.addView(combo);
            rl.addView(dsb);


        }

    }

    public void next(View view) {
        boolean boxValues [] = new boolean[cb.size()];
        int aux=0;
        for(CheckBox cb: cb){
            if(cb.isChecked()){
                boxValues[aux]=true;
            }else{
                boxValues[aux]=false;
            }
            aux++;
        }



        int values[] = new int[seekBars.size()];
        aux=0;
        for(DiscreteSeekBar seek:seekBars){
            values[aux] = seek.getProgress()*100000;
            aux++;
        }


        try{
            //cria a nova activiy
            Intent i = new android.content.Intent(PesoActivity.this, SearchActivity.class);
            //cria o bundle que carrega a String da busca
            Bundle b = new Bundle();
            b.putBooleanArray("booleanos", boxValues);
            b.putIntArray("pesos", values);

            b.putDouble("lat",local.latitude);
            b.putDouble("lon",local.longitude);
            b.putString("ruaId",localId);
            //Log.e("DPDADM",busca);
            i.putExtras(b);
            //inicia a proxima Activity(ResponseActivity)
            startActivity(i);

        }catch(NullPointerException e){
            Toast.makeText(this,"Insira uma rua.",Toast.LENGTH_LONG).show();
        }

    }




}