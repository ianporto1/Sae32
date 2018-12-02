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

public class EditarDadoTelefone extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_dado_telefone);

        TextView telefoneView = findViewById(R.id.text_display_telefone);
        String tel = Integer.toString(lista.get(indice).telefone);//Casting de integer para string porque setText só compreende Strings
        telefoneView.setText(tel);

        Button telefoneVoltar = findViewById(R.id.button_editar_telefone_voltar);

        telefoneVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                        TextView editTelefone = findViewById(R.id.edit_telefone);
                        int editT = Integer.parseInt(editTelefone.getText().toString());//Casting de String para integer porque a variavel telefone é do tipo integer
                        lista.get(indice).setTelefone(editT);
                        alert("Salvo com sucesso");
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
