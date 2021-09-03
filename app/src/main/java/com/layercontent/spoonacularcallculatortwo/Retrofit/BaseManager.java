package com.layercontent.spoonacularcallculatortwo.Retrofit;


import com.layercontent.spoonacularcallculatortwo.TarifInterFace;

public class BaseManager {
    protected TarifInterFace GetTarif(){
        RestApiClient restApiClient=new RestApiClient(BaseUrl.BASE_URL);
        return restApiClient.getmRestApi();
    }
    protected TarifInterFace GetTarifBENZER(){
        RestApiClient restApiClient=new RestApiClient(BaseUrl.BASE_URLBENZER);
        return restApiClient.getmRestApi();
    }
}
