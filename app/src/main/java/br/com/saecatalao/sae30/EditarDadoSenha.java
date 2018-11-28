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

public class EditarDadoSenha extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_dado_senha);

        Button senhaVoltar = findViewById(R.id.button_editar_senha_voltar);

        senhaVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button senhaSalvar = findViewById(R.id.button_senha_salvar);

        senhaSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder a_builder = new AlertDialog.Builder(EditarDadoSenha.this);
                a_builder.setMessage("Salvar Alterações?").setCancelable(false)
                        .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        }).setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                TextView editSenha1 = findViewById(R.id.edit_senha1);
                                String editS1 = editSenha1.getText().toString();
                                TextView editSenha2 = findViewById(R.id.edit_senha2);
                                String editS2 = editSenha2.getText().toString();
                                if ((editS1.length() < 6 || editS1.length() > 16) && (editS2.length() < 6 || editS2.length() > 16)) {
                                    alert("A senha deve ter entre 6 e 16 caracteres");
                                    dialog.cancel();
                                } else {
                                    if (editS1.equals(editS2)) {
                                        if (editS1.equals(user1.getSenha())) {
                                            alert("Sua nova senha não pode ser igual a atual");
                                            dialog.cancel();
                                        } else {
                                            user1.setSenha(editS1);
                                            alert("Salvo com sucesso!");
                                            finish();
                                        }
                                    } else {
                                        alert("As senhas não são iguais");
                                        dialog.cancel();
                                    }
                                }

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
