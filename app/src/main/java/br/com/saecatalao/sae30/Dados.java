package br.com.saecatalao.sae30;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dados extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);

        Button voltarPerfil = (Button) findViewById(R.id.button_dados_voltar);

        voltarPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dados.this, perfil.class);
                finish();
            }
        });

        //Botão editar depois que tiver uma tela pra edição

        Button editarPerfil = (Button) findViewById(R.id.button_dados_editar);

        editarPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dados.this, EditarDados.class);
                startActivity(intent);
            }
        });
    }
}
