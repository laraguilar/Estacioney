package com.example.estacioney;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EstacViewModel extends AndroidViewModel {
    MutableLiveData<Estacionamento> estacionamento;
    String idEstac;

    public EstacViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Estacionamento> getEstacionamento(){
        if(this.estacionamento == null){
            estacionamento = new MutableLiveData<Estacionamento>();
            loadEstacionamento();
        }
        return estacionamento;
    }

    void refreshEstacionamento(){
        loadEstacionamento();
    }

    void loadEstacionamento(){
        final String login = Config.getLogin(getApplication());
        final String password = Config.getPassword(getApplication());

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                HttpRequest httpRequest = new HttpRequest(Config.SERVER_URL_BASE + "estacHome.php", "POST", "UTF-8");
                httpRequest.setBasicAuth(login, password);
                httpRequest.addParam("idEstac", idEstac);
                try {
                    InputStream is = httpRequest.execute();
                    String result = Util.inputStream2String(is, "UTF-8");
                    httpRequest.finish();

                    Log.d("HTTP_REQUEST_RESULT", result);

                    JSONObject jsonObject = new JSONObject(result);
                    int success = jsonObject.getInt("success");

                    if(success == 1) {
                        JSONArray jsonArray =  jsonObject.getJSONArray("dadosEstac");
                        JSONObject jProduct = jsonArray.getJSONObject(0);

                        String nomEstac = jProduct.getString("nomEstac");
                        String qtdVagas = jProduct.getString("qtdVagas");
                        String valFixo = jProduct.getString("valFixo");
                        String valAcresc = jProduct.getString("valAcresc");

                        Estacionamento e = new Estacionamento(nomEstac, qtdVagas, valFixo, valAcresc);

                        estacionamento.postValue(e);

                    }
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
