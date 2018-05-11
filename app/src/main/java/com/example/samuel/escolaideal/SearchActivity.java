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
         private String array_spinner[],array_spinner2[];
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



    }


    public void buscar(View view) {
        String busca="";
        Bundle bundle = getIntent().getExtras();
        busca =  "estado="+ bundle.getString("key1");
        busca += "&situacaoFuncionamento=1";


        Spinner mySpinner=(Spinner) findViewById(R.id.Spinner01);
        int dpdAdm = mySpinner.getSelectedItemPosition();
        Spinner mySpinner1=(Spinner) findViewById(R.id.Spinner02);
        int tpEnsino = mySpinner.getSelectedItemPosition();


        if(dpdAdm!=0){
            busca += "&dependenciaAdministrativa="+dpdAdm;
        }

        /*if(tpEnsino!=0){
            busca += "&tipoDeEnsino"+tpEnsino;
        }cantina=on*/

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
