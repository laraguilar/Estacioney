package com.example.estacioney.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.estacioney.ListaEstac;
import com.example.estacioney.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter {

    Context context;
    List<ListaEstac> listaEstacs;
    


    public MyAdapter(Context context, List<ListaEstac> listaEstacs) {
        this.context = context;
        this.listaEstacs = listaEstacs;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.estacionamento, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ListaEstac listaEstac = this.listaEstacs.get(position);

        TextView tvEstacList = holder.itemView.findViewById(R.id.tvEstacList);
        tvEstacList.setText(listaEstac.getNomEstac());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, ListaEstac.class); // isso nao deveria ser uma classe que extende AppCompatActivity???
                i.putExtra("nomEstac", listaEstac.getNomEstac());
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.listaEstacs.size();
    }
}
