package com.layercontent.spoonacularcallculatortwo.Retrofit;


import com.layercontent.spoonacularcallculatortwo.search.Otomatiktanimlama;
import com.layercontent.spoonacularcallculatortwo.search.Search;
import com.layercontent.spoonacularcallculatortwo.search.Tarifbilgi.TarifBilgi;
import com.layercontent.spoonacularcallculatortwo.search.benzertarifler.BenzerTarifler;
import com.layercontent.spoonacularcallculatortwo.search.rastgeletarif.RastgeleTarif;

import java.util.List;

import retrofit2.Call;

public class ManegarAll extends BaseManager {
    private static ManegarAll ourınstance = new ManegarAll();

    public static synchronized ManegarAll getInstance() {
        return ourınstance;
    }

    public Call<RastgeleTarif> getirRandomTarif(String api, String number,String tags) {
Call<RastgeleTarif> call =GetTarif().GetRastgeleTarif(api,number,tags);
        //apiutilsa gidiyor
        //oradan getuserinter clasını çağırıyor oradan da interface den bilgiler clasını çağırıyor,
        //ondan sonra getirbilgiler sınıfını bilgilerin görüneceği yerde çağırıyoruz
        return call;
    }

    public Call<List<BenzerTarifler>> GetbenzerTarif(String api, String TarifID) {
        Call<List<BenzerTarifler>> call = GetTarifBENZER().GetBenzerTarif(api, TarifID);
        //apiutilsa gidiyor
        //oradan getuserinter clasını çağırıyor oradan da interface den bilgiler clasını çağırıyor,
        //ondan sonra getirbilgiler sınıfını bilgilerin görüneceği yerde çağırıyoruz
        return call;
    }
    public Call<TarifBilgi>GetTarifBilgisi(String api, String TarifID) {
        Call<TarifBilgi> call = GetTarifBENZER().GetTarifBilgi(api, TarifID);
        //apiutilsa gidiyor
        //oradan getuserinter clasını çağırıyor oradan da interface den bilgiler clasını çağırıyor,
        //ondan sonra getirbilgiler sınıfını bilgilerin görüneceği yerde çağırıyoruz
        return call;
    }
    public Call<Search>GetComplexSearch(String api, String TarifNesne) {
        Call<Search> call = GetTarifBENZER().GetComplexSearch(api, TarifNesne);
        //apiutilsa gidiyor
        //oradan getuserinter clasını çağırıyor oradan da interface den bilgiler clasını çağırıyor,
        //ondan sonra getirbilgiler sınıfını bilgilerin görüneceği yerde çağırıyoruz
        return call;
    }
    public Call<List<Otomatiktanimlama>>GetoutoSearch(String api, String harf) {
        Call<List<Otomatiktanimlama>> call = GetTarifBENZER().GetoutoSearch(api, harf);
        //apiutilsa gidiyor
        //oradan getuserinter clasını çağırıyor oradan da interface den bilgiler clasını çağırıyor,
        //ondan sonra getirbilgiler sınıfını bilgilerin görüneceği yerde çağırıyoruz
        return call;
    }
}
