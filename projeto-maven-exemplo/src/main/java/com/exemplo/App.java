package com.exemplo;

import com.google.gson.Gson;

public class App {
    public static void main(String[] args) {
        Pessoa p = new Pessoa("Leonardo", 20);

        Gson gson = new Gson();
        String json = gson.toJson(p);

        System.out.println("Objeto convertido para JSON:");
        System.out.println(json);
    }
}