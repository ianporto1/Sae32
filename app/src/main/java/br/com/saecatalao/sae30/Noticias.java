package br.com.saecatalao.sae30;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Noticias extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);

        Button voltarNoticias = findViewById(R.id.button_noticias_voltar);

        voltarNoticias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        TextView show;
        String notas;
        notas="Hoje 03/12/2018\n\nHaverá uma Palestra sobre conscientização do uso racional de água!!!\n\nLocal: UFG - Regional Catalão\nSala 203 Bl 02\nHorário: 13hrs";
        show = findViewById(R.id.text_noticias);
        show.setText(notas);
    }
}
