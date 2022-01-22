package com.example.estacioney;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GetDataViewModel extends ViewModel {
    String login = Config.getLogin(GetDataViewModel.this);
    MutableLiveData<List<ListaEstac>> listaEstacs;

    public LiveData<List<ListaEstac>> getListaEstacs(){
        if(listaEstacs == null){
            listaEstacs = new MutableLiveData<List<ListaEstac>>();
            loadListaEstac();
        }
        return listaEstacs;
    }

    void loadListaEstac(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                HttpRequest httpRequest = new HttpRequest(Config.SERVER_URL_BASE + "get_data.php", "GET", "UTF-8");
            }
        });
    }
}
