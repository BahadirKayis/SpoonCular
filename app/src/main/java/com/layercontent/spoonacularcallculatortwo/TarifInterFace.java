package com.layercontent.spoonacularcallculatortwo;


import com.layercontent.spoonacularcallculatortwo.search.Otomatiktanimlama;
import com.layercontent.spoonacularcallculatortwo.search.Search;
import com.layercontent.spoonacularcallculatortwo.search.Tarifbilgi.TarifBilgi;
import com.layercontent.spoonacularcallculatortwo.search.benzertarifler.BenzerTarifler;
import com.layercontent.spoonacularcallculatortwo.search.rastgeletarif.RastgeleTarif;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TarifInterFace {

    @GET("autocomplete")
    Call<List<Otomatiktanimlama>> GetoutoSearch(@Query("apiKey") String key,@Query("query") String araTarif) ;

    @GET("complexSearch")
    Call<Search> GetComplexSearch(@Query("query") String araTarif,@Query("apiKey") String key) ;

    @GET("{TarifID}/information")
    Call<TarifBilgi> GetTarifBilgi(@Path(value = "TarifID", encoded = true)String TarifID, @Query("apiKey") String key);

    @GET("{TarifID}/similar")
    Call<List<BenzerTarifler>> GetBenzerTarif(@Path(value = "TarifID", encoded = true) String TarifID, @Query("apiKey") String key);

    @GET("random")
    Call<RastgeleTarif> GetRastgeleTarif(@Query("apiKey") String key,@Query("number")String number);

}

