package com.example.myproject.data.remote.api;

import com.example.myproject.data.model.Model;
import com.example.myproject.data.model.ModelDetail;
import com.example.myproject.data.model.Response;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface ApiServices {

    @GET(Routes.GET_LIST)
    Single<List<Model>> getList(@Header("Authorization") String Authorization);

    @GET(Routes.GET_LIST_DETAIL)
    Single<ModelDetail> getListDetail(@Header("Authorization") String Authorization, @Path("id") String id);
}
