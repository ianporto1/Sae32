package br.com.saecatalao.sae30;

import android.app.DownloadManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static br.com.saecatalao.sae30.Declaracoes.user1;

public class home extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final TextView nomeHome = findViewById(R.id.text_show_nome);
        nomeHome.setText(user1.nome);

        Button abrePerfil = findViewById(R.id.home_button_perfil);

        abrePerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent perfil = new Intent(home.this, perfil.class);
                startActivity(perfil);
            }
        });

        Button abreFatura = findViewById(R.id.home_button_fatura);

        abreFatura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fatura = new Intent(home.this, fatura.class);
                startActivity(fatura);
            }
        });

        Button abreTarifa = findViewById(R.id.home_button_tarifa);

                abreTarifa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tarifa = new Intent(home.this, Tarifas.class);
                startActivity(tarifa);
            }
        });

        Button logOut = findViewById(R.id.home_button_logout);

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
                        finish();
                    }
                });
                AlertDialog alert = a_builder.create();
                alert.setTitle("Log Out");
                alert.show();
            }
        });

        Button noticias = findViewById(R.id.button_noticias);

        noticias.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent noticias = new Intent(home.this, Noticias.class);
                startActivity(noticias);
            }
        });

        Button denuncias = findViewById(R.id.button_denuncias);

        denuncias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent denuncias = new Intent(home.this, Denuncias.class);
                startActivity(denuncias);
            }
        });

        //TESTE DOWNLOAD

        Button down = findViewById(R.id.button_hiperlink);

        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.joinville.udesc.br/portal/professores/claudinei/materiais/Exemplo_de_Plano_de_Software.docx"));
                startActivity(intent);
            }
        });
    }
}
