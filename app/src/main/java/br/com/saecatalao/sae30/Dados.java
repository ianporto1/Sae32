package br.com.saecatalao.sae30;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static br.com.saecatalao.sae30.Declaracoes.user1;

public class Dados extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);

        TextView show;
        show = findViewById(R.id.view_nome);
        show.setText(user1.nome + " " + user1.sobrenome);

        show = findViewById(R.id.view_mat);
        String mat = Integer.toString(user1.matricula);
        show.setText(mat);

        show = findViewById(R.id.view_tel);
        String tel = Integer.toString(user1.telefone);
        show.setText(tel);

        show = findViewById(R.id.view_cel);
        String cel = Integer.toString(user1.celular);
        show.setText(cel);

        show = findViewById(R.id.view_email);
        show.setText(user1.email);

        show = findViewById(R.id.view_ent);
        show.setText(user1.entrega);

        show = findViewById(R.id.view_venc);
        show.setText(user1.vencimento);

        Button voltarPerfil = findViewById(R.id.button_dados_voltar);

        voltarPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button editarPerfil = findViewById(R.id.button_dados_editar);

        editarPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent editar = new Intent(Dados.this, EditarDados.class);
                startActivity(editar);
            }
        });
    }
}
