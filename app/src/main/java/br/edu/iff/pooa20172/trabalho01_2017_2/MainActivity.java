package br.edu.iff.pooa20172.trabalho01_2017_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText nome = findViewById(R.id.nome);
        final EditText salario = findViewById(R.id.salarioHora);
        final EditText horas = findViewById(R.id.horas);

        ((Button) findViewById(R.id.calcular)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int inthoras;

                try{
                    inthoras = (int)Float.parseFloat(horas.getText().toString());
                }
                catch (NumberFormatException e){
                    inthoras = 0;
                }

                float floatsalario;
                try{
                    floatsalario = Float.parseFloat(salario.getText().toString());
                }
                catch (NumberFormatException e){
                    floatsalario = 0;
                }

                Intent intent = new Intent(MainActivity.this, ResultActivity.class);

                intent.putExtra("nome", nome.getText().toString());
                intent.putExtra("salarioHora", floatsalario);
                intent.putExtra("horas", inthoras);

                startActivity(intent);
            }
        });
        ((Button) findViewById(R.id.limpar)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nome.setText("");
                salario.setText("");
                horas.setText("");
            }
        });
    }
}
