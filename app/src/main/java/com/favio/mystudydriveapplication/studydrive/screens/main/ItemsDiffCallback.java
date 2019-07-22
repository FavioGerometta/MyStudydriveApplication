package com.favio.mystudydriveapplication.studydrive.screens.main;

import androidx.recyclerview.widget.DiffUtil;

import com.favio.mystudydriveapplication.studydrive.model.MyItem;

import java.util.List;

public class ItemsDiffCallback extends DiffUtil.Callback{

    List<MyItem> oldList;
    List<MyItem> newList;

    public ItemsDiffCallback(List<MyItem> newList, List<MyItem> oldList) {
        this.newList = newList;
        this.oldList = oldList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).getDescription() == newList.get(newItemPosition).getDescription();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).getDescription().equals(newList.get(newItemPosition).getDescription());
    }
}