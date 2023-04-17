package com.example.doctorplus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    MedicamentoAPI medicamentoAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        medicamentoAPI = APIClient.getClient().create(MedicamentoAPI.class);


    }
    public void buscarMedicamento(View view) {


        Call<Medicamento> call = medicamentoAPI.get(); // reemplazar el 1 nombre medicamento
        call.enqueue(new Callback<Medicamento>() {

            public void onResponse(Call<Medicamento> call, Response<Medicamento> response) {
                if (response.isSuccessful()) {
                    Medicamento medicamento = response.body();
                    String nombreMedicamento = medicamento.getId() + " " + medicamento.getContent();
                    Toast.makeText(MainActivity.this, "El nombre del medicamento es: " + nombreMedicamento, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Error en la respuesta", Toast.LENGTH_SHORT).show();
                }
            }

            public void onFailure(Call<Medicamento> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(MainActivity.this, "Error en la llamada a la API", Toast.LENGTH_SHORT).show();
            }
        });
    }

}