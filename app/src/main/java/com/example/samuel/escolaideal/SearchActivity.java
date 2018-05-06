package com.example.samuel.escolaideal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;


public class SearchActivity extends Activity {
        LinearLayout txt_help_gest;
         private String array_spinner[],array_spinner2[];

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        txt_help_gest = (LinearLayout) findViewById(R.id.expandedMenu);
        txt_help_gest.setVisibility(View.GONE);

        array_spinner=new String[4];
        array_spinner[0]="Municipal";
        array_spinner[1]="Estadual";
        array_spinner[2]="Federal";
        array_spinner[3]="Privada";
        Spinner s = (Spinner) findViewById(R.id.Spinner01);
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, array_spinner);
        s.setAdapter(adapter);

        array_spinner2=new String[4];
        array_spinner2[0]="Fundamental";
        array_spinner2[1]="Médio";
        array_spinner2[2]="Técnico";
        array_spinner2[3]="Superior";
        Spinner s2 = (Spinner) findViewById(R.id.Spinner02);
        ArrayAdapter adapter2 = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, array_spinner2);
        s2.setAdapter(adapter2);



    }


    public void buscar(View view) {

        Intent i = new android.content.Intent(SearchActivity.this, ResponseActivity.class);
        Bundle bundle = getIntent().getExtras();
        Bundle b = new Bundle();
        b.putString("key1", bundle.getString("key1"));
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
