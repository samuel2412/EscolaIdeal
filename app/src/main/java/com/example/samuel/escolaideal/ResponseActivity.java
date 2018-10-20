package com.example.samuel.escolaideal;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class ResponseActivity extends AppCompatActivity {
    private LinearLayout completo,linearLayout;
    private ArrayList<Escola> listaEscola = new ArrayList<Escola>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response);
        //instancia os LinearLayouts
        completo = new LinearLayout(this);
        completo.setOrientation(LinearLayout.VERTICAL);//trava a orientação da tela em vertical

        linearLayout = (LinearLayout) findViewById(R.id.CardLayoutContent);


        //Retira a string da busca do bundle passado pela SearchActivity
        Bundle bundle = getIntent().getExtras();
        String busca = bundle.getString("key1");
        //Log.e("BUSCA",busca);
        //cria uma instancia da classe Resposta
        Resposta re = new Resposta();
        //Recebe um ArrayList composto pelas escolas que foram retornadas pelo metodo de busca
        //listaEscola = re.listaEscolas(busca);

         provisorio(busca);

        //verifica se a lista esta vazia, caso esteja itera nessa lista criando CardViews para cada escola da lista.
        if(!(listaEscola.isEmpty())) {
            for (Escola e : listaEscola) {
                add(e);
            }
            linearLayout.addView(completo);
        }else{
            //lista vazia -> dispara um alerta
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
    //metodo que cria o CardView de cada escola.
    public void add(Escola e){
        final int codigo = e.getCod();// pega o codigo da escola para passar atras de bundle para o DetalheActivity
        //Vetor com as strings que estarão contidas no CardView
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
        //Instancia o CardView e seta seus atributos
        CardView card = new CardView(new ContextThemeWrapper(ResponseActivity.this, R.style.CardViewStyle), null, 0);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        //int com o valor das margens
        int margem = 25;
        //seta as 4 margens
        params.setMargins(margem, margem, margem, margem);
        card.setLayoutParams(params);
        //instancia o layout que será o intertior do CardView
        LinearLayout cardInterior = new LinearLayout(new ContextThemeWrapper(ResponseActivity.this, R.style.Widget_CardContent));
        //instancia o TextView que sera o titulo do CardView
        TextView titulo = new TextView(this);
        titulo.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        //seta a estilo do titulo e seta o texto do titulo como o nome da Escola
        titulo.setTextAppearance(this, R.style.TextAppearance_AppCompat_Title);
        titulo.setText(e.getNome());

        //adciona o titulo ao CardView
        cardInterior.addView(titulo);

        //Instancia o TextView que ira no interior do CardView
        TextView textoInterior = new TextView(this);
        textoInterior.setLayoutParams(new LinearLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT));

        for(int i=0;i<atributos.length;i+=2){
            //Forma a String que sera exibida, deixando o nome dos atributos em negrito e o atributo não.
            SpannableStringBuilder str = new SpannableStringBuilder(atributos[i]+atributos[i+1]+System.getProperty("line.separator"));
            str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, atributos[i].length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            textoInterior.append(str);
        }
        //seta o tamanho do texto
        textoInterior.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);

        //adciona o TextView ao layout cardInterior
        cardInterior.addView(textoInterior);

        /*
        Button b = new Button(this);
        b.setText("Exibir Detalhes");
        LinearLayout ln = new LinearLayout(this);

        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);


        ln.addView(b,lp);
        cardInterior.addView(ln);
        */

        //adiciona o cardInterior ao card
        card.addView(cardInterior);
        //seta o card como clicavel e seta o listener com a função chamada
       /* card.setClickable(true);
        card.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //cria a nova activiy
                        Intent i = new android.content.Intent(ResponseActivity.this, DetalheActivity.class);
                        //cria um bundle que carrega o codigo da escola
                        Bundle b = new Bundle();
                        b.putInt("Codigo",codigo);
                        i.putExtras(b);
                        //inicia a activity
                        startActivity(i);
                    }
                });*/
        //adiona o CardView montado ao LinearLayout completo
        completo.addView(card);


    }

    public void provisorio(String provisoria){
        try {
            JSONObject jsnobject = new JSONObject(provisoria);
            JSONArray jsonArray = jsnobject.getJSONArray("escola");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject escola = jsonArray.getJSONObject(i);
                Escola esc = new Escola();
                esc.setCod(escola.getInt("cod"));
                esc.setNome(escola.getString("nome"));
                esc.setAnoCenso(escola.getInt("anoCenso"));
                esc.setCodCidade(escola.getInt("codCidade"));
                esc.setSituacaoFuncionamento(escola.getInt("situacaoFuncionamento"));
                esc.setCidade(escola.getString("cidade"));
                esc.setEstado(escola.getString("estado"));
                esc.setRegiao(escola.getString("regiao"));
                esc.setSituacaoFuncionamentoTxt(escola.getString("situacaoFuncionamentoTxt"));
                esc.setDependenciaAdministrativaTxt(escola.getString("dependenciaAdministrativaTxt"));
                esc.setIdebAF(escola.getDouble("idebAF"));
                esc.setIdebAI(escola.getDouble("idebAI"));
                esc.setEnemMediaGeral(escola.getDouble("enemMediaGeral"));
                listaEscola.add(esc);
            }



        }catch (Exception e){
            Log.e("KLEENEX",e.getMessage());
            e.printStackTrace();

        }

    }



}