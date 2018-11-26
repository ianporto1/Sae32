package br.com.saecatalao.sae30;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EditarDadoTelefone extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_dado_telefone);

        Button telefoneVoltar = findViewById(R.id.button_editar_telefone_voltar);

        telefoneVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditarDadoTelefone.this, EditarDados.class);
                finish();
            }
        });

        Button telefoneSalvar = findViewById(R.id.button_telefone_salvar);

        telefoneSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder a_builder = new AlertDialog.Builder(EditarDadoTelefone.this);
                a_builder.setMessage("Salvar Alterações?").setCancelable(false)
                        .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        }).setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(EditarDadoTelefone.this, EditarDados.class);
                        finish();
                    }
                });
                AlertDialog alert = a_builder.create();
                alert.setTitle("");
                alert.show();
            }
        });
    }
}
