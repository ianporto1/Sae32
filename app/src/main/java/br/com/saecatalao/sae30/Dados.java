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

        //Declaração IDs e caminhos para buscar as informações no objeto e imprimir nos text view
        TextView show;
        show = findViewById(R.id.view_nome);
        show.setText(user1.getNome() + " " + user1.getSobrenome());

        show = findViewById(R.id.view_mat);
        String mat = Integer.toString(user1.matricula);//Casting para String porque setText não compreende Integers
        show.setText(mat);

        show = findViewById(R.id.view_tel);
        String tel = Integer.toString(user1.getTelefone());
        show.setText(tel);

        show = findViewById(R.id.view_cel);
        String cel = Integer.toString(user1.getCelular());
        show.setText(cel);

        show = findViewById(R.id.view_email);
        show.setText(user1.getEmail());

        show = findViewById(R.id.view_ent);
        show.setText(user1.entrega);

        show = findViewById(R.id.view_venc);
        show.setText(user1.vencimento);

        Button voltarPerfil = findViewById(R.id.button_dados_voltar);//Declaração do botão para finalizar a atividade e voltar à tela anterior

        voltarPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button editarPerfil = findViewById(R.id.button_dados_editar);//Declaração do botão para ir a tela de edição dos dados

        editarPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent editar = new Intent(Dados.this, EditarDados.class);//Objeto intent para saber o caminho a percorrer de uma atividade para outra
                startActivity(editar);
            }
        });
    }
}
