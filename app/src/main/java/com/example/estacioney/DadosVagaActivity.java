package com.example.estacioney;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DadosVagaActivity extends AppCompatActivity {
    String idAlocado;
    String nomCliente;
    String placa;
    String hrEntrada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_vaga);

        Intent i = getIntent();
        idAlocado = i.getStringExtra("idAlocado");
        nomCliente = i.getStringExtra("nomCliente");
        placa = i.getStringExtra("placa");
        hrEntrada = i.getStringExtra("hrEntrada");

        final String login = Config.getLogin(DadosVagaActivity.this);
        final String password = Config.getPassword(DadosVagaActivity.this);

        TextView tvNomCliente = findViewById(R.id.tvNomCliente2);
        tvNomCliente.setText(nomCliente);

        TextView tvPlaca = findViewById(R.id.tvPlaca2);
        tvPlaca.setText(placa);

        TextView tvHrEntrada = findViewById(R.id.tvHrEntrada2);
        tvHrEntrada.setText(hrEntrada);


        Button btnLiberar = findViewById(R.id.btnLiberar);
        btnLiberar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // liberar vaga
            }
        });

    }
}