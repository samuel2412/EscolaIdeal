package com.example.samuel.escolaideal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.ContextThemeWrapper;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ResponseActivity extends AppCompatActivity {
    LinearLayout completo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Request window feature action bar
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response);

        completo = new LinearLayout(this);
        completo.setOrientation(LinearLayout.VERTICAL);



        Bundle bundle = getIntent().getExtras();
        String sigla = "";
        sigla = bundle.getString("key1");
        Resposta re = new Resposta();
        ArrayList<Escola> listaEscola = re.listaEscolas(sigla);

        for(Escola e:listaEscola){
            add(e);
        }

        LinearLayout myRoot = (LinearLayout) findViewById(R.id.CardLayoutContent);
        myRoot.addView(completo);
    }
    public void add(Escola e){


        CardView card = new CardView(new ContextThemeWrapper(ResponseActivity.this, R.style.CardViewStyle), null, 0);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        int margin = 25;
        params.setMargins(margin, margin, margin, margin);
        card.setLayoutParams(params);

        LinearLayout cardInner = new LinearLayout(new ContextThemeWrapper(ResponseActivity.this, R.style.Widget_CardContent));

        TextView tv_title = new TextView(this);
        tv_title.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        tv_title.setTextAppearance(this, R.style.TextAppearance_AppCompat_Title);
        tv_title.setText(e.getNome());

        TextView tv_caption = new TextView(this);
        tv_caption.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        tv_caption.setText(e.toString());


        cardInner.addView(tv_title);
        cardInner.addView(tv_caption);
        card.addView(cardInner);

        completo.addView(card);


    }


}
/*





* */