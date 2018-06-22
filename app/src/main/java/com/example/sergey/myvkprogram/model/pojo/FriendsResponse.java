package com.example.sergey.myvkprogram.model.pojo;

import java.util.List;

public class FriendsResponse {

    private Response response;

    public int getCount() {
        return (response == null) ? 0 : response.count;
    }

    public List<User> getItems() {
        return (response == null) ? null : response.items;
    }

    private class Response {
        private int count;
        private List<User> items;

        public int getCount() {
            return count;
        }

        public List<User> getItems() {
            return items;
        }
    }
}
