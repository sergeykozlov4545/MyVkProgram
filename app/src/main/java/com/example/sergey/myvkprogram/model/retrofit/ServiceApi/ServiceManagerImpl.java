package com.example.sergey.myvkprogram.model.retrofit.ServiceApi;

import com.example.sergey.myvkprogram.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceManagerImpl implements ServiceManager {

    @Override
    public <S> S createService(Class<S> service, String baseUrl) {
        Retrofit.Builder builder = getRetrofit(baseUrl);
        Retrofit retrofit = builder.build();
        return retrofit.create(service);
    }

    private Retrofit.Builder getRetrofit(String baseUrl) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .client(getOkHttpClient())
                .baseUrl(baseUrl);
    }

    private OkHttpClient getOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            builder.addInterceptor(loggingInterceptor);
        }

        return builder.build();
    }
}
