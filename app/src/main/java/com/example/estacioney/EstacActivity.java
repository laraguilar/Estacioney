package com.example.estacioney;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.estacioney.adapter.MyAdapter;

import java.util.List;

public class EstacActivity extends AppCompatActivity {
    String idEstac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estac);

        EstacViewModel estacViewModel = new ViewModelProvider(this).get(EstacViewModel.class);
        LiveData<Estacionamento> estacs = estacViewModel.getEstacionamento();
        estacs.observe(this, new Observer<Estacionamento>() { // o erro esta aqui, nao consegue pegar o id do estacionamento na viewmodel
            @Override
            public void onChanged(Estacionamento estacs) {
                TextView tvValFixo = findViewById(R.id.tvValFixo1);
                tvValFixo.setText(estacs.getValFixo());

                TextView tvValAcresc = findViewById(R.id.tvAcrescHr1);
                tvValAcresc.setText(estacs.getValAcresc());

                TextView tvDisp = findViewById(R.id.tvDisp);
                tvDisp.setText(estacs.getVagasDisp());

            }
        });

    }
}