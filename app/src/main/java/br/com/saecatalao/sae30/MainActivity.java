package br.com.saecatalao.sae30;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static br.com.saecatalao.sae30.Declaracoes.user1;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botaoEntrar = findViewById(R.id.login_button_entrar);

        botaoEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                final TextView nomeLogin = findViewById(R.id.edit_login_nome);
                String nLog = nomeLogin.getText().toString();
                if(nLog.equals(user1.nome)){
                    alert("Login realizado com sucesso");
                    Intent entrar = new Intent(MainActivity.this, home.class);
                    startActivity(entrar);
                }else{
                    alert("Nome de usuário incorreto");
                }
            }
        });
    }

    private void alert(String s){
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }
}
