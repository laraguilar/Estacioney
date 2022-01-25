package com.example.estacioney;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.estacioney.adapter.MyAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.time.Duration;
import java.util.List;

public class GetDataActivity extends AppCompatActivity {
    private Duration ViewModelProviders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_data);

        final String login = Config.getLogin(GetDataActivity.this);
        final String password = Config.getPassword(GetDataActivity.this);

        RecyclerView rvListEstac = findViewById(R.id.rvListEstac);
        rvListEstac.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvListEstac.setLayoutManager(layoutManager);

        GetDataViewModel getDataViewModel = new ViewModelProvider(this).get(GetDataViewModel.class);
        LiveData<List<Estacionamento>> listEstacs = getDataViewModel.getListaEstacs();
        listEstacs.observe(this, new Observer<List<Estacionamento>>() {
            @Override
            public void onChanged(List<Estacionamento> listEstacs) {
                MyAdapter myAdapter = new MyAdapter(GetDataActivity.this, listEstacs);
                rvListEstac.setAdapter(myAdapter);
            }
        });

        getDataViewModel.refreshEstacs();

        Button btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Config.setLogin(GetDataActivity.this, "");
                Config.setPassword(GetDataActivity.this, "");
                Intent i = new Intent(GetDataActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });

        FloatingActionButton btnAddEstac = findViewById(R.id.btnAddEstac);
        btnAddEstac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(GetDataActivity.this, CadEstacActivity.class);
                startActivity(a);
            }
        });

    }

}
