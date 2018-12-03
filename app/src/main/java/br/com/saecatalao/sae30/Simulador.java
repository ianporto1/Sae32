package br.com.saecatalao.sae30;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static br.com.saecatalao.sae30.MainActivity.indice;
import static br.com.saecatalao.sae30.MainActivity.lista;

public class Simulador extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulador);

        Button simVoltar = findViewById(R.id.button_simulador_voltar);

        simVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button simulacao = findViewById(R.id.button_simula);

        simulacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView valorLido = findViewById(R.id.edit_leitura1);
                TextView valorAtual = findViewById(R.id.edit_leitura2);
                double valA = Double.parseDouble(valorAtual.getText().toString());
                double valL = Double.parseDouble(valorLido.getText().toString());
                valorLido.getText().toString();
                double calculaConta = (valA - valL) * 0.75;
                AlertDialog.Builder a_builder = new AlertDialog.Builder(Simulador.this);
                a_builder.setMessage("Valor Simulado: R$" + calculaConta).setCancelable(false)
                        .setNegativeButton("Fechar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        }).setPositiveButton("Sair", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
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
