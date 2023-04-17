package com.example.doctorplus;

import com.example.doctorplus.Medicamento;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MedicamentoAPI {
    @GET("greeting")
    Call<Medicamento> get();
}
