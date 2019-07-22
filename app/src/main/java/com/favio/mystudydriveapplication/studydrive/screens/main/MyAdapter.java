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

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.RateViewHolder> {

    private Context context;
    List<MyItem> currencies;
    MainViewModel viewModel;
    RecyclerView recyclerView;


    @Inject
    public MyAdapter(Context context, List<MyItem> currencies, MainViewModel viewModel) {
        this.context = context;
        this.currencies = currencies;
        this.viewModel = viewModel;

    }

    @NonNull
    @Override
    public RateViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.my_item,
                viewGroup, false);
        return new RateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RateViewHolder holder, int position) {
        MyItem currency = currencies.get(position);
        holder.getBinding().description.setText(currency.getDescription());
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }

    public String formatToPresicionTwo(float number) {
        DecimalFormat formatter = new DecimalFormat("0.00");
        return formatter.format(number);
    }

    @Override
    public int getItemCount() {
        return currencies.size();
    }

    public void updateData(List<MyItem> value) {
        if (currencies != null && value != null && currencies.size() == value.size()) {
            updateRateListItems(value);
            recyclerView.getRecycledViewPool().clear();
            notifyDataSetChanged();
        } else {
            currencies = value;
            recyclerView.getRecycledViewPool().clear();
            notifyDataSetChanged();
        }
    }

    public void updateRateListItems(List<MyItem> value) {
        List<MyItem> c = new ArrayList<>();
        c.addAll(value);
        DiffUtil.Callback diffCallback = new ItemsDiffCallback(currencies, c);
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffCallback);
        this.currencies.clear();
        this.currencies.addAll(c);
        diffResult.dispatchUpdatesTo(this);
    }

    public class RateViewHolder extends RecyclerView.ViewHolder {
        private MyItemBinding binding;

        public RateViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

        public MyItemBinding getBinding() {
            return binding;
        }
    }
}
