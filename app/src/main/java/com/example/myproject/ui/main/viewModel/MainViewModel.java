package com.example.myproject.ui.main.viewModel;

import com.example.myproject.data.model.Model;
import com.example.myproject.data.model.ModelDetail;
import com.example.myproject.data.model.Response;
import com.example.myproject.data.remote.api.onDataLoaded;
import com.example.myproject.ui.main.base.BaseViewModel;

import java.util.List;

import androidx.lifecycle.MutableLiveData;

public class MainViewModel extends BaseViewModel {

    private MutableLiveData<List<Model>> getListLiveData;

    private MutableLiveData<ModelDetail> getListDetailLiveData;


    public MutableLiveData<List<Model>> getListLiveData() {
        if (getListLiveData == null)
            getListLiveData = new MutableLiveData<>();
        return getListLiveData;
    }

    public MutableLiveData<ModelDetail> getListDetailLiveData() {
        if (getListDetailLiveData == null)
            getListDetailLiveData = new MutableLiveData<>();
        return getListDetailLiveData;
    }

    public void getList(String header) {

        getDataManager().getList(header,new onDataLoaded<List<Model>>() {
            @Override
            public void onResponse(List<Model> data) {
                getListLiveData.setValue(data);
            }

            @Override
            public void onError(String msg) {
                getListLiveData.setValue(null);
            }
        });
    }


    public void getListDetail(String header, String id) {

        getDataManager().getListDetail(header,id,new onDataLoaded<ModelDetail>() {
            @Override
            public void onResponse(ModelDetail data) {
                getListDetailLiveData.setValue(data);

        }
            @Override
            public void onError(String msg) {
                getListDetailLiveData.setValue(null);
            }
        });
    }

}
