package com.example.samuel.escolaideal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;

import java.util.ArrayList;


public class SearchActivity extends Activity {
    LinearLayout linearLayout;
    private String array_spinner[],array_spinner2[],array_spinner3[];
    ArrayList<Escola> listaEscola = new ArrayList<Escola>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
       /* if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }*/
       //Instancia o linearLayout
        linearLayout = (LinearLayout) findViewById(R.id.expandedMenu);
        linearLayout.setVisibility(View.GONE);

        //instancia um vetor que contem as Strings que serão mostratas na tela no determinado spinner
        array_spinner=new String[5];
        array_spinner[0] = "Qualquer";
        array_spinner[1]="Federal";
        array_spinner[2]="Estadual";
        array_spinner[3]="Municipal";
        array_spinner[4]="Privada";
        //Cria o spinner
        Spinner s = (Spinner) findViewById(R.id.Spinner01);
        //carrega as informações do vetor no spinner
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, array_spinner);
        s.setAdapter(adapter);

        //instancia um vetor que contem as Strings que serão mostratas na tela no determinado spinner
        array_spinner2=new String[5];
        array_spinner2[0] = "Qualquer";
        array_spinner2[1]="Fundamental";
        array_spinner2[2]="Médio";
        array_spinner2[3]="Técnico";
        array_spinner2[4]="Superior";
        //cria o spinner
        Spinner s2 = (Spinner) findViewById(R.id.Spinner02);
        //carrega as informações do vetor no spinner
        ArrayAdapter adapter2 = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, array_spinner2);
        s2.setAdapter(adapter2);

        //instancia um vetor que contem as Strings que serão mostratas na tela no determinado spinner
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
        //cria o spinner
        Spinner s3 = (Spinner) findViewById(R.id.Spinner03);
        //carrega as informações do vetor no spinner
        ArrayAdapter adapter3 = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, array_spinner3);
        s3.setAdapter(adapter3);


    }

    //Metodo que seta a String que busca que sera enviada atraves de um bundle para a ResponseActivity
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
        int dpdAdm = mySpinner1.getSelectedItemPosition();
        if(dpdAdm!=0){
            busca += "&dependenciaAdministrativa="+dpdAdm;
        }
        //pegaria o tipo de ensino se ele existisse na busca
        Spinner mySpinner2=(Spinner) findViewById(R.id.Spinner02);
        int tpEnsino = mySpinner.getSelectedItemPosition();
        /*if(tpEnsino!=0){
            busca += "&tipoDeEnsino"+tpEnsino;
        }cantina=on*/



        //cria um vetor que contem as Strings de busca atreladas a cada Switch
        String [] switchValues = {"","quadraCoberta=on","dependenciasPNE=on","laboratorioInformatica=on",
                "laboratorioCiencias=on","energiaPublica=on","aguaPublica=on","patioCoberto=on","bercario=on","salaProfessores=on"
        };
        //cria um ArrayList de Switch
        ArrayList<Switch> switches = new ArrayList<Switch>();
        //cria/adiciona os swithcs no ArrayList
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

        //ve quais switchs estão ligados e adiciona eles na busca
        for(Switch s : switches){
            if(s.isChecked()){
                busca += "&"+switchValues[switches.indexOf(s)];
            }
        }
        //cria a nova activiy
        Intent i = new android.content.Intent(SearchActivity.this, ResponseActivity.class);
        //cria o bundle que carrega a String da busca
        Bundle b = new Bundle();
        b.putString("key1",busca);
        //Log.e("DPDADM",busca);
        i.putExtras(b);
        //inicia a proxima Activity(ResponseActivity)
        startActivity(i);
    }

    //metodo que exibi ou oculta alguns parametros da busca
    public void itensMenu(View view){
        Button botao = (Button) findViewById(R.id.buttonExpand);
        if(linearLayout.isShown()){//se as informações estão sendo exibidas -> oculta elas
            linearLayout.setVisibility(View.GONE);
            botao.setText("Exibir outros atributos");
        }else{//se as informações estão ocultadas -> exibi elas
            linearLayout.setVisibility(View.VISIBLE);
            botao.setText("Ocultar outros atributos");
        }



    }

}
