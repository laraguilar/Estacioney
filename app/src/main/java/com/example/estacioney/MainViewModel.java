package com.example.estacioney;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainViewModel  extends ViewModel {
    final String login = Config.getLogin(MainViewModel.this);
    MutableLiveData<List<ListaEstac>> listaEstacs;

    public LiveData<List<ListaEstac>> getListaEstacs(){
        if (listaEstacs == null){
            listaEstacs = new MutableLiveData<List<ListaEstac>>();
            loadListaEstac();
        }

        return listaEstacs;

    }

    private void loadListaEstac() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                HttpRequest httpRequest = new HttpRequest(Config.SERVER_URL_BASE + "get_data.php", "GET", "UTF-8");
            }
        });
    }
}
