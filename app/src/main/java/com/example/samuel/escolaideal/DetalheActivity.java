package com.example.samuel.escolaideal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetalheActivity extends AppCompatActivity {

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
        int codigo =  bundle.getInt("Codigo");
        //Instancia um objeto da classe resposta e recebe um objeto da classe escola atraves do metodo re.listaEscolasDetalhe(int codigo)
        Resposta re = new Resposta();
        Escola e = re.listaEscolasDetalhe(codigo);

        //exibi os dados no TextView
        TextView textoDetalhe = (TextView)findViewById(R.id.DetalheText);
        textoDetalhe.setText(e.toString());


    }

}
