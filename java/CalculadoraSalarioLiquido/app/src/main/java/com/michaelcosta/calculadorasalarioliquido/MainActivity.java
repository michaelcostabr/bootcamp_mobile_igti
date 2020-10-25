package com.michaelcosta.calculadorasalarioliquido;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtSalarioBruto;
    EditText txtNumDependentes;
    EditText txtOutrosDescontos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtSalarioBruto = findViewById(R.id.txtSalarioBruto);
        txtNumDependentes = findViewById(R.id.txtNumDependentes);
        txtOutrosDescontos = findViewById(R.id.txtOutrosDescontos);
    }

    public void btnCalcular_onClick(View view) {
        Intent resultadoIntent = new Intent(this, ResultadoActivity.class);

        double salarioBruto = 0;
        double numDependentes = 0;
        double outrosDescontos = 0;

        try {
            salarioBruto = Double.parseDouble(txtSalarioBruto.getText().toString());
            numDependentes = Double.parseDouble(txtNumDependentes.getText().toString());
            outrosDescontos = Double.parseDouble(txtOutrosDescontos.getText().toString());
        } catch (Exception e) {
            Toast.makeText(view.getContext(), "Erro " + e.toString(), Toast.LENGTH_LONG).show();
        }

        double deducaoINSS = calcularINSS(salarioBruto);

        //Toast.makeText(view.getContext(), "INSS: " + deducaoINSS, Toast.LENGTH_LONG).show();

        double deducaoIRPF = cacularIRPF(salarioBruto, numDependentes, outrosDescontos, deducaoINSS);

        //Toast.makeText(view.getContext(), "IRPF: " + deducaoIRPF, Toast.LENGTH_LONG).show();

        resultadoIntent.putExtra("salarioBruto", salarioBruto);
        resultadoIntent.putExtra("INSS", deducaoINSS);
        resultadoIntent.putExtra("IRPF", deducaoIRPF);
        resultadoIntent.putExtra("outrosDescontos", outrosDescontos);

        startActivity(resultadoIntent);
    }

    private double cacularIRPF(double salarioBruto, double numDependentes, double outrosDescontos, double deducaoINSS) {

        double deducaoIRPF = 0;

        double baseCalculo = (salarioBruto - deducaoINSS) - (numDependentes * 189.59);

        if (baseCalculo <= 1903.98) {
            deducaoIRPF = 0;
        } else if (baseCalculo >= 1903.99 && baseCalculo <=  2826.65) {
            deducaoIRPF = (baseCalculo * 0.075) - 142.80;
        } else if (baseCalculo >=  2826.66 && baseCalculo <= 3751.05) {
            deducaoIRPF = (baseCalculo * 0.15) - 354.80;
        } else if (baseCalculo >= 3751.06 && baseCalculo <= 4664.68) {
            deducaoIRPF = (baseCalculo * 0.225) - 636.13;
        } else if (baseCalculo >  4664.68) {
            deducaoIRPF = (baseCalculo * 0.275) - 869.36;
        }

        return deducaoIRPF;
    }

    private double calcularINSS(double salarioBruto) {
        double deducao = 0;

        if (salarioBruto <= 1045) {
            deducao = salarioBruto * 0.075;
        } else if (salarioBruto >= 1045.01 && salarioBruto <= 2089.60) {
            deducao = (salarioBruto * 0.09) - 15.67;
        } else if (salarioBruto >= 2089.61 && salarioBruto <= 3134.40) {
            deducao = (salarioBruto * 0.12) - 78.36;
        } else if (salarioBruto >=  3134.41 && salarioBruto <= 6101.06) {
            deducao = (salarioBruto * 0.14) - 141.05;
        } else if (salarioBruto > 6101.06) deducao = 713.10;

        return deducao;
    }
}