package com.igti.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.igti.recyclerview.model.Carro;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ClickRecyclerView {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    RecyclerTesteAdapter adapter;
    private List<Carro> carrosListas = new ArrayList<>();
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setaRecyclerView();

        setaButtons();
        listenersButtons();

    }

    public void setaRecyclerView(){

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        adapter = new RecyclerTesteAdapter(this, carrosListas, this);
        mRecyclerView.setAdapter(adapter);
    }

    public void setaButtons(){
        floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);
    }

    @Override
    public void onCustomClick(Object object) {
        Carro carro = (Carro) object;
        String nome = carro.getModelo();
    }

    public void listenersButtons() {

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Carro carro = new Carro();
                carro.setModelo("Renegade");
                carrosListas.add(carro);
                adapter.notifyDataSetChanged();

            }
        });
    }
}