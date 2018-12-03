package br.com.saecatalao.sae30;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Denuncia extends AppCompatActivity{

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denuncia);

        Spinner spinner= (Spinner)findViewById(R.id.spn_Bairro);
            ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(Denuncia.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.bairros));

                myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(myAdapter);

        Spinner spinner2 = (Spinner) findViewById(R.id.spn_Motivo);
                ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>(Denuncia.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.motivo));

                myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner2.setAdapter(myAdapter2);

        Button btn_voltar = (Button) findViewById(R.id.btn_denuncia_voltar);

        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Denuncia.this,home.class);
                startActivity(intent);
            }
        });

        Button btn_denunciar = (Button) findViewById(R.id.btn_denuncia_denunciar);

        btn_denunciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder a = new AlertDialog.Builder(Denuncia.this);

                AlertDialog alert = a.create();



                //fake news
                alert.setTitle("Denúncia enviada com sucesso.");
                alert.show();
            }
        });




    }
}
