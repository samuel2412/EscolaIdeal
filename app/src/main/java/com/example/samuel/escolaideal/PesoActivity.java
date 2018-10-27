package com.example.samuel.escolaideal;

import android.content.Intent;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PesoActivity extends AppCompatActivity {
    final Geocoder geocoder = new Geocoder(this);
    ArrayList<SeekBar> seekBars;
    ArrayList<LinearLayout> ln;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peso);

        seekBars = getSeekBars();
        ln = getLn();

        for (SeekBar seekBar : seekBars) {
            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                    int val = (progress * (seekBar.getWidth() - 2 * seekBar.getThumbOffset())) / seekBar.getMax();
                    TextView textView = (TextView)findViewById(R.id.valor);
                    RelativeLayout.LayoutParams params= new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);

                   // ViewGroup vc = (ViewGroup)findViewById(R.id.teste);
                    //vc.getChildAt((seekBars.indexOf(seekBar)+2)).getId(
                    params.addRule(RelativeLayout.ABOVE, ln.get( seekBars.indexOf(seekBar) ).getId() );
                    textView.setLayoutParams(params);

                    String x = "" + (progress/100000)+"%";
                    textView.setText(x);
                    textView.setX(seekBar.getX() + val + seekBar.getThumbOffset() / 2);
                    //textView.setY(100); just added a value set this properly using screen with height aspect ratio , if you do not set it by default it will be there below seek bar

                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });


        }
    }

    public ArrayList<LinearLayout> getLn() {
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
    }

    public ArrayList<SeekBar> getSeekBars() {
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

        return seekers;
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






        int values[] = new int[seekBars.size()];
        aux=0;
        for(SeekBar seek:seekBars){
            values[aux] = seek.getProgress();
            aux++;
        }
        EditText et = (EditText) findViewById(R.id.endereco);
        String end = et.getText().toString();
        if( !(end.equals(""))) {
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