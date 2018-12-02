package br.com.saecatalao.sae30;

import android.content.DialogInterface;
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

public class EditarDadoCelular extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_dado_celular);

        TextView celularView = findViewById(R.id.text_display_celular);
        String cel = Integer.toString(lista.get(indice).celular);//Casting de integer para string porque setText só compreende Strings
        celularView.setText(cel);

        Button celularVoltar = findViewById(R.id.button_editar_celular_voltar);//Declaração do botão para finalizar a atividade e voltar à tela anterior

        celularVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button celularSalvar = findViewById(R.id.button_celular_salvar);//Declaração do botão para salvar os dados alterados e voltar a tela anterior

        celularSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder a_builder = new AlertDialog.Builder(EditarDadoCelular.this);//Construtor de alertas para confirmar se o usuário quer salvar esses dados
                a_builder.setMessage("Salvar Alterações?").setCancelable(false)
                        .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        }).setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        TextView editCelular = findViewById(R.id.edit_celular);
                        int editC = Integer.parseInt(editCelular.getText().toString());//Casting de String para integer porque a variavel celular é do tipo integer
                        lista.get(indice).setCelular(editC);
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
