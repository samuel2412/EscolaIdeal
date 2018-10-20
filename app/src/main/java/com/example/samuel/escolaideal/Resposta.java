package com.example.samuel.escolaideal;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Resposta {

    //retornar um ArrayList<Escola> com as escolas que atendem aos criterios de busca
    public ArrayList<Escola> listaEscolas(String busca) {
        ArrayList<Escola> listaEscola = new ArrayList<Escola>();

        try {
            Log.e("AUX",busca);
            JSONArray obj = new JSONArray(resposta(busca));
            int x = obj.getInt(0);

            JSONArray aux = obj.getJSONArray(1);

            for(int i=0;i<aux.length();i++){
                JSONObject escola = aux.getJSONObject(i);
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
            e.printStackTrace();
            }
        return listaEscola;


    }


    //Retornar um ArrayList de inteiros (codigo de todos as escolas de determinado estado) !NÃO ESTA SENDO USADO!
    public ArrayList<Integer> listaEscolasInt(String sigla) {
        ArrayList<Integer> listaEscola = new ArrayList<Integer>();

        try {
            JSONArray obj = new JSONArray(resposta(sigla));
            JSONArray aux = obj.getJSONArray(1);
            //Log.e("AUX",""+aux.length());
            for(int i=0;i<aux.length();i++){
                JSONObject escola = aux.getJSONObject(i);
                listaEscola.add(escola.getInt("cod"));

            }

        }catch (Exception e){
             Log.e("erro",e.getMessage());
        }
        return listaEscola;
    }

    //Retornar um objeto escola, buscado atraves do codigo, com todos os dados disponeveis na API
    public Escola listaEscolasDetalhe(int cod) {
        Escola e = new Escola();

        try {
            JSONObject escola = new JSONObject(respostaDetalhes(cod));

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
            e.setRegiao(escola.getString("regiao"));
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
            e.setSocioEconomico(escola.getInt("socioEconomico"));
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

        }catch (Exception es){
            Log.e("erro",es.getMessage());
        }
        return e;
    }



    //Realiza a busca na API utilizando uma string para uma busca avançada
    public String resposta(String busca){
        try {
            return  run("http://educacao.dadosabertosbr.com/api/escolas/buscaavancada?"+busca);
        }catch(IOException e) {
            Log.e("erro",e.getMessage());
            return e.getMessage();
        }
    }
    //realizada a busca de uma escola espefica atraves de seu codigo
    public String respostaDetalhes(int cod){

        try {
            return run("http://educacao.dadosabertosbr.com/api/escola/"+cod);
        }catch(IOException e) {
            return e.getMessage();
        }

    }



    String run(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }



}
