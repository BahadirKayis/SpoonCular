package com.layercontent.spoonacularcallculatortwo.Retrofit;



import com.layercontent.spoonacularcallculatortwo.search.benzertarifler.BenzerTarifler;
import com.layercontent.spoonacularcallculatortwo.search.rastgeletarif.RastgeleTarif;

import java.util.List;

import retrofit2.Call;

public class ManegarAll extends BaseManager {
    private static ManegarAll ourınstance=new ManegarAll();
    public static synchronized ManegarAll getInstance(){
        return ourınstance;
    }

    public Call<RastgeleTarif> getirRandomTarif(String api){

        //apiutilsa gidiyor
        //oradan getuserinter clasını çağırıyor oradan da interface den bilgiler clasını çağırıyor,
        //ondan sonra getirbilgiler sınıfını bilgilerin görüneceği yerde çağırıyoruz
        return GetTarif().GetRastgeleTarif(api);
    }
    public Call<List<BenzerTarifler>> GetbenzerTarif(String api,String TarifID){
Call<List<BenzerTarifler>> call=GetTarifBENZER().GetBenzerTarif(api,TarifID);
        //apiutilsa gidiyor
        //oradan getuserinter clasını çağırıyor oradan da interface den bilgiler clasını çağırıyor,
        //ondan sonra getirbilgiler sınıfını bilgilerin görüneceği yerde çağırıyoruz
        return call;
    }
}
