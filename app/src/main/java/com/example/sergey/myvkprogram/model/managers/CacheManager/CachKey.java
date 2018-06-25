package com.example.sergey.myvkprogram.model.managers.CacheManager;

public interface CachKey {
    interface PhotosFragment {
        String FIRST_VISIBLE = "first_visible_photos_fragment";
        String ITEMS_DATA = "photos_fragment_data";
    }

    interface VideosFragment {
        String FIRST_VISIBLE = "first_visible_videos_fragment";
        String ITEMS_DATA = "videos_fragment_data";
    }

    interface FriendsFragment {
        String FIRST_VISIBLE = "first_visible_friends_fragment";
        String ITEMS_DATA = "friends_fragment_data";
    }

    interface GroupsFragment {
        String FIRST_VISIBLE = "first_visible_groups_fragment";
        String ITEMS_DATA = "groups_fragment_data";
    }
}
