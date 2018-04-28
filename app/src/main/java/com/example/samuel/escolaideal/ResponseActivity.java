package com.example.samuel.escolaideal;

import android.annotation.SuppressLint;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

public class ResponseActivity extends AppCompatActivity {
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_response);
        Bundle bundle = getIntent().getExtras();
        String sigla="";
        sigla= bundle.getString("key1");
        Resposta re = new Resposta();
        ArrayList<Escola> listaEscola = re.listaEscolas(sigla);
        //Log.d("ESCOLA",""+listaEscola.size());


        ScrollView scrl=new ScrollView(this);
        final LinearLayout ll=new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        scrl.addView(ll);
        for(Escola e: listaEscola) {
            GradientDrawable gd = new GradientDrawable();
            //gd.setColor(0xFF00FF00); // Changes this drawbale to use a single color instead of a gradient
            gd.setCornerRadius(5);
            gd.setStroke(1, 0xFFFFFFFF);

            TextView tv = new TextView(getApplicationContext());
            tv.setText(e.toString());
            tv.setBackground(gd);
            ll.addView(tv);
        }
        setContentView(scrl);
       }
    @SuppressLint("ResourceType")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.layout.activity_response, menu);
        return true;
    }


}
