package com.example.samuel.escolaideal;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Resposta {



    /*public ArrayList<Escola> listaEscolas(String sigla) {
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
    }*/


    public String resposta(){
        try {
            return run("https://reqres.in/api/users?page=2");
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
