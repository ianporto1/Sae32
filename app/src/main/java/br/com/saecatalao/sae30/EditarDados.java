package br.com.saecatalao.sae30;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EditarDados extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_dados);

        Button editarVoltar = findViewById(R.id.button_editar_voltar);

        editarVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditarDados.this, Dados.class);
                finish();
            }
        });

        Button editarNome = findViewById(R.id.button_editar_nome);

        editarNome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditarDados.this, EditarDadoNome.class);
                startActivity(intent);
            }
        });

        Button editarSenha = findViewById(R.id.button_editar_senha);

        editarSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditarDados.this, EditarDadoSenha.class);
                startActivity(intent);
            }
        });

        Button editarTelefone = findViewById(R.id.button_editar_telefone);

        editarTelefone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditarDados.this, EditarDadoTelefone.class);
                startActivity(intent);
            }
        });
    }

}
