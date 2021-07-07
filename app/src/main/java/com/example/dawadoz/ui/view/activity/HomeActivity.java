package com.example.dawadoz.ui.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.dawadoz.R;
import com.example.dawadoz.db.entity.searchproducts.DtResult;
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
        itemViewModel.pagedListLiveData.observe(this, new Observer<PagedList<DtResult>>() {
            @Override
            public void onChanged(PagedList<DtResult> dtResults) {
                adapter.submitList(dtResults);
                if (!isNetworkConnected()) {
                    findViewById(R.id.linearLayoutError).setVisibility(View.VISIBLE);
                } else if (dtResults.size() <= 0) {
                    findViewById(R.id.progressBar).setVisibility(View.VISIBLE);
                } else {
                    findViewById(R.id.linearLayoutError).setVisibility(View.GONE);
                    findViewById(R.id.progressBar).setVisibility(View.GONE);
                }
            }
        });
    }

    private boolean isNetworkConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }
}