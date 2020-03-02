package com.example.myproject.ui.main.base;

import com.example.myproject.data.DataManager;

import androidx.lifecycle.ViewModel;

public class BaseViewModel extends ViewModel {

    private DataManager dataManager;

    public BaseViewModel() {
        dataManager = new DataManager();
    }

    public DataManager getDataManager() {
        return dataManager;
    }

}