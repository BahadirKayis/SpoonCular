package com.layercontent.spoonacularcallculatortwo;




import com.layercontent.spoonacularcallculatortwo.search.Search;
import com.layercontent.spoonacularcallculatortwo.search.Tarifbilgi.TarifBilgi;
import com.layercontent.spoonacularcallculatortwo.search.benzertarifler.BenzerTarifler;
import com.layercontent.spoonacularcallculatortwo.search.rastgeletarif.RastgeleTarif;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface TarifInterFace {


    @POST("complexSearch")
    @FormUrlEncoded
    Call<Search>searchResult(@Field("apiKey")String key, @Field("query")String araTarif);

    @POST()
    @FormUrlEncoded
    Call<TarifBilgi>GetTarifBilgi(@Field("apiKey")String key, @Field("includeNutrition")Boolean TfBoolen);
@GET("similar")
    Call<BenzerTarifler>GetBenzerTarif(@Query("apiKey") String key);

@GET("random")
Call<RastgeleTarif> GetRastgeleTarif(@Query("apiKey") String key);

}

