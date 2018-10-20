package com.example.samuel.escolaideal;

import android.app.Activity;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class SearchActivity extends Activity {
    private DatabaseReference ref;
    ArrayList<Escola> escolas = new ArrayList<Escola>();
    final Geocoder geocoder = new Geocoder(this);
    String rua="";
    boolean boxValues [];
    int values[];
    String cep="";
    Double lat,lon;
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




    //AQUI LE O ARQUIVO DE TEXTO
    public void blabla(View view) {
        //cria a nova activiy
        Intent i = new android.content.Intent(SearchActivity.this, ResponseActivity.class);
        //cria o bundle que carrega a String da busca
        Bundle b = new Bundle();
        b.putString("key1", teste());
        //Log.e("DPDADM",busca);
        i.putExtras(b);

        //inicia a proxima Activity(ResponseActivity)
        startActivity(i);
    }


        public String teste(){
           InputStream inputStream = getResources().openRawResource(R.raw.texto);

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

            int i;
            try {
                i = inputStream.read();
                while (i != -1)
                {
                    byteArrayOutputStream.write(i);
                    i = inputStream.read();
                }
                inputStream.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return null;
            }
            return byteArrayOutputStream.toString();
    }





}

