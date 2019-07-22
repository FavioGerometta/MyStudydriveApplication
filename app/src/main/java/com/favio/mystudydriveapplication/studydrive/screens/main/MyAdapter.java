package com.favio.mystudydriveapplication.studydrive.screens.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.favio.mystudydriveapplication.R;
import com.favio.mystudydriveapplication.databinding.MyItemBinding;
import com.favio.mystudydriveapplication.studydrive.model.MyItem;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ItemViewHolder> {

    private Context context;
    List<MyItem> items;
    MainViewModel viewModel;
    RecyclerView recyclerView;


    @Inject
    public MyAdapter(Context context, List<MyItem> items, MainViewModel viewModel) {
        this.context = context;
        this.items = items;
        this.viewModel = viewModel;

    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.my_item,
                viewGroup, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        MyItem item = items.get(position);
        holder.getBinding().description.setText(item.getDescription());
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void updateData(List<MyItem> value) {
        if (items != null && value != null && items.size() == value.size()) {
            updateRateListItems(value);
            recyclerView.getRecycledViewPool().clear();
            notifyDataSetChanged();
        } else {
            items = value;
            recyclerView.getRecycledViewPool().clear();
            notifyDataSetChanged();
        }
    }

    public void updateRateListItems(List<MyItem> value) {
        List<MyItem> c = new ArrayList<>();
        c.addAll(value);
        DiffUtil.Callback diffCallback = new ItemsDiffCallback(items, c);
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffCallback);
        this.items.clear();
        this.items.addAll(c);
        diffResult.dispatchUpdatesTo(this);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private MyItemBinding binding;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

        public MyItemBinding getBinding() {
            return binding;
        }
    }
}
