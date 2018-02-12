package com.sandec.wakhyudi.presensirt8.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wakhyudi on 05/02/18.
 */

public class ServiceGenerator {

    private static final String BASE_URL = "https://script.google.com/macros/s/AKfycbwK0LlMlZ9wTmQA6LIqsSAh2FsxPwTRlaybyZbP9QjHRkkbdyM/";

    private static Gson gson = new GsonBuilder().setLenient().create();
    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory
                    (GsonConverterFactory.create(gson))
            .build();

    public static <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }
}
