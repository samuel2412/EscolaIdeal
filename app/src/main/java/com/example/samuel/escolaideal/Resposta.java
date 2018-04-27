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
    public ArrayList<Escola> listaEscolas(String sigla) {
        ArrayList<Escola> listaEscola = new ArrayList<Escola>();

        try {
            JSONArray obj = new JSONArray(resposta(sigla));
            JSONArray outroArray = new JSONArray(obj.get(1));

            for(int i=0;i<outroArray.length();i++){
                JSONObject escola = new JSONObject (outroArray.get(i));
                Escola esc = new Escola();
                while(escola.keys().hasNext()){
                    String chave = escola.keys().next();
                    esc.setValues(chave,escola.get(chave));
                }

                listaEscola.add(esc);
            }



        }catch (Exception e){
            Log.e("erro",e.getMessage());
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
