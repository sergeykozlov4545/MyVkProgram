package com.example.sergey.myvkprogram.view.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sergey.myvkprogram.R;
import com.example.sergey.myvkprogram.model.pojo.object.Photo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhotosListAdapter extends RecyclerView.Adapter<PhotosListAdapter.ViewHolderBase> {

    private static final int YEAR_LAYOUT = android.R.layout.simple_list_item_1;
    private static final int PHOTO_LAYOUT = R.layout.fragment_photos_list_photo_item;

    private List<ListItem> data = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolderBase onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(viewType, parent, false);

        return (viewType == YEAR_LAYOUT)
                ? new YearViewHolder(view)
                : new PhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderBase holder, int position) {
        if (position >= data.size()) {
            return;
        }

        holder.bindViewHolder(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position >= data.size()) {
            return YEAR_LAYOUT;
        }

        return (data.get(position).getItemType() == ListItemType.YEAR) ? YEAR_LAYOUT : PHOTO_LAYOUT;
    }

    public void updateData(@NonNull List<Photo> photos) {
        this.data.clear();
        this.data.addAll(getListItems(photos));
        notifyDataSetChanged();
    }

    @NonNull
    private List<ListItem> getListItems(@NonNull List<Photo> photos) {
        Map<Integer, List<Photo>> map = new HashMap<>();

        for (Photo photo : photos) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(photo.getDate());
            int year = calendar.get(Calendar.YEAR);

            List<Photo> groupPhotos = map.get(year);
            if (groupPhotos == null) {
                groupPhotos = new ArrayList<>();
                map.put(year, groupPhotos);
            }

            groupPhotos.add(photo);
        }

        List<Integer> years = new ArrayList<>(map.keySet());
        Collections.sort(years, (o1, o2) -> Integer.compare(o2, o1));

        for (List<Photo> items : map.values()) {
            Collections.sort(items, (o1, o2) -> Long.compare(o2.getDate(), o1.getDate()));
        }

        List<ListItem> listItems = new ArrayList<>();
        for (Integer year : years) {
            listItems.add(new YearListItem(String.valueOf(year)));

            for (Photo photo : map.get(year)) {
                listItems.add(new PhotoListItem(photo));
            }
        }

        return listItems;
    }

    abstract class ViewHolderBase extends RecyclerView.ViewHolder {

        ViewHolderBase(View itemView) {
            super(itemView);
        }

        public abstract void bindViewHolder(@NonNull ListItem item);
    }

    class YearViewHolder extends ViewHolderBase {

        private TextView yearView;

        YearViewHolder(View itemView) {
            super(itemView);

            yearView = itemView.findViewById(android.R.id.text1);
        }

        @Override
        public void bindViewHolder(@NonNull ListItem item) {
            yearView.setText(((YearListItem) item).getYear());
        }
    }

    class PhotoViewHolder extends ViewHolderBase {

        private ImageView photoView;

        PhotoViewHolder(View itemView) {
            super(itemView);

            photoView = itemView.findViewById(R.id.photo);
        }

        @Override
        public void bindViewHolder(@NonNull ListItem item) {
            photoView.setVisibility(View.GONE);
        }
    }

    private enum ListItemType {
        YEAR,
        PHOTO
    }

    private interface ListItem {
        @NonNull
        ListItemType getItemType();
    }

    private class YearListItem implements ListItem {

        private String year;

        public YearListItem(@NonNull String year) {
            this.year = year;
        }

        @NonNull
        @Override
        public ListItemType getItemType() {
            return ListItemType.YEAR;
        }

        @NonNull
        public String getYear() {
            return year;
        }
    }

    private class PhotoListItem implements ListItem {

        private Photo photo;

        public PhotoListItem(@NonNull Photo photo) {
            this.photo = photo;
        }

        @NonNull
        @Override
        public ListItemType getItemType() {
            return ListItemType.PHOTO;
        }

        @NonNull
        public Photo getPhoto() {
            return photo;
        }
    }
}
