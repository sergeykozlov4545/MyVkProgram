package com.example.sergey.myvkprogram.model.pojo;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("id")
    private long id;

    @SerializedName("first_name")
    private String firstName;

    @SerializedName("last_name")
    private String lastName;

    @SerializedName("photo_50")
    private String photoUrl;

    @SerializedName("photo_200_orig")
    private String originalPhotoUrl;

    @SerializedName("online")
    private int online;

    @SerializedName("bdate")
    private String birthDay;

    @SerializedName("city")
    private City city;

    @SerializedName("country")
    private Country country;

    @SerializedName("counters")
    private CountersResponse counters;

    public User(String firstName, String lastName, String photoUrl, int online) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.photoUrl = photoUrl;
        this.online = online;
    }

    public long getId() {
        return id;
    }

    public String getAllName() {
        return firstName + " " + lastName;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public String getOriginalPhotoUrl() {
        return originalPhotoUrl;
    }

    public boolean isOnline() {
        return online == 1;
    }

    public City getCity() {
        return city;
    }

    public Country getCountry() {
        return country;
    }

    public CountersResponse getCounters() {
        return counters;
    }

    private class City {
        int id;
        String title;

        public String getTitle() {
            return title;
        }
    }

    private class Country {
        int id;
        String title;

        public String getTitle() {
            return title;
        }
    }
}
