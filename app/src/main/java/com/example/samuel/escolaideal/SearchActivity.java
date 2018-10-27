package com.example.samuel.escolaideal;

import android.app.Activity;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class SearchActivity extends Activity {
    final Geocoder geocoder = new Geocoder(this);
    private String rua="";
    private boolean boxValues [];
    private int values[];
    private String cep="";
    private Double lat,lon;
    private Endereco end;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //captura os valores do bundle
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            rua = extras.getString("rua");
            boxValues = extras.getBooleanArray("booleanos");
            values = extras.getIntArray("pesos");
        }
        getCep();

        try {
            run();
        } catch (Exception e) {
            Log.e("NETFLIX",String.valueOf(e));
            e.printStackTrace();
        }


        Button b = (Button)findViewById(R.id.confirmar);
        b.setClickable(true);

    }
    public void getCep(){

        try {
            List<Address> addresses = geocoder.getFromLocationName(rua, 1);
            if (addresses != null && !addresses.isEmpty()) {
                Address address = addresses.get(0);
                // Use the address as needed
                lat = address.getLatitude();
                lon = address.getLongitude();

                addresses = geocoder.getFromLocation(lat, lon, 1);
                cep = addresses.get(0).getPostalCode();
                               //cep = String.format("Latitude: %f, Longitude: %f", address.getLatitude(), address.getLongitude());

                //Toast.makeText(this, cep, Toast.LENGTH_LONG).show();
            } else {
                // Display appropriate message when Geocoder services are not available

                //Toast.makeText(this,"Unable to geocode zipcode", Toast.LENGTH_LONG).show();
            }
        } catch (IOException e) {
            // handle exception
        }




        TextView tx = (TextView)findViewById(R.id.textoTeste);
        tx.setText("Confirme seu Cep");
        EditText et  = (EditText)findViewById(R.id.enderecoConfirm);
        et.setText(cep);


    }


    void run() throws IOException {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://viacep.com.br/ws/" + cep + "/json/")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                call.cancel();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                final String enderecoResponse = response.body().string();

                SearchActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Gson g = new Gson();
                            end = g.fromJson(enderecoResponse, Endereco.class);

                            Log.e("NETFLIX",enderecoResponse);
                            Log.e("NETFLIX","cidade: "+end.toString());

                        } catch (Exception e) {
                            Log.e("NETFLIX", String.valueOf(e));

                            e.printStackTrace();
                        }
                    }
                });

            }
        });

    }


    //AQUI LE O ARQUIVO DE TEXTO
    public void confirmar(View view) {
        //cria a nova activiy
        Intent i = new android.content.Intent(SearchActivity.this, ResponseActivity.class);
        //cria o bundle que carrega a String da busca
        Bundle b = new Bundle();
        b.putDouble("Lat",lat);
        b.putDouble("Lon",lon);
        b.putBooleanArray("booleanos",boxValues);
        b.putIntArray("pesos",values);
        b.putString("municipio",end.getIbge());

        //Log.e("DPDADM",busca);
        i.putExtras(b);

        //inicia a proxima Activity(ResponseActivity)
        startActivity(i);
    }


        private class Endereco{

        private String cep, logradouro, complemento, bairro, localidade, uf, unidade, ibge, gia;
        public Endereco(){}

            @Override
            public String toString() {

                return "Endereco{" +
                        "cep='" + cep + '\'' +
                        ", logradouro='" + logradouro + '\'' +
                        ", complemento='" + complemento + '\'' +
                        ", bairro='" + bairro + '\'' +
                        ", localidade='" + localidade + '\'' +
                        ", uf='" + uf + '\'' +
                        ", unidade='" + unidade + '\'' +
                        ", ibge='" + ibge + '\'' +
                        ", gia='" + gia + '\'' +
                        '}';
            }

            public String getCep() {
                return cep;
            }

            public void setCep(String cep) {
                this.cep = cep;
            }

            public String getLogradouro() {
                return logradouro;
            }

            public void setLogradouro(String logradouro) {
                this.logradouro = logradouro;
            }

            public String getComplemento() {
                return complemento;
            }

            public void setComplemento(String complemento) {
                this.complemento = complemento;
            }

            public String getBairro() {
                return bairro;
            }

            public void setBairro(String bairro) {
                this.bairro = bairro;
            }

            public String getLocalidade() {
                return localidade;
            }

            public void setLocalidade(String localidade) {
                this.localidade = localidade;
            }

            public String getUf() {
                return uf;
            }

            public void setUf(String uf) {
                this.uf = uf;
            }

            public String getUnidade() {
                return unidade;
            }

            public void setUnidade(String unidade) {
                this.unidade = unidade;
            }

            public String getIbge() {
                return ibge;
            }

            public void setIbge(String ibge) {
                this.ibge = ibge;
            }

            public String getGia() {
                return gia;
            }

            public void setGia(String gia) {
                this.gia = gia;
            }
        }



}

