package br.com.saecatalao.sae30;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Denuncias extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denuncias);

        Button voltarDenuncias = findViewById(R.id.button_noticias_voltar);

        voltarDenuncias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button enviar_denuncia = findViewById(R.id.button_enviar_denuncia);

        enviar_denuncia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final TextView motivo_denuncia = findViewById(R.id.text_motivo_denuncia);
                String motivo = motivo_denuncia.getText().toString();
                final TextView bairro_denuncia = findViewById(R.id.text_bairro_denuncia);
                String bairro = bairro_denuncia.getText().toString();
                final TextView denuncia = findViewById(R.id.text__denuncia);
                String denuncia_s = denuncia.getText().toString();
                if(motivo.equals("") || bairro.equals("") || denuncia_s.equals("")){
                    alert("Por favor preencha todos os campos!");

                }else{ alert("Denúncia enviada com sucesso!");
                Intent enviar = new Intent(Denuncias.this,home.class);
                startActivity(enviar);}
            }
        });

        Button cancelar_denuncia = findViewById(R.id.button_cancelar_denuncia);

        cancelar_denuncia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cancelar = new Intent(Denuncias.this,home.class);
                startActivity(cancelar);
            }
        });
    }
    private void alert(String s){
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }
}
