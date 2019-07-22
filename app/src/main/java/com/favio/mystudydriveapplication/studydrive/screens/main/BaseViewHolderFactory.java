package com.favio.mystudydriveapplication.studydrive.screens.main;

import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

//UNUSED
//TODO: continue this one and move to core so that I have a common component for std projects
public interface BaseViewHolderFactory {
    RecyclerView.ViewHolder createViewHolder(ViewGroup parent);
}
