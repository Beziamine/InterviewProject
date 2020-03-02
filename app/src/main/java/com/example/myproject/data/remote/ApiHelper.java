package com.example.myproject.data.remote;

import android.util.Log;

import com.example.myproject.data.model.Model;
import com.example.myproject.data.model.ModelDetail;
import com.example.myproject.data.model.Response;
import com.example.myproject.data.remote.api.ApiServices;
import com.example.myproject.data.remote.api.Routes;
import com.example.myproject.data.remote.api.onDataLoaded;
import com.google.gson.Gson;

import java.net.UnknownHostException;
import java.security.cert.CertificateException;
import java.text.ParseException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import butterknife.internal.Utils;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ConnectionSpec;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.TlsVersion;
import retrofit2.HttpException;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiHelper {

    private ApiServices apiServices;


    public ApiHelper() {


        ConnectionSpec spec = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
                .tlsVersions(TlsVersion.TLS_1_0)
                .allEnabledCipherSuites()
                .build();
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.connectionSpecs(Collections.singletonList(spec));
        okHttpClient.readTimeout(5, TimeUnit.MINUTES)
                .writeTimeout(5, TimeUnit.MINUTES)
                .connectTimeout(5,TimeUnit.MINUTES);

        apiServices = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Routes.BASE_URL)
                .client(getUnsafeOkHttpClient().build())
                .build()
                .create(ApiServices.class);
    }

    public static OkHttpClient.Builder getUnsafeOkHttpClient() {
        try {
            // Create a trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }
            };

            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());

            // Create an ssl socket factory with our all-trusting manager
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.sslSocketFactory(sslSocketFactory, (X509TrustManager) trustAllCerts[0]);
            builder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
            return builder;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Response handleErrorResponse(Throwable throwable) {
        if (throwable instanceof HttpException) {
            HttpException exception = (HttpException) throwable;
            try {
                String jsonString = exception.response().errorBody().string();
                Gson gson = new Gson();
                Response response = gson.fromJson(jsonString, Response.class);
                if (response.getMessage() != null)
                    return response;
                else
                    return new Response(response.getCode(), response.getStatus());
            } catch (Exception e) {
                Log.e("API Error", e.getMessage());
                return new Response(500, "Erreur de serveur");
            }
        } else if (throwable instanceof UnknownHostException)
            return new Response(500, "Vérifier votre connexion");

        return new Response(500, "Erreur de serveur");
    }




    public void getList(String header, final onDataLoaded<List<Model>> onDataLoaded) {

        apiServices.getList(header)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Model>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<Model> listResponse) {
                        try {
                            onDataLoaded.onResponse(listResponse);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Response errorResponse = handleErrorResponse(e);
                        try {
                            onDataLoaded.onError(errorResponse.getStatus());
                        } catch (ParseException e1) {
                            e1.printStackTrace();
                        }
                    }
                });
    }


    public void getListDetail(String header,String id, final onDataLoaded<ModelDetail> onDataLoaded) {

        apiServices.getListDetail(header,id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<ModelDetail>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(ModelDetail listResponse) {
                        try {
                            onDataLoaded.onResponse(listResponse);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Response errorResponse = handleErrorResponse(e);
                        try {
                            onDataLoaded.onError(errorResponse.getStatus());
                        } catch (ParseException e1) {
                            e1.printStackTrace();
                        }
                    }
                });
    }


}
