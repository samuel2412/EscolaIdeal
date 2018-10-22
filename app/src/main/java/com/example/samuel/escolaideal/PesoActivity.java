package com.example.samuel.escolaideal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

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
        seekers.add((SeekBar) findViewById(R.id.op12Peso));
        seekers.add((SeekBar) findViewById(R.id.op13Peso));
        seekers.add((SeekBar) findViewById(R.id.op14Peso));
        seekers.add((SeekBar) findViewById(R.id.op15Peso));
        seekers.add((SeekBar) findViewById(R.id.op16Peso));
        seekers.add((SeekBar) findViewById(R.id.op17Peso));
        seekers.add((SeekBar) findViewById(R.id.op18Peso));
        seekers.add((SeekBar) findViewById(R.id.op19Peso));
        seekers.add((SeekBar) findViewById(R.id.op20Peso));
        seekers.add((SeekBar) findViewById(R.id.op21Peso));
        seekers.add((SeekBar) findViewById(R.id.op22Peso));
        seekers.add((SeekBar) findViewById(R.id.op23Peso));
        seekers.add((SeekBar) findViewById(R.id.op24Peso));
        seekers.add((SeekBar) findViewById(R.id.op25Peso));
        seekers.add((SeekBar) findViewById(R.id.op26Peso));
        seekers.add((SeekBar) findViewById(R.id.op27Peso));
        seekers.add((SeekBar) findViewById(R.id.op28Peso));
        seekers.add((SeekBar) findViewById(R.id.op29Peso));
        seekers.add((SeekBar) findViewById(R.id.op30Peso));
        seekers.add((SeekBar) findViewById(R.id.op31Peso));
        seekers.add((SeekBar) findViewById(R.id.op32Peso));
        seekers.add((SeekBar) findViewById(R.id.op33Peso));
        seekers.add((SeekBar) findViewById(R.id.op34Peso));
        seekers.add((SeekBar) findViewById(R.id.op35Peso));
        seekers.add((SeekBar) findViewById(R.id.op36Peso));
        seekers.add((SeekBar) findViewById(R.id.op37Peso));
        seekers.add((SeekBar) findViewById(R.id.op38Peso));
        seekers.add((SeekBar) findViewById(R.id.op39Peso));



        int values[] = new int[seekers.size()];
        aux=0;
        for(SeekBar seek:seekers){
            values[aux] = seek.getProgress();
            aux++;
        }
        EditText et = (EditText) findViewById(R.id.endereco);
        String end = et.getText().toString();
        if( !(end.equals(""))  &&   !(end.equals("Digite sua rua."))) {
            //cria a nova activiy
            Intent i = new android.content.Intent(PesoActivity.this, SearchActivity.class);
            //cria o bundle que carrega a String da busca
            Bundle b = new Bundle();
            b.putBooleanArray("booleanos", boxValues);
            b.putIntArray("pesos", values);
            b.putString("rua", end);
            //Log.e("DPDADM",busca);
            i.putExtras(b);
            //inicia a proxima Activity(ResponseActivity)
            startActivity(i);
        }else{
            Toast.makeText(this,"Insira sua rua",Toast.LENGTH_LONG).show();
        }

    }



}