package com.example.dawadoz.ui.presenter;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PageKeyedDataSource;
import androidx.paging.PagedList;

import com.example.dawadoz.db.entity.searchproducts.Data;
import com.example.dawadoz.db.entity.searchproducts.DtResult;
import com.example.dawadoz.db.entity.searchproducts.ItemDataSourceFactory;

public class ProductsPresenter extends ViewModel {

    public LiveData<PagedList<DtResult>> pagedListLiveData;
    public MutableLiveData<PageKeyedDataSource<Integer, DtResult>> dataSourceLiveData;

    public ProductsPresenter() {
        ItemDataSourceFactory itemDataSourceFactory = new ItemDataSourceFactory();
        dataSourceLiveData = itemDataSourceFactory.getMutableLiveData();

        PagedList.Config config = new PagedList.Config.Builder().setEnablePlaceholders(false).setPageSize(Data.RowspPage).build();
        pagedListLiveData = new LivePagedListBuilder<Integer, DtResult>(itemDataSourceFactory, config).build();
    }
}
