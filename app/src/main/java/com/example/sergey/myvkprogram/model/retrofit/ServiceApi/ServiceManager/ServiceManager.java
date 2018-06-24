package com.example.sergey.myvkprogram.model.retrofit.ServiceApi.ServiceManager;

public interface ServiceManager {

    <S> S createService(Class<S> service, String baseUrl);

}
