package com.example.sergey.myvkprogram.model.retrofit.ServiceApi;


import static com.example.sergey.myvkprogram.model.retrofit.ServiceApi.Constants.Url.PHOTO_SIZE.PHOTO_100;
import static com.example.sergey.myvkprogram.model.retrofit.ServiceApi.Constants.Url.PHOTO_SIZE.PHOTO_50;

public interface Constants {

    int MOCK_USER_ID = 55853071;

    interface Url {
        String BASE_URL = "https://api.vk.com/method/";

        interface PHOTO_SIZE {
            String PHOTO_50 = "photo_50";
            String PHOTO_100 = "photo_100";
        }

        interface Params {

            interface Key {
                String ACCESS_TOKEN = "access_token";
                String VERSION_API = "v";
            }

            interface Value {
                String ACCESS_TOKEN = "81c8124ca93c70f5bbbcdb676955ddb2553d6b12ea99708d9baece8736bf13ac6388e710476a283eb5503";
                String VERSION_API = "5.80";
            }

            interface PhotosQuery {

                interface Key {
                    String OWNER_ID = "owner_id";
                    String ALBUM_ID = "album_id";
                    String ORDER = "rev";
                }

                interface Value {
                    String ORDER = "1";

                    String ALBUM_WALL = "wall";
                    String ALBUM_PROFILE = "profile";
                    String ALBUM_SAVED = "saved";
                }

            }

            interface VideosQuery {

                interface Key {
                    String OWNER_ID = "owner_id";
                    String EXTENDED = "extended";
                }

                interface Value {
                    String EXTENDED = "1";
                }

            }

            interface FriendsQuery {

                interface Key {
                    String USER_ID = "user_id";
                    String ORDER = "order";
                    String FIELDS = "fields";
                }

                interface Value {
                    String ORDER = "name";
                    String FIELDS = PHOTO_50;
                }

            }

            interface GroupsQuery {

                interface Key {
                    String USER_ID = "user_id";
                    String EXTENDED = "extended";
                    String FIELDS = "fields";
                }

                interface Value {
                    String EXTENDED = "1";
                    String FIELDS = PHOTO_100;
                }

            }

        }
    }
}
