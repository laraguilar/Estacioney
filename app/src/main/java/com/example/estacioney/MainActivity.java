package com.example.estacioney;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RecyclerView rvEstacionamentos = findViewById(R.id.rvListEstac);
        rvEstacionamentos.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvEstacionamentos.setLayoutManager(layoutManager);

        MainViewModel mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        LiveData<List<ListaEstac>> listEstacs = mainViewModel.getListaEstacs();
        listEstacs.observe(this, new Observer<List<ListaEstac>>() {
            @Override
            public void onChanged(List<ListaEstac> listaEstacs) {
                MyAdapter myAdapter = new MyAdapter(MainActivity.this, listaEstacs);
                rvEstacionamentos.setAdapter(myAdapter);
            }
        });



        if(Config.getLogin(MainActivity.this).isEmpty()) {
            Intent i = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(i);
            finish();
        }
        else {
            Intent i = new Intent(MainActivity.this, GetDataActivity.class);
            startActivity(i);
            finish();
        }
    }
}
