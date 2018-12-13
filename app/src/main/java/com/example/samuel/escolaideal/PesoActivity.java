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
import java.util.Arrays;

public class PesoActivity extends AppCompatActivity {
   private  ArrayList<DiscreteSeekBar> seekBars; //barras dos valores dos pesos
   private ArrayList<CheckBox> cb; //check box dos pesos
   private LatLng local; //latitude e longitude do local inserido pelo usuario
   private String localId; //String identificadora fornecida pelo google


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peso);
        //instancia um PlaceAutocompleFragment (caixa de digitação de endereço)
        PlaceAutocompleteFragment autocompleteFragment = (PlaceAutocompleteFragment)
                getFragmentManager().findFragmentById(R.id.endereco);

        //configura o listener do PlaceAutocompleteFragment
        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {

            @Override
            //Quando um endereço é selecionado, armazena lat/lon e a String idenficadora
            public void onPlaceSelected(Place place) {
                // TODO: Get info about the selected place.
                local = place.getLatLng();
                localId = place.getId();
                Log.e("ITAU", "Place: " + localId);
                Log.e("ITAU", "Place: " + local);
            }

        //Quando um erro ocorre
            @Override
            public void onError(Status status) {
                // TODO: Handle the error.
                Log.e("ITAU", "errroorroru" );
                Log.e("AUTOCOMPLETE", "An error occurred: " + status);
            }

        });
        //Sobreescreve o listener do autocomplete para qunado o ususario clicar no X presente no fragmento ele limpe as variaveis que armazenam suas informaoes
        autocompleteFragment.getView().findViewById(R.id.place_autocomplete_clear_button)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        local = null;
                        localId = null;
                        Log.e("ITAU", "Place X: " + localId);
                        Log.e("ITAU", "Place X: " + local);
                        autocompleteFragment.setText("");
                        view.setVisibility(View.GONE);

                    }
                });

        setInterface();  //metodo que monta a interface
        cb.get(0).setChecked(true); //seta distancia como true

    }

    //metodo que monta a interface
    public void setInterface() {
        seekBars = new ArrayList<DiscreteSeekBar>();
        cb = new ArrayList<CheckBox>();
        LinearLayout rl = (LinearLayout) findViewById(R.id.ln);

        //Nomes dos atributos disponiveis para uso
        String[] nomes= {
                "Distância", "Laboratório de Ciências", "Laboratório de Informática",
                "Quadra Coberta", "Quadra Descoberta", "Biblioteca", "Sala de Leitura",
                "Sanitários PNE", "Dependências PNE", "Auditório", "Computadores", "Parque Infantil",
                "Pátio Coberto", "Pátio Descoberto", "Refeitório", "Sanitário Fora do Prédio",
                "Sanitário Dentro do Prédio", "Internet", "Regime Pré-Escola", "Regime Fundamental",
                "Regime Médio", "Regime Médio Integral", "Regime Médio Médio", "Ensino EJA Fundamental",
                "Ensino EJA Médio", "Ensino EJA Para o Jovem", "Especial Creche", "Especial EJA Fundamental",
                "Especial EJA Médio", "Especial Médio Integrado", "Especial Médio Médio", "Especial Médio",
                "Especial Médio Profissional","Especial Pré-escola", "Média Geral no Enem"
        };


        Log.e("ORDEM",nomes.length+"");

        //cria um params para setar as magerns das barras de valores
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(50, 0, 50, 30);

        //cria um params para setar as magerns dos textos e checkBox
        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params2.setMargins(30, 0, 0, 0);



        //cria/adiciona os SeekBar no ArrayList
        for(int i=0;i<nomes.length;i++) {
            //instacia
            DiscreteSeekBar dsb = new DiscreteSeekBar(this);
            //seta valor maximo
            dsb.setMax(100);
            //instancia linear layout em que ficará a barra, o texto e o checkBar desta iteração
            LinearLayout combo = new LinearLayout(this);
            combo.setOrientation(LinearLayout.HORIZONTAL);

            CheckBox checkBox = new CheckBox(this);

            TextView tv = new TextView(this);
            tv.setText(nomes[i]);
            tv.setTypeface(null, Typeface.BOLD);

            //seta os params para os layouts
            combo.setLayoutParams(params2);
            dsb.setLayoutParams(params);

            //adicionam os layouts no layout pai
            combo.addView(checkBox);
            combo.addView(tv);

            //salva referencia aos checkBox e as barras em uma lista
            cb.add(checkBox);
            seekBars.add(dsb);

            //adciona os layouts no layout pai
            rl.addView(combo);
            rl.addView(dsb);


        }

    }
//metodo que segue para a proxima activity "listener do botao"
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
            values[aux] = 1+ (seek.getProgress()*100000);
            aux++;
        }


        try{
            //cria a nova activiy
            Intent i = new android.content.Intent(PesoActivity.this, SearchActivity.class);
            //cria o bundle que carrega a String da busca
            Bundle b = new Bundle();
            Log.e("VETORES", "PesoA     "+Arrays.toString(boxValues)+"\n"+Arrays.toString(values));

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