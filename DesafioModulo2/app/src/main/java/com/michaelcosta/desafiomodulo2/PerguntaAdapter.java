package com.michaelcosta.desafiomodulo2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.michaelcosta.desafiomodulo2.model.Pergunta;

import java.util.List;

public class PerguntaAdapter extends RecyclerView.Adapter<PerguntaAdapter.PerguntaViewHolder> {


    Context context;
    List<Pergunta> perguntaList;

    public PerguntaAdapter(Context context, List<Pergunta> perguntaList) {
        this.context = context;
        this.perguntaList = perguntaList;
    }

    @NonNull
    @Override
    public PerguntaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_layout, parent, false);
        return new PerguntaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PerguntaViewHolder holder, int position) {
        final Pergunta pergunta = perguntaList.get(position);

        TextView txtPergunta = holder.txtPergunta;
        Button btnVerdadeiro = holder.btnVerdadeiro;
        Button btnFalso = holder.btnFalso;

        txtPergunta.setText(pergunta.getDescricao());

        btnVerdadeiro.setTag(R.id.respostaBotao, pergunta.isVerdadeiro());

        btnFalso.setEnabled(pergunta.isRespondeu() == false);
        btnVerdadeiro.setEnabled(pergunta.isRespondeu() == false);

        btnVerdadeiro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pergunta.setRespondeu(true);
                notifyDataSetChanged();

                if ((boolean) v.getTag(R.id.respostaBotao)) {
                    pontuar(true);
                } else {
                    pontuar(false);
                }

            }
        });

        btnFalso.setTag(R.id.respostaBotao, pergunta.isVerdadeiro());

        btnFalso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pergunta.setRespondeu(true);
                notifyDataSetChanged();
                if ((boolean) v.getTag(R.id.respostaBotao)) {
                    pontuar(false);
                } else {
                    pontuar(true);
                }
            }
        });
    }

    public void pontuar(Boolean acertou) {

        SharedPreferences myPrefs = this.context.getSharedPreferences("pontuacao", Context.MODE_PRIVATE);
        int intNumAcertos = myPrefs.getInt("intNumAcertos", 0);
        int intNumRespostas = myPrefs.getInt("intNumRespostas", 0);

        final SharedPreferences.Editor editor = myPrefs.edit();
        editor.putInt("intNumRespostas", ++intNumRespostas);

        if (acertou) {
            editor.putInt("intNumAcertos", ++intNumAcertos);
            Toast.makeText(this.context, "Acertou!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this.context, "Errou!", Toast.LENGTH_SHORT).show();
        }

        editor.commit();

        if (intNumRespostas == getItemCount()) {
            Intent intent = new Intent(this.context, ResultadoActivity.class);
            intent.putExtra("intNumAcertos", intNumAcertos * 100 / intNumRespostas);

            Toast.makeText(this.context, "Acabou", Toast.LENGTH_SHORT).show();
            editor.putInt("intNumRespostas", 0);
            editor.putInt("intNumAcertos", 0);
            editor.commit();

            context.startActivity(intent);
        }

    }

    @Override
    public int getItemCount() {
        return perguntaList.size();
    }

    static class PerguntaViewHolder extends RecyclerView.ViewHolder {

        TextView txtPergunta;
        View bottonLine;
        Button btnVerdadeiro;
        Button btnFalso;

        public PerguntaViewHolder(@NonNull View itemView) {
            super(itemView);
            txtPergunta = itemView.findViewById(R.id.txtPergunta);
            bottonLine = itemView.findViewById(R.id.bottomLine);
            btnVerdadeiro = itemView.findViewById(R.id.btnVerdadeiro);
            btnFalso = itemView.findViewById(R.id.btnFalso);
        }
    }
}

