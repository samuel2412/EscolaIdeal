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
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.ArrayList;

import br.com.matheus.coordenadas.principal.Local;


public class ResponseActivity extends AppCompatActivity {
    private LinearLayout completo,linearLayout;
    private ArrayList<Escola> listaEscola = new ArrayList<Escola>();
    public static Escola global=null;

    boolean boxValues [];
    int values[];
    double lat,lon;
    public static int melhorClassificado=-1;


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

        String busca = extras.getString("key1");
        //Log.e("BUSCA",busca);
        //cria uma instancia da classe Resposta
       // Resposta re = new Resposta();
        //Recebe um ArrayList composto pelas escolas que foram retornadas pelo metodo de busca
        //listaEscola = re.listaEscolas(busca);
        ;

            boxValues = extras.getBooleanArray("booleanos");
            values = extras.getIntArray("pesos");
            lat = extras.getDouble("lat");
            lon = extras.getDouble("lon");



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
       card.setClickable(true);
        card.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                       // cria a nova activiy
                        Intent i = new android.content.Intent(ResponseActivity.this, DetalheActivity.class);
                        //cria um bundle que carrega o codigo da escola
                       Bundle b = new Bundle();
                       b.putString("codigo", textoInterior.getText().toString());
                        Log.e("lng",e.getLatitude()+"      "+e.getLongitude());
                       b.putDouble("lat",Double.parseDouble(e.getLatitude()));
                       b.putDouble("lon",Double.parseDouble(e.getLongitude()));
                        i.putExtras(b);
                        //inicia a activity
                        startActivity(i);
                    }
                });
        //adiona o CardView montado ao LinearLayout completo
        completo.addView(card);


    }

    public void provisorio(String provisoria){
        try {



            JSONObject jsnobject = new JSONObject(provisoria);
            JSONArray jsonArray = jsnobject.getJSONArray("escola");
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
                e.setCodUf(escola.getInt("codUf"));
                e.setSiglaUf(escola.getString("siglaUf"));
                e.setCodMunicipio(escola.getInt("codMunicipio"));
                e.setNomeMunicipio(escola.getString("nomeMunicipio"));
                e.setCodDistrito(escola.getInt("codDistrito"));
                e.setNomeMunicipio(escola.getString("nomeDistrito"));
                //e.setRegiao(escola.getString("regiao"));
                e.setDependenciaAdministrativa(escola.getInt("dependenciaAdministrativa"));
                e.setTipoLocalizacao(escola.getInt("tipoLocalizacao"));
                e.setRegulamentada(escola.getInt("regulamentada"));
                e.setAguaFiltrada(escola.getBoolean("aguaFiltrada"));
                e.setAguaPublica(escola.getBoolean("aguaPublica"));
                e.setAguaPocoArtesiano(escola.getBoolean("aguaPocoArtesiano"));
                e.setAguaCacimba(escola.getBoolean("aguaCacimba"));
                e.setAguaRio(escola.getBoolean("aguaRio"));
                e.setAguaInexistente(escola.getBoolean("aguaInexistente"));
                e.setEnergiaPublica(escola.getBoolean("energiaPublica"));
                e.setEnergiaGerador(escola.getBoolean("energiaGerador"));
                e.setEnergiaOutros(escola.getBoolean("energiaOutros"));
                e.setEnergiaInexistente(escola.getBoolean("energiaInexistente"));
                e.setEsgotoPublico(escola.getBoolean("esgotoPublico"));
                e.setEsgotoFossa(escola.getBoolean("esgotoFossa"));
                e.setEsgotoInexistente(escola.getBoolean("esgotoInexistente"));
                e.setLixoColetaPeriodica(escola.getBoolean("lixoColetaPeriodica"));
                e.setLixoQueima(escola.getBoolean("lixoQueima"));
                e.setLixoJogaOutraArea(escola.getBoolean("lixoJogaOutraArea"));
                e.setLixoRecicla(escola.getBoolean("lixoRecicla"));
                e.setLixoEnterra(escola.getBoolean("lixoEnterra"));
                e.setLixoOutros(escola.getBoolean("lixoOutros"));
                e.setSalaDiretoria(escola.getBoolean("salaDiretoria"));
                e.setSalaProfessores(escola.getBoolean("salaProfessores"));
                e.setLaboratorioInformatica(escola.getBoolean("laboratorioInformatica"));
                e.setLaboratorioCiencias(escola.getBoolean("laboratorioCiencias"));
                e.setAtendimentoEspecial(escola.getBoolean("atendimentoEspecial"));
                e.setQuadraCoberta(escola.getBoolean("quadraCoberta"));
                e.setQuadraDescoberta(escola.getBoolean("quadraDescoberta"));
                e.setCozinha(escola.getBoolean("cozinha"));
                e.setBiblioteca(escola.getBoolean("biblioteca"));
                e.setSalaLeitura(escola.getBoolean("salaLeitura"));
                e.setParqueInfantil(escola.getBoolean("parqueInfantil"));
                e.setBercario(escola.getBoolean("bercario"));
                e.setSanitarioForaPredio(escola.getBoolean("sanitarioForaPredio"));
                e.setSanitarioDentroPredio(escola.getBoolean("sanitarioDentroPredio"));
                e.setSanitarioEducInfant(escola.getBoolean("sanitarioEducInfant"));
                e.setSanitarioPNE(escola.getBoolean("sanitarioPNE"));
                e.setDependenciasPNE(escola.getBoolean("dependenciasPNE"));
                e.setSecretaria(escola.getBoolean("secretaria"));
                e.setBanheiroChuveiro(escola.getBoolean("banheiroChuveiro"));
                e.setRefeitorio(escola.getBoolean("refeitorio"));
                e.setDespensa(escola.getBoolean("despensa"));
                e.setAlmoxarifado(escola.getBoolean("almoxarifado"));
                e.setAuditorio(escola.getBoolean("auditorio"));
                e.setPatioCoberto(escola.getBoolean("patioCoberto"));
                e.setPatioDescoberto(escola.getBoolean("patioDescoberto"));
                e.setAlojamentoAluno(escola.getBoolean("alojamentoAluno"));
                e.setAlojamentoProfessor(escola.getBoolean("alojamentoProfessor"));
                e.setAreaVerde(escola.getBoolean("areaVerde"));
                e.setLavanderia(escola.getBoolean("lavanderia"));
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
                e.setInternet(escola.getBoolean("internet"));
                e.setBandaLarga(escola.getBoolean("bandaLarga"));
                e.setFuncionarios(escola.getInt("funcionarios"));
                e.setAlimentacao(escola.getBoolean("alimentacao"));
                e.setAee(escola.getBoolean("aee"));
                e.setAtividadeComplementar(escola.getInt("atividadeComplementar"));
                e.setEnsinoRegular(escola.getBoolean("ensinoRegular"));
                e.setRegCreche(escola.getBoolean("regCreche"));
                e.setRegPreescola(escola.getBoolean("regPreescola"));
                e.setRegFundamental8(escola.getBoolean("regFundamental8"));
                e.setRegFundamental9(escola.getBoolean("regFundamental9"));
                e.setRegMedioMedio(escola.getBoolean("regMedioMedio"));
                e.setRegMedioIntegrado(escola.getBoolean("regMedioIntegrado"));
                e.setRegMedioNormal(escola.getBoolean("regMedioNormal"));
                e.setRegMedioProfissional(escola.getBoolean("regMedioProfissional"));
                e.setEnsinoEspecial(escola.getBoolean("ensinoEspecial"));
                e.setEspCreche(escola.getBoolean("espCreche"));
                e.setEspPreescola(escola.getBoolean("espPreescola"));
                e.setEspFundamental8(escola.getBoolean("espFundamental8"));
                e.setEspFundamental9(escola.getBoolean("espFundamental9"));
                e.setEspMedioMedio(escola.getBoolean("espMedioMedio"));
                e.setEspMedioIntegrado(escola.getBoolean("espMedioIntegrado"));
                e.setEspMedioNormal(escola.getBoolean("espMedioNormal"));
                e.setEspMedioProfissional(escola.getBoolean("espMedioProfissional"));
                e.setEspEjaFundamental(escola.getBoolean("espEjaFundamental"));
                e.setEspEjaMedio(escola.getBoolean("espEjaMedio"));
                e.setEnsinoEja(escola.getBoolean("ensinoEja"));
                e.setEnsinoEja(escola.getBoolean("ejaFundamental"));
                e.setEjaMedio(escola.getBoolean("ejaMedio"));
                e.setEjaProjovem(escola.getBoolean("ejaProjovem"));
                e.setCiclos(escola.getBoolean("ciclos"));
                e.setFimDeSemana(escola.getBoolean("fimDeSemana"));
                e.setPedagogiaAlternancia(escola.getBoolean("pedagogiaAlternancia"));
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
                    e.setSocioEconomico(escola.getInt("socioEconomico"));
                }catch(Exception ex){
                    e.setSocioEconomico(0);
                }
                e.setFormacaoDocente(escola.getDouble("formacaoDocente"));
                e.setEndereco(escola.getString("endereco"));
                e.setLatitude(escola.getString("latitude"));
                e.setLongitude(escola.getString("longitude"));
                e.setNomeTitulo(escola.getString("nomeTitulo"));
                e.setSituacaoFuncionamentoTxt(escola.getString("situacaoFuncionamentoTxt"));
                e.setInicioAnoTxt(escola.getString("inicioAnoTxt"));
                e.setFimAnoTxt(escola.getString("fimAnoTxt"));
                e.setDependenciaAdministrativaTxt(escola.getString("dependenciaAdministrativaTxt"));
                e.setTipoLocalizacaoTxt(escola.getString("tipoLocalizacaoTxt"));
                e.setRegulamentadaTxt(escola.getString("regulamentadaTxt"));
                e.setDistanciagz(0.0);
                listaEscola.add(e);
            }
            achaMelhor();


        }catch (Exception e){
            Log.e("KLEENEX",e.getMessage());
            e.printStackTrace();

        }

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

            for( int ct = 0 ; ct < selecionados.length ; ct++ )
            {

                try
                {

                    Method m = classe.getMethod(  DicionarioMetodos.CHAVES.get( selecionados[ ct ] ) , boolean.class );
                    m.invoke( escolaIdeal , true );
                }
                catch( Exception e )
                {

                }

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


            for (Escola es : listaEscola) {
                Log.e("ENTROUUU", melhorClassificado + "           " + es.getCod());
                if (es.getCod() == melhorClassificado) {

                    Escola temp = listaEscola.get(0); // Save value before overwrite.
                    listaEscola.set(0, es); // First half of swap.
                    listaEscola.set(listaEscola.indexOf(es), temp); // Final operation for swap.
                }
            }

        }catch (Exception ex){

        }
    }
}