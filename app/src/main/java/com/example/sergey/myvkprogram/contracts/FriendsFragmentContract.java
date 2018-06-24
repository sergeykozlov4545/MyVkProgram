package com.example.sergey.myvkprogram.contracts;

import android.support.annotation.NonNull;

import com.example.sergey.myvkprogram.model.pojo.object.User;
import com.example.sergey.myvkprogram.presenter.base.Presenter;
import com.example.sergey.myvkprogram.view.interfaces.FragmentView;

import java.util.List;

public interface FriendsFragmentContract {

    interface FriendsFragmentView extends FragmentView {
        void showFriends(@NonNull List<User> users);

        void showError(@NonNull String message);
    }

    interface FriendsFragmentPresenter extends Presenter<FriendsFragmentView> {
        void friendsLoaded(@NonNull List<User> users);

        void friendsErrorLoaded(@NonNull String message);
    }

}
