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

   /* public ArrayList<LinearLayout> getLn() {
        ArrayList<LinearLayout> seekers = new ArrayList<LinearLayout>();
        //cria/adiciona os SeekBar no ArrayList
        seekers.add((LinearLayout) findViewById(R.id.layoutPeso1));
        seekers.add((LinearLayout) findViewById(R.id.layoutPeso2));
        seekers.add((LinearLayout) findViewById(R.id.layoutPeso3));
        seekers.add((LinearLayout) findViewById(R.id.layoutPeso4));
        seekers.add((LinearLayout) findViewById(R.id.layoutPeso5));
        seekers.add((LinearLayout) findViewById(R.id.layoutPeso6));
        seekers.add((LinearLayout) findViewById(R.id.layoutPeso7));
        seekers.add((LinearLayout) findViewById(R.id.layoutPeso8));
        seekers.add((LinearLayout) findViewById(R.id.layoutPeso9));
        seekers.add((LinearLayout) findViewById(R.id.layoutPeso10));
        seekers.add((LinearLayout) findViewById(R.id.layoutPeso11));
        seekers.add((LinearLayout) findViewById(R.id.layoutPeso12));
        seekers.add((LinearLayout) findViewById(R.id.layoutPeso13));
        seekers.add((LinearLayout) findViewById(R.id.layoutPeso14));
        seekers.add((LinearLayout) findViewById(R.id.layoutPeso15));
        seekers.add((LinearLayout) findViewById(R.id.layoutPeso16));
        seekers.add((LinearLayout) findViewById(R.id.layoutPeso17));
        seekers.add((LinearLayout) findViewById(R.id.layoutPeso18));
        seekers.add((LinearLayout) findViewById(R.id.layoutPeso19));
        seekers.add((LinearLayout) findViewById(R.id.layoutPeso20));
        seekers.add((LinearLayout) findViewById(R.id.layoutPeso21));
        seekers.add((LinearLayout) findViewById(R.id.layoutPeso22));
        seekers.add((LinearLayout) findViewById(R.id.layoutPeso23));
        seekers.add((LinearLayout) findViewById(R.id.layoutPeso24));
        seekers.add((LinearLayout) findViewById(R.id.layoutPeso25));
        seekers.add((LinearLayout) findViewById(R.id.layoutPeso26));
        seekers.add((LinearLayout) findViewById(R.id.layoutPeso27));
        seekers.add((LinearLayout) findViewById(R.id.layoutPeso28));
        seekers.add((LinearLayout) findViewById(R.id.layoutPeso29));
        seekers.add((LinearLayout) findViewById(R.id.layoutPeso30));
        seekers.add((LinearLayout) findViewById(R.id.layoutPeso31));
        seekers.add((LinearLayout) findViewById(R.id.layoutPeso32));
        seekers.add((LinearLayout) findViewById(R.id.layoutPeso33));
        seekers.add((LinearLayout) findViewById(R.id.layoutPeso34));
        seekers.add((LinearLayout) findViewById(R.id.layoutPeso35));
        seekers.add((LinearLayout) findViewById(R.id.layoutPeso36));
        seekers.add((LinearLayout) findViewById(R.id.layoutPeso37));
        seekers.add((LinearLayout) findViewById(R.id.layoutPeso38));
        seekers.add((LinearLayout) findViewById(R.id.layoutPeso39));

        return seekers;
    }*/

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
       /* ArrayList<CheckBox> boxs = new ArrayList<CheckBox>();
        boxs.add((CheckBox) findViewById(R.id.box1));
        boxs.add((CheckBox) findViewById(R.id.box2));
        boxs.add((CheckBox) findViewById(R.id.box3));
        boxs.add((CheckBox) findViewById(R.id.box4));
        boxs.add((CheckBox) findViewById(R.id.box5));
        boxs.add((CheckBox) findViewById(R.id.box6));
        boxs.add((CheckBox) findViewById(R.id.box7));
        boxs.add((CheckBox) findViewById(R.id.box8));
        boxs.add((CheckBox) findViewById(R.id.box9));
        boxs.add((CheckBox) findViewById(R.id.box10));

        boxs.add((CheckBox) findViewById(R.id.box11));
        boxs.add((CheckBox) findViewById(R.id.box12));
        boxs.add((CheckBox) findViewById(R.id.box13));
        boxs.add((CheckBox) findViewById(R.id.box14));
        boxs.add((CheckBox) findViewById(R.id.box15));
        boxs.add((CheckBox) findViewById(R.id.box16));
        boxs.add((CheckBox) findViewById(R.id.box17));
        boxs.add((CheckBox) findViewById(R.id.box18));
        boxs.add((CheckBox) findViewById(R.id.box19));
        boxs.add((CheckBox) findViewById(R.id.box20));

        boxs.add((CheckBox) findViewById(R.id.box21));
        boxs.add((CheckBox) findViewById(R.id.box22));
        boxs.add((CheckBox) findViewById(R.id.box23));
        boxs.add((CheckBox) findViewById(R.id.box24));
        boxs.add((CheckBox) findViewById(R.id.box25));
        boxs.add((CheckBox) findViewById(R.id.box26));
        boxs.add((CheckBox) findViewById(R.id.box27));
        boxs.add((CheckBox) findViewById(R.id.box28));
        boxs.add((CheckBox) findViewById(R.id.box29));
        boxs.add((CheckBox) findViewById(R.id.box30));

        boxs.add((CheckBox) findViewById(R.id.box31));
        boxs.add((CheckBox) findViewById(R.id.box32));
        boxs.add((CheckBox) findViewById(R.id.box33));
        boxs.add((CheckBox) findViewById(R.id.box34));
        boxs.add((CheckBox) findViewById(R.id.box35));
        boxs.add((CheckBox) findViewById(R.id.box36));
        boxs.add((CheckBox) findViewById(R.id.box37));
        boxs.add((CheckBox) findViewById(R.id.box38));
        boxs.add((CheckBox) findViewById(R.id.box39));
*/

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
       // EditText edittext =  (EditText) findViewById(R.id.endereco);

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