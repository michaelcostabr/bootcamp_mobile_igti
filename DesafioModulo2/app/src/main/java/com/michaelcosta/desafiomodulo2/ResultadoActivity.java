package com.michaelcosta.desafiomodulo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        Intent intent = getIntent();

        int intNumAcertos = intent.getIntExtra("intNumAcertos", 0);

        TextView textView = findViewById(R.id.txtResultado);
        textView.setText(String.format("%d%% de acertos.", intNumAcertos));

        Button btnReiniciar = findViewById(R.id.btnReiniciar);

        btnReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), MainActivity.class));
            }
        });
    }
}