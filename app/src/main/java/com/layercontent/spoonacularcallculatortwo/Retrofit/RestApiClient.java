package com.layercontent.spoonacularcallculatortwo.Retrofit;



import com.layercontent.spoonacularcallculatortwo.TarifInterFace;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiClient {
    private TarifInterFace mRestApi;
    public RestApiClient(String restapiServiceUrl){
        OkHttpClient.Builder builder=new OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30,TimeUnit.SECONDS)
                .connectTimeout(30,TimeUnit.SECONDS);
        OkHttpClient okHttpClient=builder.build();
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(restapiServiceUrl).client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mRestApi=retrofit.create(TarifInterFace.class);

    }
    public TarifInterFace getmRestApi(){
        return mRestApi;
    }

}
