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

        Button botaoEntrar = findViewById(R.id.login_button_entrar);//Declara o botão que vai ser chamado para executar a ação de entrar pelo ID

        //Função para logar no aplicativo
        botaoEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                TextView matLogin = findViewById(R.id.edit_login_matricula);//Atribui ao text view que o valor no mesmo vai ser analizado para saber se é válido para efetuar ou não o login
                int mLog = Integer.parseInt(matLogin.getText().toString());
                if(mLog == user1.matricula){
                    alert("Login realizado com sucesso");
                    Intent entrar = new Intent(MainActivity.this, home.class);//Variável intent para saber o caminho que iremos seguir para a transição de atividades
                    startActivity(entrar);//Inicia a atividade home
                }else{
                    alert("Matrícula incorreta");
                }
            }
        });
    }

    //Cria um alerta que não precisa de interferencia para sair da tela
    private void alert(String s){
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
