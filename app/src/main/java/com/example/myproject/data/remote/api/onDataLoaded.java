package com.example.myproject.data.remote.api;

import java.text.ParseException;

public interface onDataLoaded<T> {

    void onResponse (T data) throws ParseException;

    void onError(String msg) throws ParseException;
}