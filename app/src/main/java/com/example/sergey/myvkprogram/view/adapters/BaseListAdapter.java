package com.example.sergey.myvkprogram.view.adapters;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sergey.myvkprogram.view.holders.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseListAdapter<T> extends RecyclerView.Adapter<BaseViewHolder<T>> {

    @NonNull
    private List<T> values = new ArrayList<>();

    @NonNull
    @Override
    public BaseViewHolder<T> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(getLayoutId(), parent, false);

        return getViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder<T> holder, int position) {
        if (position >= values.size()) {
            return;
        }

        holder.bindViewHolder(values.get(position), position);
    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    public void updateData(@NonNull List<T> values) {
        this.values.clear();
        this.values.addAll(values);
        notifyDataSetChanged();
    }

    @LayoutRes
    protected abstract int getLayoutId();

    @NonNull
    protected abstract BaseViewHolder<T> getViewHolder(@NonNull View view);
}
