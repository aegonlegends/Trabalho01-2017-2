package br.edu.iff.pooa20172.trabalho01_2017_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        String nome;
        int horas;
        float salarioHora, bruto, renda, inss, sindicato;

        Intent intent = getIntent();
        nome = intent.getStringExtra("nome");
        salarioHora = intent.getFloatExtra("salarioHora",0);
        horas = intent.getIntExtra("horas",0);

        ((TextView)findViewById(R.id.nome2)).setText("Nome: " + nome);

        bruto = salarioHora * horas;
        ((TextView)findViewById(R.id.bruto)).setText(String.format("Salário Bruto: R$%.2f", bruto));

        renda = bruto * (float)(0.11);

        inss = bruto * (float)(0.08);
        ((TextView)findViewById(R.id.inss)).setText(String.format("INSS: R$%.2f", inss));

        sindicato = bruto * (float)(0.05);
        ((TextView)findViewById(R.id.sindicato)).setText(String.format("Sindicato: R$%.2f", sindicato));

        ((TextView)findViewById(R.id.liquido)).setText(String.format("Salário Liquido: R$%.2f", bruto-renda-inss-sindicato));
    }
}
