package com.example.sergey.myvkprogram.model.pojo.response;

import java.util.List;

public interface Response<T> {

    int getCount();

    List<T> getItems();

}
