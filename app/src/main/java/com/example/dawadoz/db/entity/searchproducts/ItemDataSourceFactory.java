package com.example.dawadoz.db.entity.searchproducts;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource;

import com.example.dawadoz.repository.Repository;

import org.jetbrains.annotations.NotNull;

public class ItemDataSourceFactory extends DataSource.Factory{

    private MutableLiveData<PageKeyedDataSource<Integer, DtResult>> mutableLiveData;

    public ItemDataSourceFactory() {
        mutableLiveData = new MutableLiveData<>();
    }

    @NotNull
    @Override
    public DataSource create() {
        Repository itemDataSource = new Repository();
        mutableLiveData.postValue(itemDataSource);
        return itemDataSource;
    }

    public MutableLiveData<PageKeyedDataSource<Integer, DtResult>> getMutableLiveData() {
        return mutableLiveData;
    }
}
