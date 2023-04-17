package com.example.doctorplus;

import com.google.gson.annotations.SerializedName;

public class Medicamento {
    @SerializedName("id")
    private int id;
    @SerializedName("content")
    private String content;

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }


}



