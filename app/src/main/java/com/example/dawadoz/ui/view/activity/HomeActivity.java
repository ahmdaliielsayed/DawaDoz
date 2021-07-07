package com.example.dawadoz.ui.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.dawadoz.R;
import com.example.dawadoz.ui.presenter.ProductsPresenter;
import com.example.dawadoz.ui.view.adapter.ItemAdapter;

public class HomeActivity extends AppCompatActivity {

    ProductsPresenter itemViewModel;
    private ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initComponent();
    }

    private void initComponent() {
        itemViewModel = ViewModelProviders.of(this).get(ProductsPresenter.class);
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ItemAdapter();
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        itemViewModel.pagedListLiveData.observe(this, dtResults -> adapter.submitList(dtResults));
    }
}