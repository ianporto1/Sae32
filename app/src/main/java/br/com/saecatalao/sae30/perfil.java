package br.com.saecatalao.sae30;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class perfil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        Button voltarHome = (Button) findViewById(R.id.perfil_button_voltar);

        voltarHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(perfil.this, home.class);
                finish();
            }
        });

        Button mostrarDados = (Button) findViewById(R.id.perfil_button_dados);

        mostrarDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(perfil.this, Dados.class); //mudar os intents pro nome da classe a ser aberta
                startActivity(intent);
            }
        });

        Button mostrarCertidao = (Button) findViewById(R.id.perfil_button_certidao);

        mostrarCertidao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(perfil.this, CertidaoPositiva.class);
                startActivity(intent);
            }
        });

        Button mostarQuitadas = (Button) findViewById(R.id.perfil_button_fatura);

        mostarQuitadas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(perfil.this, faturas_quitadas.class);
                startActivity(intent);
            }
        });
    }


}
