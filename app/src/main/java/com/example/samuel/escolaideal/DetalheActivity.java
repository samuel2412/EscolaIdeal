package com.example.samuel.escolaideal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class DetalheActivity extends AppCompatActivity {
    private Escola e;
    double lat,lon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        setEscola();
    }
    //Carrega o obejto escola desejado e exibe seus dados atraves do metodo toString() presente na classe.
    public void setEscola(){
        //Recebe o codigo da escola atraves de um bundle
        Bundle bundle = getIntent().getExtras();
       // int codigo =  bundle.getInt("Codigo");
        String texto = bundle.getString("codigo");
        lat = bundle.getDouble("lat");
        lon = bundle.getDouble("lon");
        Log.e("lng",lat+"      "+lon);
        //Instancia um objeto da classe resposta e recebe um objeto da classe escola atraves do metodo re.listaEscolasDetalhe(int codigo)
       // Resposta re = new Resposta();
        //e = re.listaEscolasDetalhe(codigo);

        //exibi os dados no TextView
        TextView textoDetalhe = (TextView)findViewById(R.id.DetalheText);
        textoDetalhe.setText(texto);


    }
    public void rota(View view){
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("http://maps.google.com/maps?&daddr="+lat+","+lon));
        startActivity(intent);
    }

}
