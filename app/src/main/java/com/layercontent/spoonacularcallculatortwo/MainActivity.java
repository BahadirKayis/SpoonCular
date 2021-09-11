package com.layercontent.spoonacularcallculatortwo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.layercontent.spoonacularcallculatortwo.Model.RastgeleTarifAdapter;
import com.layercontent.spoonacularcallculatortwo.Retrofit.ManegarAll;
import com.layercontent.spoonacularcallculatortwo.search.Otomatiktanimlama;
import com.layercontent.spoonacularcallculatortwo.search.Search;
import com.layercontent.spoonacularcallculatortwo.search.Tarifbilgi.TarifBilgi;
import com.layercontent.spoonacularcallculatortwo.search.benzertarifler.BenzerTarifler;
import com.layercontent.spoonacularcallculatortwo.search.rastgeletarif.RastgeleTarif;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView idrandom;
    Button button;
    private int TID;
    private Handler myHandler;
private List<RastgeleTarif>rastgeleTarifList=new ArrayList<>();
    RecyclerView recyclerView;
    RastgeleTarifAdapter rastgeleTarifAdapter;
    private String apiKey = "2f7c6f4d8ea7431785f543a865bdf46c";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
recyclerView=findViewById(R.id.randomRecyler);
recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        GetRandomRecipe();

    }

    public void GetRandomRecipe() {
        //response.body().getRecipes().get(0).getTitle() böyle direkt yemeğin adını alıyoruz
        //getanalyzedInstructions ile de malzemelerini alıyoruz
        //getinstructions ile de talimatları alıyoruz
        //getimage ile de resmini
        //getreadyminutes dakikasını
        Call<RastgeleTarif> tarifCall = ManegarAll.getInstance().getirRandomTarif(apiKey,String.valueOf(3));
        tarifCall.enqueue(new Callback<RastgeleTarif>() {
            @Override
            public void onResponse(Call<RastgeleTarif> call, Response<RastgeleTarif> response) {
                if (response.isSuccessful()) {
                    List list=new ArrayList();
                    list.add( response.body());
                   rastgeleTarifAdapter=new RastgeleTarifAdapter(list,MainActivity.this);
                   recyclerView.setAdapter(rastgeleTarifAdapter);
                //  Log.e("random", response.body().getRecipes().get(0).getSourceName());
                    //Log.e("random", response.body().getRecipes().get(0).getTitle());
                   // TID = response.body().getRecipes().get(0).getExtendedIngredients().get(0).getId();
//                    Log.e("xxx", BaseUrl.BASE_URLBENZER);
                    new android.os.Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                        }
                    }, 5000);

                 //   GetBenzerRecipe(String.valueOf(TID));
                    //GetTarifInfo(String.valueOf(TID));
                  //  GetSearchComplex("pasta");
                   // GetoutoSearch("ta");


                } else {
                    Log.e("randomhata", "girmedi");
                }

            }

            @Override
            public void onFailure(Call<RastgeleTarif> call, Throwable t) {
                Log.e("randomhata", t.getMessage());

            }
        });
    }

    public void GetBenzerRecipe(String TarifID) {
        Call<List<BenzerTarifler>> call = ManegarAll.getInstance().GetbenzerTarif(TarifID, apiKey);
        call.enqueue(new Callback<List<BenzerTarifler>>() {
            @Override
            public void onResponse(Call<List<BenzerTarifler>> call, Response<List<BenzerTarifler>> response) {
                if (response.isSuccessful()) {
                    Log.e("benzer", response.body().get(0).getTitle());

                }

            }

            @Override
            public void onFailure(Call<List<BenzerTarifler>> call, Throwable t) {
                Log.e("benzerhata", t.getMessage());
            }
        });
    }

    public void GetTarifInfo(String TarifID) {
        Call<TarifBilgi> call = ManegarAll.getInstance().GetTarifBilgisi(TarifID, apiKey);
        call.enqueue(new Callback<TarifBilgi>() {
            @Override
            public void onResponse(Call<TarifBilgi> call, Response<TarifBilgi> response) {
                if (response.isSuccessful()) {
                    Log.e("tarif", response.body().getExtendedIngredients().get(0).getId().toString());
                }
            }

            @Override
            public void onFailure(Call<TarifBilgi> call, Throwable t) {
                Log.e("tarifhata", t.getMessage());
            }
        });

    }

    public void GetSearchComplex(String arananNesne) {
        Call<Search> call = ManegarAll.getInstance().GetComplexSearch(arananNesne, apiKey);
        call.enqueue(new Callback<Search>() {
            @Override
            public void onResponse(Call<Search> call, Response<Search> response) {
                if (response.isSuccessful()) {
                    Log.e("search", response.body().getResults().get(0).getTitle());
                }
            }

            @Override
            public void onFailure(Call<Search> call, Throwable t) {
                Log.e("searchhata", t.getMessage());
            }
        });
    }

    public void GetoutoSearch(String harf){
        Call<List<Otomatiktanimlama>>call=ManegarAll.getInstance().GetoutoSearch(apiKey,harf);
        call.enqueue(new Callback<List<Otomatiktanimlama>>() {
            @Override
            public void onResponse(Call<List<Otomatiktanimlama>> call, Response<List<Otomatiktanimlama>> response) {
           if (response.isSuccessful()){
               Log.e("GetoutoSearch", response.body().get(0).getTitle());
           }

            }

            @Override
            public void onFailure(Call<List<Otomatiktanimlama>> call, Throwable t) {
                Log.e("GetoutoSearchHATA", t.getMessage());
            }
        });
    }
}