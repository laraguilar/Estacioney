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

import org.w3c.dom.Text;

public class EstacionamentoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estacionamento);

        final String login = Config.getLogin(EstacionamentoActivity.this);
        final String password = Config.getPassword(EstacionamentoActivity.this);

        EstacionamentoViewModel estacionamentoViewModel = new ViewModelProvider(this).get(EstacionamentoViewModel.class);
        LiveData<Estacionamento> estacs = estacionamentoViewModel.getEstacionamento();
        estacs.observe(this, new Observer<Estacionamento>() {
            @Override
            public void onChanged(Estacionamento estacs) {
                TextView tvnomEstac = findViewById(R.id.tvNomEstacE);
                tvnomEstac.setText(estacs.getNomEstac());

                TextView tvQtdVagas = findViewById(R.id.tvQtdVagas);
                tvQtdVagas.setText(estacs.getQtdVagas());

                TextView tvValFixo = findViewById(R.id.tvValFixo2);
                tvValFixo.setText(estacs.getValFixo());

                TextView tvValAcresc = findViewById(R.id.tvValAcresc);
                tvValAcresc.setText(estacs.getValAcresc());

                String end = estacs.getCep() + "\n" + estacs.getLogr() + ", " + estacs.getNum() + "\n" + estacs.getBairro()
                        + " - " +  estacs.getCidade() + " - " + estacs.getEstado();

                TextView tvEnd = findViewById(R.id.tvEnd);
                tvEnd.setText(end);

            }
        });

        Button btnDadosEmpresa = findViewById(R.id.btnDadosEmp);
        btnDadosEmpresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(EstacionamentoActivity.this, EmpresaActivity.class);
                startActivity(i);
            }
        });

    }

}