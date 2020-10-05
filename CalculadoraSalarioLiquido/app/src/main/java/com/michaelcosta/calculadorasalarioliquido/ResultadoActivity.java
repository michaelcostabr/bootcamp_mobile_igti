package com.michaelcosta.calculadorasalarioliquido;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class ResultadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();

        DecimalFormat df = new DecimalFormat("#.##");

        double salarioBruto = intent.getDoubleExtra("salarioBruto", 0);
        double deducaoINSS = intent.getDoubleExtra("INSS",0);
        double deducaoIRPF = intent.getDoubleExtra("IRPF",0);
        double outrosDescontos = intent.getDoubleExtra("outrosDescontos",0);

        TextView txtSalarioBruto = findViewById(R.id.txtSalarioBruto);
        TextView txtINSS = findViewById(R.id.txtINSS);
        TextView txtIRPF = findViewById(R.id.txtIRPF);
        TextView txtOutros = findViewById(R.id.txtOutros);

        TextView txtSalarioLiquido = findViewById(R.id.txtSalarioLiquido);
        TextView txtDescontos = findViewById(R.id.txtDescontos);

        txtSalarioBruto.setText(df.format(salarioBruto));
        txtINSS.setText(df.format(-deducaoINSS));
        txtIRPF.setText(df.format(-deducaoIRPF));
        txtOutros.setText(df.format(-outrosDescontos));

        double deducoes = deducaoINSS+deducaoIRPF+outrosDescontos;
        txtSalarioLiquido.setText(df.format(salarioBruto-deducoes-outrosDescontos));
        txtDescontos.setText(df.format(deducoes*100/salarioBruto));

        Button btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(v.getContext(), MainActivity.class);
                startActivity(mainIntent);
            }
        });
    }
}