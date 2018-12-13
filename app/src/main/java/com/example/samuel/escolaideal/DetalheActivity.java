package com.example.samuel.escolaideal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class DetalheActivity extends AppCompatActivity {
    private Escola e;
    private double lat,lon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        setEscola();
    }
    //Carrega o obejto escola desejado e exibe seus dados atraves do metodo toString() presente na classe.
    public void setEscola(){
        //Recebe Objeto Escola atraves de um bundle
        try {
            Bundle bundle = getIntent().getExtras();
            e = (Escola) bundle.getSerializable("school");
            lat = bundle.getDouble("lat");
            lon = bundle.getDouble("lon");
            Log.e("ACER", e.toString());
            setTela();
        }catch (Exception ex){
            Log.e("EDREDON",ex.getMessage());
        }

    }
    //Inicia o Intent do google maps, passando como paramentro as coordenadas do endereço fornecido pelo usuario e as coordenadas da escola
    public void rota(View view){
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                //Uri.parse("http://maps.google.com/maps?saddr="+lat+"&daddr="+lon));
                Uri.parse("http://maps.google.com/maps?saddr="+lat+","+lon+"&daddr="+e.getLatitude()+","+e.getLongitude()));
        Log.e("MAPA","http://maps.google.com/maps?saddr="+lat+","+lon+"&daddr="+e.getLatitude()+","+e.getLongitude());
        startActivity(intent);
    }
    public void setTela(){
        try {
            TextView textoInterior = (TextView) findViewById(R.id.DetalheText);

            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(50, 50, 50, 10);
            textoInterior.setLayoutParams(params);
            //recebe vetor de strings com os atributos parceados para string
            String[] atributos = e.getAtributos();


            for (int i = 0; i < atributos.length; i += 2) {
                //Forma a String que sera exibida, deixando o nome dos atributos em negrito e o atributo não.
                SpannableStringBuilder str = new SpannableStringBuilder(atributos[i] + atributos[i + 1] + System.getProperty("line.separator"));
                str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, atributos[i].length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                textoInterior.append(str);
            }
            //seta o tamanho do texto
            textoInterior.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f);

        }catch (Exception ex){
            Log.e("EDREDON",ex.getMessage());
            ex.printStackTrace();
        }

    }

}
