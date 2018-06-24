package com.example.sergey.myvkprogram.contracts;

import android.support.annotation.NonNull;

import com.example.sergey.myvkprogram.model.pojo.object.Group;
import com.example.sergey.myvkprogram.presenter.base.Presenter;
import com.example.sergey.myvkprogram.view.interfaces.FragmentView;

import java.util.List;

public interface GroupsFragmentContract {

    interface GroupsFragmentView extends FragmentView {
        void showGroups(@NonNull List<Group> groups);

        void showError(@NonNull String message);
    }

    interface GroupsFragmentPresenter extends Presenter<GroupsFragmentView> {
        void groupsLoaded(@NonNull List<Group> groups);

        void groupsErrorLoaded(@NonNull String message);
    }

}
