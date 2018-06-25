package com.example.sergey.myvkprogram.model.managers.ServiceManager;

public interface ServiceManager {
    <S> S createService(Class<S> service, String baseUrl);
}
