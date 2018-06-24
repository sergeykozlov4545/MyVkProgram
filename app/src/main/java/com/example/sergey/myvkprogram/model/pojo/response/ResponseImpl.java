package com.example.sergey.myvkprogram.model.pojo.response;

import java.util.List;

public class ResponseImpl<U extends Response> implements Response<U> {

    private U response;

    @Override
    public int getCount() {
        return (response == null) ? 0 : response.getCount();
    }

    @Override
    public List getItems() {
        return (response == null) ? null : response.getItems();
    }

}
