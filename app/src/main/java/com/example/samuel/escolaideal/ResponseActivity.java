package com.example.samuel.escolaideal;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ResponseActivity extends AppCompatActivity {
    private LinearLayout completo;
    private ArrayList<Escola> listaEscola;
    private ArrayList<Integer> listaEscolaInt;
    private LinearLayout myRoot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Request window feature action bar
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response);

        completo = new LinearLayout(this);
        completo.setOrientation(LinearLayout.VERTICAL);
        myRoot = (LinearLayout) findViewById(R.id.CardLayoutContent);

        /*Resposta re = new Resposta();
        Bundle bundle = getIntent().getExtras();
        listaEscola = re.listaEscolas(bundle.getString("key1"));
        ArrayList<Escola> listaEscolaDetalhes = new ArrayList<Escola>();

        for(int e:listaEscolaInt){
            listaEscolaDetalhes.add(re.listaEscolasDetalhe(e));
        }
        listaEscola = listaEscolaDetalhes;*/


        Bundle bundle = getIntent().getExtras();
        String busca = "";
        busca = bundle.getString("key1");
        Log.e("BUSCA",busca);
        Resposta re = new Resposta();
        ArrayList<Escola> listaEscola = re.listaEscolas(busca);


        if(!(listaEscola.isEmpty())) {
            for (Escola e : listaEscola) {
                add(e);
            }
            myRoot.addView(completo);
        }else{
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Nenhuma Escola Encontrada :(")
                    .setMessage("Nenhuma escola atende aos critérios de busca.")
                    .setCancelable(false)
                    .setPositiveButton("Realizar Nova Busca", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }

                    }).setNegativeButton("Sair",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                            finishAndRemoveTask();
                        }
                    }
            ).show();
        }
    }

    public void add(Escola e){
        String[] atributos={
                "Ano do Censo: ", String.valueOf(e.getAnoCenso()),
                "Código: ", String.valueOf(e.getCod()),
                "Código da Cidade: ",String.valueOf(e.getCodCidade()),
                "Dependência Administrativa: ",e.getDependenciaAdministrativaTxt(),
                "Cidade: ",e.getCidade(),
                "Estado: ",e.getEstado(),
                "Região: ",e.getRegiao(),
                "IDEB Ano Inicial: ",String.valueOf(e.getIdebAI()),
                "IDEB Ano Final: ",String.valueOf(e.getIdebAF()),
                "Média Geral no Enem: ",String.valueOf(e.getEnemMediaGeral())
        };
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


        cardInner.addView(tv_title);

        TextView tv = new TextView(this);
        tv.setLayoutParams(new LinearLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT));

        for(int i=0;i<atributos.length;i+=2){

            SpannableStringBuilder str = new SpannableStringBuilder(atributos[i]+atributos[i+1]+System.getProperty("line.separator"));
            str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, atributos[i].length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
           tv.append(str);
        }



        cardInner.addView(tv);


        Button b = new Button(this);
        b.setText("Exibir Detalhes");
        LinearLayout ln = new LinearLayout(this);

        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);


        ln.addView(b,lp);

        cardInner.addView(ln);
        card.addView(cardInner);

        completo.addView(card);


    }


}
/*





* */