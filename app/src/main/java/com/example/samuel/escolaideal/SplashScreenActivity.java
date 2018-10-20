package com.example.samuel.escolaideal;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;


public class SplashScreenActivity extends AppCompatActivity{
    // Timer da splash screen
    private static int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);



        //metodo que ira abrir um timer e chamara um metodo que verifica a conexao com a internet
        iniciar();

    }


    //metodo que inicia um timer, chama um metodo que verifica conexao com internet,e inicia a proxima activiy ou gera um alerta
    public void iniciar(){

        new Handler().postDelayed(new Runnable() {
            /*
             * Exibindo splash com um timer.
             */
            @Override
            public void run() {
                // Esse método será executado sempre que o timer acabar
                // chama o metodo que verifica a conexão com a internt
                if (temInternet()) {

                    //se tiver conexao inicia a proxima activity
                    Intent i = new Intent(SplashScreenActivity.this, PesoActivity.class);
                    startActivity(i);

                    // Fecha esta activity
                    finish();

                }else{
                    //se não tiver internet dispara um alerta
                    alerta();
                }
            }
            }, SPLASH_TIME_OUT);

    }
    //alerta para o usuario verificar a conexao
    public void alerta() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)//seta icone do alerta
                .setTitle("Acesso Internet")//seta titulo do alerta
                .setMessage("Sem Acesso a Internet\nVerifique sua Conexão")//seta  mensagem do alerta
                .setCancelable(false)//seta o alerta como não cancelavel (não permite clicar fora do alerta para fecha-lo)
                .setPositiveButton("Tentar Novamente", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {//seta o botão "positivo" do alerta
                        iniciar();//chama o metodo inicar irá verificar novamente a conexao com a internet
                    }

                }).setNegativeButton("Sair",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        finishAndRemoveTask();
                    }
                }//seta o botao "negativo" que quando acionado fecha a aplicação
        ).show();//exibe o alerta
    }

    //Metodo que verifica se o usuario possui acesso a internet
    public boolean temInternet(){
        boolean connected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //possui acesso -> conected = true
            connected = true;
        }
        else {
            //não possui -> conected = false;
            connected = false;
        }
        return connected;
    }


}