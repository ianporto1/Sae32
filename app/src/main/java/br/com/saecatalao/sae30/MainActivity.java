package br.com.saecatalao.sae30;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static br.com.saecatalao.sae30.Declaracoes.user1;
import static br.com.saecatalao.sae30.Declaracoes.user2;
import static br.com.saecatalao.sae30.Declaracoes.user3;

public class MainActivity extends AppCompatActivity {

    static ArrayList<Users> lista = new ArrayList<>();
    int status;
    static int indice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista.add(user1);
        lista.add(user2);
        lista.add(user3);

        Button botaoEntrar = findViewById(R.id.login_button_entrar);//Declara o botão que vai ser chamado para executar a ação de entrar pelo ID

        //Função para logar no aplicativo
        botaoEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                TextView matLogin = findViewById(R.id.edit_login_matricula);//Atribui ao text view que o valor no mesmo vai ser analizado para saber se é válido para efetuar ou não o login
                int mLog = Integer.parseInt(matLogin.getText().toString());
                for(int i = 0; i < lista.size(); i++){
                    if(mLog == lista.get(i).matricula){
                        indice = i;
                        status = 0;
                        break;
                    }else{
                        status = 1;
                    }
                }
                if(status == 1){
                    alert("Matrícula incorreta");
                }else{
                    alert("Login realizado com sucesso");
                    Intent entrar = new Intent(MainActivity.this, Home.class);//Variável intent para saber o caminho que iremos seguir para a transição de atividades
                    startActivity(entrar);//Inicia a atividade Home
                }
            }
        });
    }

    //Cria um alerta que não precisa de interferencia para sair da tela
    private void alert(String s){
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
