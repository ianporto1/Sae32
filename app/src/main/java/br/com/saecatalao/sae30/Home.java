package br.com.saecatalao.sae30;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static br.com.saecatalao.sae30.Declaracoes.user1;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final TextView nomeHome = findViewById(R.id.text_show_nome);
        nomeHome.setText(user1.getNome());

        Button abrePerfil = findViewById(R.id.home_button_perfil);

        abrePerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent perfil = new Intent(Home.this, Perfil.class);
                startActivity(perfil);
            }
        });

        Button abreFatura = findViewById(R.id.home_button_fatura);

        abreFatura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fatura = new Intent(Home.this, Fatura.class);
                startActivity(fatura);
            }
        });

        Button abreTarifa = findViewById(R.id.home_button_tarifa);

        abreTarifa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tarifa = new Intent(Home.this, Tarifas.class);
                startActivity(tarifa);
            }
        });

        Button abreSimulador = findViewById(R.id.home_button_simulador);

        abreSimulador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent simulador = new Intent(Home.this, Simulador.class);
                startActivity(simulador);
            }
        });

        Button logOut = findViewById(R.id.home_button_logout);

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            /*public void onClick(View v) {
                Intent intent = new Intent(Home.this, MainActivity.class);
                finish();
            }*/

            public void onClick(View v){
                AlertDialog.Builder a_builder = new AlertDialog.Builder(Home.this);
                a_builder.setMessage("Deseja realmente sair da Conta?").setCancelable(false)
                        .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        }).setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                AlertDialog alert = a_builder.create();
                alert.setTitle("Log Out");
                alert.show();
            }
        });
    }
}
