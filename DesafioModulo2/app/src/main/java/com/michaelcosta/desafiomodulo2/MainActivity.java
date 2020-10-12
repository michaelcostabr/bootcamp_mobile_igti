package com.michaelcosta.desafiomodulo2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.michaelcosta.desafiomodulo2.model.Pergunta;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Pergunta> perguntas;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            perguntas = ReadTextFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Log.i("INFO", String.format("Total de Perguntas carregadas: %d", perguntas.size()));

        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        PerguntaAdapter adapter = new PerguntaAdapter(this, perguntas);
        recyclerView.setAdapter(adapter);
    }

    public List<Pergunta> ReadTextFile() throws IOException {
        String linha = "";
        List<Pergunta> lista = new ArrayList<Pergunta>();

        StringBuilder stringBuilder = new StringBuilder();
        InputStream is = this.getResources().openRawResource(R.raw.perguntas);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        while (true) {
            try {
                if ((linha = reader.readLine()) == null) break;
                String[] str = linha.split(";");
                lista.add(new Pergunta(str[0], str[1].trim().equals("verdadeiro") ? true : false));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return lista;
    }
}