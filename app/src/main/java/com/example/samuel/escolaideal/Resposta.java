package com.example.samuel.escolaideal;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Resposta {
    public ArrayList<Escola> listaEscolas(String sigla) {
        ArrayList<Escola> listaEscola = new ArrayList<Escola>();

        try {
            JSONArray obj = new JSONArray(resposta(sigla));
            JSONArray aux = obj.getJSONArray(1);
            //Log.e("AUX",""+aux.length());
            for(int i=0;i<aux.length();i++){
                JSONObject escola = aux.getJSONObject(i);
                Escola esc = new Escola(escola.getInt("anoCenso"),escola.getInt("cod"),escola.getInt("codCidade"),
                        escola.getInt("situacaoFuncionamento"),escola.getString("nome"),escola.getString("cidade"),
                        escola.getString("estado"),escola.getString("regiao"),
                        escola.getString("dependenciaAdministrativa"),escola.getString("situacaoFuncionamentoTxt"),
                        escola.getString("dependenciaAdministrativaTxt"), escola.getDouble("idebAI"),
                        escola.getDouble("idebAF"), escola.getDouble("enemMediaGeral"));
               listaEscola.add(esc);
            }

        }catch (Exception e){
           e.printStackTrace();
            // Log.e("erro",e.getMessage());
        }
        return listaEscola;
    }


    public String resposta(String sigla){
        try {
            return run("http://educacao.dadosabertosbr.com/api/escolas/buscaavancada?estado="+sigla);
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
