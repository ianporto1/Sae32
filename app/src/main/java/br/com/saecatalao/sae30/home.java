package br.com.saecatalao.sae30;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button abrePerfil = (Button) findViewById(R.id.home_button_perfil);

        abrePerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //setContentView(R.layout.activity_perfil);
                Intent intent = new Intent(home.this, perfil.class);
                startActivity(intent);
            }
        });

        Button abreFatura = (Button) findViewById(R.id.home_button_fatura);

        abreFatura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, fatura.class);
                startActivity(intent);
            }
        });

        Button abreTarifa = (Button) findViewById(R.id.home_button_tarifa);

        abreTarifa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, Tarifas.class);
                startActivity(intent);
            }
        });

        Button logOut = (Button) findViewById(R.id.home_button_logout);

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            /*public void onClick(View v) {
                Intent intent = new Intent(home.this, MainActivity.class);
                finish();
            }*/

            public void onClick(View v){
                AlertDialog.Builder a_builder = new AlertDialog.Builder(home.this);
                a_builder.setMessage("Deseja realmente sair da Conta?").setCancelable(false)
                        .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(home.this, MainActivity.class);
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
