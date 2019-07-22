package com.favio.mystudydriveapplication.studydrive.screens.main;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.favio.mystudydriveapplication.R;
import com.favio.mystudydriveapplication.core.base.BaseActivity;
import com.favio.mystudydriveapplication.databinding.ActivityMainBinding;
import com.favio.mystudydriveapplication.studydrive.model.MyItem;
import com.favio.mystudydriveapplication.studydrive.utils.Constants;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends BaseActivity<MainViewModel> {

    private List<MyItem> currencies = new ArrayList<>();
    private ActivityMainBinding binding;
    private RecyclerView recyclerView;
    private MyAdapter adapter;
    Button button;


    @Inject
    MainViewModel viewModel;

    @Override
    public MainViewModel getViewModel() {
        return viewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initBinding();
        initRecyclerView();
        //initSubject(); TODO: better perhaps to use subjects here in the future
        //getRates();
        this.setTitle("A test from Studydrive");
    }

    private void initRecyclerView() {
        adapter = new MyAdapter(this, currencies ,getViewModel());
        recyclerView = binding.recycler;
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void initBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.consumer.setOnClickListener(listener);
        binding.producer.setOnClickListener(listener);
    }

    public View.OnClickListener listener = view -> {

        //Check to confirm the instance of view i.e Button
        if (view instanceof Button) {
            button = (Button) view;
            //Checks to play stage 1 at default
            if (button.getText().toString().toLowerCase().equals("new consumer")) {
                //adapter.createNewConsumer();
                getRates(Constants.CONSUMER);
            } else{
                //adapter.createNewProducer();
                getRates(Constants.PRODUCER);
            }

        } else {
            Log.e("View Instance:", "Error in getting the instance of view");
        }
    };

    public void getRates(String type) {
        viewModel.getRates(type).observe(this, response -> {
            if (response != null) {
                adapter.updateData(response);

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        viewModel.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        viewModel.onStop();
    }
}
