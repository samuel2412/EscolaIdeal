package com.example.samuel.escolaideal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;

import java.util.ArrayList;

public class PesoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peso);
    }


    public void next(View view) {
        ArrayList<CheckBox> boxs = new ArrayList<CheckBox>();
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

        boolean boxValues [] = new boolean[boxs.size()];
        int aux=0;
        for(CheckBox cb: boxs){
            if(cb.isChecked()){
                boxValues[aux]=true;
            }else{
                boxValues[aux]=false;
            }
            aux++;
        }



        ArrayList<SeekBar> seekers = new ArrayList<SeekBar>();
        //cria/adiciona os SeekBar no ArrayList
        seekers.add((SeekBar) findViewById(R.id.op1Peso));
        seekers.add((SeekBar) findViewById(R.id.op2Peso));
        seekers.add((SeekBar) findViewById(R.id.op3Peso));
        seekers.add((SeekBar) findViewById(R.id.op4Peso));
        seekers.add((SeekBar) findViewById(R.id.op5Peso));
        seekers.add((SeekBar) findViewById(R.id.op6Peso));
        seekers.add((SeekBar) findViewById(R.id.op7Peso));
        seekers.add((SeekBar) findViewById(R.id.op8Peso));
        seekers.add((SeekBar) findViewById(R.id.op9Peso));
        seekers.add((SeekBar) findViewById(R.id.op10Peso));
        seekers.add((SeekBar) findViewById(R.id.op11Peso));

        int values[] = new int[seekers.size()];
        aux=0;
        for(SeekBar seek:seekers){
            values[aux] = seek.getProgress();
            aux++;
        }
        EditText et = (EditText) findViewById(R.id.endereco);
        String end = et.getText().toString();
        //cria a nova activiy
        Intent i = new android.content.Intent(PesoActivity.this, SearchActivity.class);
        //cria o bundle que carrega a String da busca
        Bundle b = new Bundle();
        b.putBooleanArray("booleanos",boxValues);
        b.putIntArray("pesos",values);
        b.putString("rua",end);
        //Log.e("DPDADM",busca);
        i.putExtras(b);
        //inicia a proxima Activity(ResponseActivity)
        startActivity(i);


    }



}