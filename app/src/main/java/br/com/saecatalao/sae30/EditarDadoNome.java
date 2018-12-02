package br.com.saecatalao.sae30;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static br.com.saecatalao.sae30.Declaracoes.user1;
import static br.com.saecatalao.sae30.MainActivity.indice;
import static br.com.saecatalao.sae30.MainActivity.lista;

public class EditarDadoNome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_dado_nome);

        TextView nomeView = findViewById(R.id.text_display_nome);
        nomeView.setText(lista.get(indice).nome + " " + lista.get(indice).sobrenome);

        Button nomeVoltar = findViewById(R.id.button_editar_nome_voltar);

        nomeVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button nomeSalvar = findViewById(R.id.button_nome_salvar);

        nomeSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder a_builder = new AlertDialog.Builder(EditarDadoNome.this);
                a_builder.setMessage("Salvar Alterações?").setCancelable(false)
                        .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        }).setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        TextView editNome = findViewById(R.id.edit_nome);
                        String editN = editNome.getText().toString();
                        lista.get(indice).setNome(editN);
                        TextView editSNome = findViewById(R.id.edit_sobrenome);
                        String editSN = editSNome.getText().toString();
                        lista.get(indice).setSobrenome(editSN);
                        alert("Salvo com sucesso!");
                        finish();
                    }
                });
                AlertDialog alert = a_builder.create();
                alert.setTitle("");
                alert.show();
            }
        });
    }

    private void alert(String s){
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
