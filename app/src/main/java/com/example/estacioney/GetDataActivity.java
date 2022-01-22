package com.example.estacioney;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.estacioney.adapter.MyAdapter;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GetDataActivity extends AppCompatActivity {

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
        LiveData<List<ListaEstac>> listEstacs = getDataViewModel.getListaEstacs();
        listEstacs.observe(this, new Observer<List<ListaEstac>>() {
            @Override
            public void onChanged(List<ListaEstac> listaEstacs) {
                MyAdapter myAdapter = new MyAdapter(GetDataActivity.this, listaEstacs);
                rvListEstac.setAdapter(myAdapter);
            }
        });

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                HttpRequest httpRequest = new HttpRequest(Config.SERVER_URL_BASE + "get_data.php", "GET", "UTF-8");
                httpRequest.setBasicAuth(login, password);

                try {
                    InputStream is = httpRequest.execute();
                    String result = Util.inputStream2String(is, "UTF-8");
                    httpRequest.finish();

                    JSONObject jsonObject = new JSONObject(result);
                    final int success = jsonObject.getInt("success");
                    if(success == 1) {
                        final String webData = jsonObject.getString("data");
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                TextView tvWebData = findViewById(R.id.tvWebData);
                                tvWebData.setText(webData);
                            }
                        });

                    }
                    else {
                        final String error = jsonObject.getString("error");
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(GetDataActivity.this, error, Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }
            }
        });

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
    }
}
