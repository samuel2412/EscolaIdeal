package com.example.samuel.escolaideal;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import br.com.matheus.coordenadas.principal.Local;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class ResponseActivity extends AppCompatActivity {
    private LinearLayout completo,linearLayout;
    private List<Escola> listaEscola=new ArrayList<Escola>();


    boolean boxValues [];
    int values[];
    double lat,lon;
    String codMunicipio="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response);
        //instancia os LinearLayouts
        completo = new LinearLayout(this);
        completo.setOrientation(LinearLayout.VERTICAL);//trava a orientação da tela em vertical

        linearLayout = (LinearLayout) findViewById(R.id.CardLayoutContent);



        //Retira a string da busca do bundle passado pela SearchActivity
        Bundle extras = getIntent().getExtras();

        boxValues = extras.getBooleanArray("booleanos");
        values = extras.getIntArray("pesos");
        lat = extras.getDouble("lat");
        lon = extras.getDouble("lon");
        codMunicipio = extras.getString("municipio");

        //carrega a lista de escolas do servidor
        try {
            run();
        } catch (Exception e) {
            Log.e("GAP","erro",e.getCause());
            e.printStackTrace();
        }



    }
    @Override
    public void onBackPressed() {
        Intent i = new Intent(ResponseActivity.this, PesoActivity.class);

        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);

        startActivity(i);
    }



    public void setInterface(){

        //verifica se a lista esta vazia, caso esteja itera nessa lista criando CardViews para cada escola da lista.
        if(!(listaEscola.isEmpty())) {
            for(int i=0;i<10;i++){
                add(listaEscola.get(i),i);
            }
            //for (Escola e : listaEscola) {
            //    add(e);
           // }
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
    public void add(Escola e,int indice){
        final int codigo = e.getCod();// pega o codigo da escola para passar atras de bundle para o DetalheActivity
        //Vetor com as strings que estarão contidas no CardView
        String[] atributos={
                "Município: ",e.getNomeMunicipio(),
                "Dependencia Administrativa: ",e.getDependenciaAdministrativaTxt(),
                "Creche: ",""+e.isRegCreche(),
                "Ensino Fundamental: ",""+e.isRegFundamental8(),
                "Ensino Médio: ",""+e.isRegMedioMedio(),
                "EJA: ",""+e.isEnsinoEja(),
                "Nota do Enem: ",""+ Math.round(e.getEnemMediaGeral())
        };
        e.setAtributos(atributos);
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
        titulo.setText(indice+1+".    "+e.getNome());

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
        card.setClickable(true);
        card.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        // cria a nova activiy
                        Intent i = new android.content.Intent(ResponseActivity.this, DetalheActivity.class);
                        //cria um bundle que carrega o codigo da escola
                        Bundle b = new Bundle();
                        b.putSerializable("school",e);
                        b.putDouble("lat",lat);
                        b.putDouble("lon",lon);
                        i.putExtras(b);
                        //inicia a activity
                        startActivity(i);
                    }
                });
        //adiona o CardView montado ao LinearLayout completo
        completo.addView(card);


    }

    void run() throws IOException {

        OkHttpClient client = new OkHttpClient();


        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        String url ="https://a5fui2lw3d.execute-api.us-east-1.amazonaws.com/demo/teste";
        String name = "\"john\"";
        String json =   "{" +
                            "\"queryStringParameters\":" +
                                "{" +
                                    " \"latitude\": \""+lat+"\"," +
                                    "\"longitude\": \""+lon+"\"," +
                                     "\"range\": \"3.5\"," +
                                    "\"m_codMunicipio\":  \""+codMunicipio+"\"" +
                                "}" +
                        "}";
       // {queryStringParameters":{"latitude": x,"longitude": y,"range": 3.5,"m_codMunicipio": z}}
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();


    Log.e("GAP",json);





       /*RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("m_codMunicipio", codMunicipio)
                .build();

        Request request = new Request.Builder()
                .url(BASE_URL)
                .post(requestBody)
                .build();






       Request request = new Request.Builder()
                .url("https://a5fui2lw3d.execute-api.us-east-1.amazonaws.com/demo/teste")
                .build();
                */
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                call.cancel();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                final String myResponse = response.body().string();

                ResponseActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Log.e("GAP",""+myResponse);
                            JSONArray jsonArray = new JSONArray(myResponse);

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject escola = jsonArray.getJSONObject(i);

                                Escola e = new Escola();

                                e.setCod(escola.getInt("cod"));
                                e.setAnoCenso(escola.getInt("anoCenso"));
                                e.setNome(escola.getString("nome"));
                                e.setSituacaoFuncionamento(escola.getInt("situacaoFuncionamento"));
                                e.setSituacaoCenso(escola.getInt("situacaoCenso"));
                                e.setInicioAno(escola.getString("inicioAno"));
                                e.setFimAno(escola.getString("fimAno"));
                                //e.setCidade(escola.getString("codCidade"));
                                //e.setCodUf(escola.getInt("codEstado"));
                               // e.setSiglaUf(escola.getString("sigla"));
                                e.setCodMunicipio(escola.getInt("codMunicipio"));
                                e.setNomeMunicipio(escola.getString("nomeMunicipio"));
                                e.setCodDistrito(escola.getInt("codDistrito"));
                                e.setNomeDistrito(escola.getString("nomeDistrito"));
                                //e.setRegiao(escola.getString("regiao"));
                                e.setDependenciaAdministrativa(escola.getInt("dependenciaAdiministrativa"));
                                e.setTipoLocalizacao(escola.getInt("tipoLocalizacao"));
                                e.setRegulamentada(escola.getInt("regulamentada"));
                                e.setAguaFiltrada(converteBoolean(""+escola.getInt("aguaFiltrada")));
                                e.setAguaPublica(converteBoolean(""+escola.getInt("aguaPublica")));
                                e.setAguaPocoArtesiano(converteBoolean(""+escola.getInt("aguaPocoArtesiano")));
                                e.setAguaCacimba(converteBoolean(""+escola.getInt("aguaCacimba")));
                                e.setAguaRio(converteBoolean(""+escola.getInt("aguaRio")));
                                e.setAguaInexistente(converteBoolean(""+escola.getInt("aguaInexistente")));
                                e.setEnergiaPublica(converteBoolean(""+escola.getInt("energiaPublica")));
                                e.setEnergiaGerador(converteBoolean(""+escola.getInt("energiaGerador")));
                                e.setEnergiaOutros(converteBoolean(""+escola.getInt("energiaOutros")));
                                e.setEnergiaInexistente(converteBoolean(""+escola.getInt("energiaInexistente")));
                                e.setEsgotoPublico(converteBoolean(""+escola.getInt("esgotoPublico")));
                                e.setEsgotoFossa(converteBoolean(""+escola.getInt("esgotoFossa")));
                                e.setEsgotoInexistente(converteBoolean(""+escola.getInt("esgotoInexistente")));
                                e.setLixoColetaPeriodica(converteBoolean(""+escola.getInt("lixoColetaPeriodica")));
                                e.setLixoQueima(converteBoolean(""+escola.getInt("lixoQueima")));
                                e.setLixoJogaOutraArea(converteBoolean(""+escola.getInt("lixoJogaOutraArea")));
                                e.setLixoRecicla(converteBoolean(""+escola.getInt("lixoRecicla")));
                                e.setLixoEnterra(converteBoolean(""+escola.getInt("lixoEnterra")));
                                e.setLixoOutros(converteBoolean(""+escola.getInt("lixoOutros")));
                                e.setSalaDiretoria(converteBoolean(""+escola.getInt("salaDiretoria")));
                                e.setSalaProfessores(converteBoolean(""+escola.getInt("salaProfessores")));
                                e.setLaboratorioInformatica(converteBoolean(""+escola.getInt("laboratorioInformatica")));
                                e.setLaboratorioCiencias(converteBoolean(""+escola.getInt("laboratorioCiencias")));
                                e.setAtendimentoEspecial(converteBoolean(""+escola.getInt("atendimentoEspecial")));
                                e.setQuadraCoberta(converteBoolean(""+escola.getInt("quadraCoberta")));
                                e.setQuadraDescoberta(converteBoolean(""+escola.getInt("quadraDescoberta")));
                                e.setCozinha(converteBoolean(""+escola.getInt("cozinha")));
                                e.setBiblioteca(converteBoolean(""+escola.getInt("biblioteca")));
                                e.setSalaLeitura(converteBoolean(""+escola.getInt("salaLeitura")));
                                e.setParqueInfantil(converteBoolean(""+escola.getInt("parqueInfantil")));
                                e.setBercario(converteBoolean(""+escola.getInt("bercario")));
                                e.setSanitarioForaPredio(converteBoolean(""+escola.getInt("sanitarioForaPredio")));
                                e.setSanitarioDentroPredio(converteBoolean(""+escola.getInt("sanitarioDentroPredio")));
                                e.setSanitarioEducInfant(converteBoolean(""+escola.getInt("sanitarioEducInfant")));
                                e.setSanitarioPNE(converteBoolean(""+escola.getInt("sanitarioPNE")));
                                e.setDependenciasPNE(converteBoolean(""+escola.getInt("dependenciasPNE")));
                                e.setSecretaria(converteBoolean(""+escola.getInt("secretaria")));
                                e.setBanheiroChuveiro(converteBoolean(""+escola.getInt("banheiroChuveiro")));
                                e.setRefeitorio(converteBoolean(""+escola.getInt("refeitorio")));
                                e.setDespensa(converteBoolean(""+escola.getInt("despensa")));
                                e.setAlmoxarifado(converteBoolean(""+escola.getInt("almoxarifado")));
                                e.setAuditorio(converteBoolean(""+escola.getInt("auditorio")));
                                e.setPatioCoberto(converteBoolean(""+escola.getInt("patioCoberto")));
                                e.setPatioDescoberto(converteBoolean(""+escola.getInt("patioDescoberto")));
                                e.setAlojamentoAluno(converteBoolean(""+escola.getInt("alojamentoAluno")));
                                e.setAlojamentoProfessor(converteBoolean(""+escola.getInt("alojamentoProfessor")));
                                e.setAreaVerde(converteBoolean(""+escola.getInt("areaVerde")));
                                e.setLavanderia(converteBoolean(""+escola.getInt("lavanderia")));
                                e.setSalasExistentes(escola.getInt("salasExistentes"));
                                e.setSalasUtilizadas(escola.getInt("salasUtilizadas"));
                                e.setTelevisores(escola.getInt("televisores"));
                                e.setVideoCassetes(escola.getInt("videoCassetes"));
                                e.setDvds(escola.getInt("dvds"));
                                e.setParabolicas(escola.getInt("parabolicas"));
                                e.setCopiadoras(escola.getInt("copiadoras"));
                                e.setRetroprojetores(escola.getInt("retroprojetores"));
                                e.setImpressoras(escola.getInt("impressoras"));
                                e.setAparelhosSom(escola.getInt("aparelhosSom"));
                                e.setDatashows(escola.getInt("datashows"));
                                e.setFax(escola.getInt("fax"));
                                e.setFoto(escola.getInt("foto"));
                                e.setComputadores(escola.getInt("computadores"));
                                e.setComputadoresAdm(escola.getInt("computadoresAdm"));
                                e.setComputadoresAlunos(escola.getInt("computadoresAlunos"));
                                e.setInternet(converteBoolean(""+escola.getInt("internet")));
                                e.setBandaLarga(converteBoolean(""+escola.getInt("bandaLarga")));
                                e.setFuncionarios(escola.getInt("funcionarios"));
                                e.setAlimentacao(converteBoolean(""+escola.getInt("alimentacao")));
                                e.setAee(converteBoolean(""+escola.getInt("aee")));
                                e.setAtividadeComplementar(escola.getInt("atividadeComplementar"));
                                e.setEnsinoRegular(converteBoolean(""+escola.getInt("ensinoRegular")));
                                e.setRegCreche(converteBoolean(""+escola.getInt("regCreche")));
                                e.setRegPreescola(converteBoolean(""+escola.getInt("regPreescola")));
                                e.setRegFundamental8(converteBoolean(""+escola.getInt("regFundamental8")));
                                e.setRegFundamental9(converteBoolean(""+escola.getInt("regFundamental9")));
                                e.setRegMedioMedio(converteBoolean(""+escola.getInt("regMedioMedio")));
                                e.setRegMedioIntegrado(converteBoolean(""+escola.getInt("regMedioIntegrado")));
                                e.setRegMedioNormal(converteBoolean(""+escola.getInt("regMedioNormal")));
                                e.setRegMedioProfissional(converteBoolean(""+escola.getInt("regMedioProfissional")));
                                e.setEnsinoEspecial(converteBoolean(""+escola.getInt("ensinoEspecial")));
                                e.setEspCreche(converteBoolean(""+escola.getInt("espCreche")));
                                e.setEspPreescola(converteBoolean(""+escola.getInt("espPreescola")));
                                e.setEspFundamental8(converteBoolean(""+escola.getInt("espFundamental8")));
                                e.setEspFundamental9(converteBoolean(""+escola.getInt("espFundamental9")));
                                e.setEspMedioMedio(converteBoolean(""+escola.getInt("espMedioMedio")));
                                e.setEspMedioIntegrado(converteBoolean(""+escola.getInt("espMedioIntegrado")));
                                e.setEspMedioNormal(converteBoolean(""+escola.getInt("espMedioNormal")));
                                e.setEspMedioProfissional(converteBoolean(""+escola.getInt("espMedioProfissional")));
                                e.setEspEjaFundamental(converteBoolean(""+escola.getInt("espEjaFundamental")));
                                e.setEspEjaMedio(converteBoolean(""+escola.getInt("espEjaMedio")));
                                e.setEnsinoEja(converteBoolean(""+escola.getInt("ensinoEja")));
                                e.setEnsinoEja(converteBoolean(""+escola.getInt("ejaFundamental")));
                                e.setEjaMedio(converteBoolean(""+escola.getInt("ejaMedio")));
                                e.setEjaProjovem(converteBoolean(""+escola.getInt("ejaProjovem")));
                                e.setCiclos(converteBoolean(""+escola.getInt("ciclos")));
                                e.setFimDeSemana(converteBoolean(""+escola.getInt("fimDeSemana")));
                                e.setPedagogiaAlternancia(converteBoolean(""+escola.getInt("pedagogiaAlternancia")));
                                e.setIdebAI(escola.getDouble("idebAI"));
                                e.setIdebAF(escola.getDouble("idebAF"));
                                e.setEnemPortugues(escola.getDouble("enemPortugues"));
                                e.setEnemMatematica(escola.getDouble("enemMatematica"));
                                e.setEnemHumanas(escola.getDouble("enemHumanas"));
                                e.setEnemNaturais(escola.getDouble("enemNaturais"));
                                e.setEnemRedacao(escola.getDouble("enemRedacao"));
                                e.setEnemMediaObjetiva(escola.getDouble("enemMediaObjetiva"));
                                e.setEnemMediaGeral(escola.getDouble("enemMediaGeral"));
                                try {
                                    e.setSocioEconomico(escola.getString("socioEconomico"));
                                }catch(Exception ex){
                                    e.setSocioEconomico("");
                                }
                                e.setFormacaoDocente(escola.getDouble("formacaoDocente"));
                                e.setEndereco(escola.getString("endereco"));
                                e.setLatitude(escola.getDouble("latitude"));
                                e.setLongitude(escola.getDouble("longitude"));
                                e.setNomeTitulo(escola.getString("nomeTitulo"));
                                e.setSituacaoFuncionamentoTxt(escola.getString("situacaoFuncionamentoTxt"));
                                e.setInicioAnoTxt(escola.getString("inicioAnoTxt"));
                                e.setFimAnoTxt(escola.getString("fimAnoTxt"));
                                e.setDependenciaAdministrativaTxt(escola.getString("dependenciaAdministrativaTxt"));
                                e.setTipoLocalizacaoTxt(escola.getString("tipoLocalizacaoTxt"));
                                e.setRegulamentadaTxt(escola.getString("regulamentadaTxt"));


                                listaEscola.add(e);


                            }
                            Log.e("CARRE",listaEscola.size()+"");
                            achaMelhor();
                            ProgressBar pb = (ProgressBar)findViewById(R.id.pb);
                            RelativeLayout rr = (RelativeLayout)findViewById(R.id.responseRelative);
                            rr.removeView(pb);
                            setInterface();

                        } catch (JSONException e) {
                            Log.e("GAP",e.getLocalizedMessage());

                            e.printStackTrace();
                        }
                    }
                });

            }
        });
    }
    private boolean converteBoolean(String value) {
        boolean returnValue = false;
        if ("1".equalsIgnoreCase(value) || "true".equalsIgnoreCase(value) )
            returnValue = true;
        return returnValue;
    }



    public void achaMelhor(){
        try {
            Escola escolaIdeal = new Escola( );
            Class< ? > classe = Escola.class;
            Local l = new Local( lat , lon );
            int i  , j = 0;
            int selecionados[ ] = new int [ 36 ];
            int prioridades[ ] = new int[ 36 ];



            for( i = 1 ; i < boxValues.length ; i++ )
            {
                if( boxValues[ i ]==true )
                {
                    selecionados[ j ] = i;
                    prioridades[ j ] = values[ i - 1 ];
                    j++;
                }
            }

            //	Method metodos [ ] = classe.getMethods( );

            for( int ct = 0 ; ct < selecionados.length ; ct++ ) {

                Method m = classe.getMethod(  DicionarioMetodos.CHAVES.get( selecionados[ ct ] ) , boolean.class );
                m.invoke( escolaIdeal , true );
            }// Fim do for

            //Aqui vai carregar o banco
            // EscolaDAO dao = new EscolaDAO( );



            // List< Escola > lista = dao.consulta( 35 );//Estado de SP
            System.err.println( "Consultou" );

            //Aqui Chama a classe knn
            Knn ia = new Knn( listaEscola , escolaIdeal , prioridades , selecionados , l );

            Escola[ ] ordem = ia.classificacao( );
            //ia.melhorEscola( );

            ArrayList<Escola> ordenado = new ArrayList<Escola>();

            for(int q=0;q<ordem.length;q++){
                ordenado.add(ordem[q]);
            }
            listaEscola=ordenado;


            /*for (Escola es : listaEscola) {
                Log.e("ENTROUUU", melhorClassificado + "           " + es.getCod());
                if (es.getCod() == melhorClassificado) {

                    Escola temp = listaEscola.get(0); // Save value before overwrite.
                    listaEscola.set(0, es); // First half of swap.
                    listaEscola.set(listaEscola.indexOf(es), temp); // Final operation for swap.
                }
            }
            */
        }catch (Exception ex){
            Log.e("NETFLIX",ex.getMessage());
        }
    }
}