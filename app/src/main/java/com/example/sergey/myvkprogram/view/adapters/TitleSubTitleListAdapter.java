package com.example.sergey.myvkprogram.view.adapters;

import com.example.sergey.myvkprogram.R;

public abstract class TitleSubTitleListAdapter<T> extends BaseListAdapter<T> {

    @Override
    protected int getLayoutId() {
        return R.layout.roundedimageview_title_subtile_list_item;
    }
}
