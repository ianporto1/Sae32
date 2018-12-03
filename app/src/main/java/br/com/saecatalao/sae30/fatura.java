package br.com.saecatalao.sae30;

import android.app.DownloadManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class fatura extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fatura);

        Button voltarHome = findViewById(R.id.button_fatura_voltar);

        voltarHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //botao gerar
        //Download

        Button down = findViewById(R.id.button_fatura_gerar);

        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.joinville.udesc.br/portal/professores/claudinei/materiais/Exemplo_de_Plano_de_Software.docx"));
                startActivity(intent);
                alert("Fatura gerada com Sucesso!!!");
            }
        });
    }

    private void alert(String s){
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }
}
