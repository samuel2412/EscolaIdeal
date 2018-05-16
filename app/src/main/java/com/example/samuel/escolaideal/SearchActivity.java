package com.example.samuel.escolaideal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;

import java.util.ArrayList;


public class SearchActivity extends Activity {
        LinearLayout txt_help_gest;
         private String array_spinner[],array_spinner2[],array_spinner3[];
    ArrayList<Escola> listaEscola = new ArrayList<Escola>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        txt_help_gest = (LinearLayout) findViewById(R.id.expandedMenu);
        txt_help_gest.setVisibility(View.GONE);

        array_spinner=new String[5];
        array_spinner[0] = "Qualquer";
        array_spinner[1]="Federal";
        array_spinner[2]="Estadual";
        array_spinner[3]="Municipal";
        array_spinner[4]="Privada";
        Spinner s = (Spinner) findViewById(R.id.Spinner01);
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, array_spinner);
        s.setAdapter(adapter);

        array_spinner2=new String[5];
        array_spinner2[0] = "Qualquer";
        array_spinner2[1]="Fundamental";
        array_spinner2[2]="Médio";
        array_spinner2[3]="Técnico";
        array_spinner2[4]="Superior";
        Spinner s2 = (Spinner) findViewById(R.id.Spinner02);
        ArrayAdapter adapter2 = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, array_spinner2);
        s2.setAdapter(adapter2);

        array_spinner3=new String [27];
        array_spinner3[0] = "SP";
        array_spinner3[1] = "AC";
        array_spinner3[2] = "AL";
        array_spinner3[3] = "AP";
        array_spinner3[4] = "AM";
        array_spinner3[5] = "BA";
        array_spinner3[6] = "CE";
        array_spinner3[7] = "DF";
        array_spinner3[8] = "ES";
        array_spinner3[9] = "GO";
        array_spinner3[10] = "MA";
        array_spinner3[11] = "MT";
        array_spinner3[12] = "MS";
        array_spinner3[13] = "MG";
        array_spinner3[14] = "PA";
        array_spinner3[15] = "PB";
        array_spinner3[16] = "PR";
        array_spinner3[17] = "PE";
        array_spinner3[18] = "PI";
        array_spinner3[19] = "RJ";
        array_spinner3[20] = "RN";
        array_spinner3[21] = "RS";
        array_spinner3[22] = "RO";
        array_spinner3[23] = "RR";
        array_spinner3[24] = "SC";
        array_spinner3[25] = "SE";
        array_spinner3[26] = "TO";
        Spinner s3 = (Spinner) findViewById(R.id.Spinner03);
        ArrayAdapter adapter3 = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, array_spinner3);
        s3.setAdapter(adapter3);


    }


    public void buscar(View view) {
        String busca="";
        //pega estado selecionaddo
        Spinner mySpinner=(Spinner) findViewById(R.id.Spinner03);
        int estado = mySpinner.getSelectedItemPosition();
        busca+="estado="+array_spinner3[estado];

        //seta para somente escolas em funcionamento aparecerem na busca
        busca += "&situacaoFuncionamento=1";

        //pega dependecnia adm selecionada
        Spinner mySpinner1=(Spinner) findViewById(R.id.Spinner01);
        int dpdAdm = mySpinner.getSelectedItemPosition();
        if(dpdAdm!=0){
            busca += "&dependenciaAdministrativa="+dpdAdm;
        }
        //pegaria o tipo de ensino se ele existisse na busca
        Spinner mySpinner2=(Spinner) findViewById(R.id.Spinner02);
        int tpEnsino = mySpinner.getSelectedItemPosition();
        /*if(tpEnsino!=0){
            busca += "&tipoDeEnsino"+tpEnsino;
        }cantina=on*/


        //ve quais switchs estão ligados e adiciona eles na busca
        String [] switchValues = {"","quadraCoberta=on","dependenciasPNE=on","laboratorioInformatica=on",
        "laboratorioCiencias=on","energiaPublica=on","aguaPublica=on","patioCoberto=on","bercario=on","salaProfessores=on"
        };

        ArrayList<Switch> switches = new ArrayList<Switch>();

        switches.add((Switch) findViewById(R.id.op1));
        switches.add((Switch) findViewById(R.id.op2));
        switches.add((Switch) findViewById(R.id.op3));
        switches.add((Switch) findViewById(R.id.op4));
        switches.add((Switch) findViewById(R.id.op5));

        switches.add((Switch) findViewById(R.id.energia));
        switches.add((Switch) findViewById(R.id.agua));
        switches.add((Switch) findViewById(R.id.patio));
        switches.add((Switch) findViewById(R.id.bercario));
        switches.add((Switch) findViewById(R.id.salaProfessores));

        for(Switch s : switches){
            if(s.isChecked()){
                busca += "&"+switchValues[switches.indexOf(s)];
            }
        }
        //cria a nova activiy
        Intent i = new android.content.Intent(SearchActivity.this, ResponseActivity.class);

        Bundle b = new Bundle();
        b.putString("key1",busca);
        Log.e("DPDADM",busca);
        i.putExtras(b);

         startActivity(i);
    }

    public void itensMenu(View view){
        Button botao = (Button) findViewById(R.id.buttonExpand);
        /*txt_help_gest.setVisibility( txt_help_gest.isShown()
                ? View.GONE
                : View.VISIBLE);
*/
        if(txt_help_gest.isShown()){
            txt_help_gest.setVisibility(View.GONE);
            botao.setText("Exibir outros atributos");
        }else{
            txt_help_gest.setVisibility(View.VISIBLE);
            botao.setText("Ocultar outros atributos");
        }



    }

}
