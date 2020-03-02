package com.example.myproject.data;

import com.example.myproject.data.model.Model;
import com.example.myproject.data.model.ModelDetail;
import com.example.myproject.data.model.Response;
import com.example.myproject.data.remote.ApiHelper;
import com.example.myproject.data.remote.api.onDataLoaded;

import java.util.List;

public class DataManager {

    private ApiHelper apiHelper;

    public DataManager() {
        apiHelper = new ApiHelper();
    }

    public void getList(String header ,onDataLoaded<List<Model>> onDataLoaded) {
        apiHelper.getList(header,onDataLoaded);
    }

    public void getListDetail(String header,String id,onDataLoaded<ModelDetail> onDataLoaded) {
        apiHelper.getListDetail(header,id,onDataLoaded);
    }
}
