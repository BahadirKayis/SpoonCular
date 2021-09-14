package com.layercontent.spoonacularcallculatortwo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.layercontent.spoonacularcallculatortwo.Model.RastgeleTarifAdapter;
import com.layercontent.spoonacularcallculatortwo.Retrofit.ManegarAll;
import com.layercontent.spoonacularcallculatortwo.search.Otomatiktanimlama;
import com.layercontent.spoonacularcallculatortwo.search.Recipe;
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
//breakfast
    RecyclerView Recylermain, Recylersalad, Recylerdessert,Recylerbeverage,Recylerappetizer,Recylerbreakfast,Recylerbreakfast2;
    RastgeleTarifAdapter rastgeleTarifAdapter;
    private final String  apiKey = "2f7c6f4d8ea7431785f543a865bdf46c";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Recylermain = findViewById(R.id.Recylermain);
        Recylerdessert = findViewById(R.id.Recylerdessert);
        Recylersalad = findViewById(R.id.Recylersalad);
        Recylerbeverage = findViewById(R.id.Recylerbeverage);
        Recylerappetizer = findViewById(R.id.Recylerappetizer);
        Recylerbreakfast = findViewById(R.id.Recylerbreakfast);
        Recylerbreakfast2 = findViewById(R.id.Recylerbreakfast2);

        Recylermain.setHasFixedSize(true);
        Recylermain.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        Recylerdessert.setHasFixedSize(true);
        Recylerdessert.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        Recylersalad.setHasFixedSize(true);
        Recylersalad.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        Recylerbeverage.setHasFixedSize(true);
        Recylerbeverage.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        Recylerappetizer.setHasFixedSize(true);
        Recylerappetizer.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        Recylerbreakfast.setHasFixedSize(true);
        Recylerbreakfast.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        Recylerbreakfast2.setHasFixedSize(true);
        Recylerbreakfast2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        GetRandomRecipesoup();
        GetRandomRecipedessert();
        GetRandomRecipesalad();
        GetRandomRecipebeverage();
        GetRandomRecipeappetizer();
        GetRandomRecipebreakfast();
        GetRandomRecipebreakfast2();
    }

    public void GetRandomRecipesoup() {
        //response.body().getRecipes().get(0).getTitle() böyle direkt yemeğin adını alıyoruz
        //getanalyzedInstructions ile de malzemelerini alıyoruz
        //getinstructions ile de talimatları alıyoruz
        //getimage ile de resmini
        //getreadyminutes dakikasını
        Call<RastgeleTarif> tarifCall = ManegarAll.getInstance().getirRandomTarif(apiKey, String.valueOf(10), "soup");
        tarifCall.enqueue(new Callback<RastgeleTarif>() {
            @Override
            public void onResponse(Call<RastgeleTarif> call, Response<RastgeleTarif> response) {
                if (response.isSuccessful()) {
                    //RastgeleTarifin içinde tek birşey olduğu için recipi gönderiyorum adapterden de List<Recipe> olarak alıyorum
                    //yoksa hata alıyorum,list.addAll( response.body().getRecipes()); olarak yapıyorum yoksa hata çıkıyor ve çalışmıyor
                    List list = new ArrayList();
                    list.addAll(response.body().getRecipes());
                    rastgeleTarifAdapter = new RastgeleTarifAdapter(list, MainActivity.this);
                    Recylermain.setAdapter(rastgeleTarifAdapter);
                    Log.e("random", response.body().getRecipes().get(0).getTitle());
                    Log.e("random", response.body().getRecipes().get(1).getTitle());
                    Log.e("random", response.body().getRecipes().get(2).getTitle());
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

    public void GetRandomRecipedessert() {
        //response.body().getRecipes().get(0).getTitle() böyle direkt yemeğin adını alıyoruz
        //getanalyzedInstructions ile de malzemelerini alıyoruz
        //getinstructions ile de talimatları alıyoruz
        //getimage ile de resmini
        //getreadyminutes dakikasını
        Call<RastgeleTarif> tarifCall = ManegarAll.getInstance().getirRandomTarif(apiKey, String.valueOf(10), "dessert");
        tarifCall.enqueue(new Callback<RastgeleTarif>() {
            @Override
            public void onResponse(Call<RastgeleTarif> call, Response<RastgeleTarif> response) {
                if (response.isSuccessful()) {
                    //RastgeleTarifin içinde tek birşey olduğu için recipi gönderiyorum adapterden de List<Recipe> olarak alıyorum
                    //yoksa hata alıyorum,list.addAll( response.body().getRecipes()); olarak yapıyorum yoksa hata çıkıyor ve çalışmıyor
                    List list = new ArrayList();
                    list.addAll(response.body().getRecipes());
                    rastgeleTarifAdapter = new RastgeleTarifAdapter(list, MainActivity.this);
                    Recylerdessert.setAdapter(rastgeleTarifAdapter);
                    Log.e("random", response.body().getRecipes().get(0).getTitle());
                    Log.e("random", response.body().getRecipes().get(1).getTitle());
                    Log.e("random", response.body().getRecipes().get(2).getTitle());
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

    public void GetRandomRecipesalad() {
        //response.body().getRecipes().get(0).getTitle() böyle direkt yemeğin adını alıyoruz
        //getanalyzedInstructions ile de malzemelerini alıyoruz
        //getinstructions ile de talimatları alıyoruz
        //getimage ile de resmini
        //getreadyminutes dakikasını
        Call<RastgeleTarif> tarifCall = ManegarAll.getInstance().getirRandomTarif(apiKey, String.valueOf(10), "salad");
        tarifCall.enqueue(new Callback<RastgeleTarif>() {
            @Override
            public void onResponse(Call<RastgeleTarif> call, Response<RastgeleTarif> response) {
                if (response.isSuccessful()) {
                    //RastgeleTarifin içinde tek birşey olduğu için recipi gönderiyorum adapterden de List<Recipe> olarak alıyorum
                    //yoksa hata alıyorum,list.addAll( response.body().getRecipes()); olarak yapıyorum yoksa hata çıkıyor ve çalışmıyor
                    List list = new ArrayList();
                    list.addAll(response.body().getRecipes());
                    rastgeleTarifAdapter = new RastgeleTarifAdapter(list, MainActivity.this);
                    Recylersalad.setAdapter(rastgeleTarifAdapter);
                    Log.e("random", response.body().getRecipes().get(0).getTitle());
                    Log.e("random", response.body().getRecipes().get(1).getTitle());
                    Log.e("random", response.body().getRecipes().get(2).getTitle());
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
    public void GetRandomRecipebeverage() {
        //response.body().getRecipes().get(0).getTitle() böyle direkt yemeğin adını alıyoruz
        //getanalyzedInstructions ile de malzemelerini alıyoruz
        //getinstructions ile de talimatları alıyoruz
        //getimage ile de resmini
        //getreadyminutes dakikasını
        Call<RastgeleTarif> tarifCall = ManegarAll.getInstance().getirRandomTarif(apiKey, String.valueOf(10), "beverage");
        tarifCall.enqueue(new Callback<RastgeleTarif>() {
            @Override
            public void onResponse(Call<RastgeleTarif> call, Response<RastgeleTarif> response) {
                if (response.isSuccessful()) {
                    //RastgeleTarifin içinde tek birşey olduğu için recipi gönderiyorum adapterden de List<Recipe> olarak alıyorum
                    //yoksa hata alıyorum,list.addAll( response.body().getRecipes()); olarak yapıyorum yoksa hata çıkıyor ve çalışmıyor
                    List list = new ArrayList();
                    list.addAll(response.body().getRecipes());
                    rastgeleTarifAdapter = new RastgeleTarifAdapter(list, MainActivity.this);
                    Recylerbeverage.setAdapter(rastgeleTarifAdapter);
                    Log.e("random", response.body().getRecipes().get(0).getTitle());
                    Log.e("random", response.body().getRecipes().get(1).getTitle());
                    Log.e("random", response.body().getRecipes().get(2).getTitle());
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

    public void GetRandomRecipeappetizer() {
        //response.body().getRecipes().get(0).getTitle() böyle direkt yemeğin adını alıyoruz
        //getanalyzedInstructions ile de malzemelerini alıyoruz
        //getinstructions ile de talimatları alıyoruz
        //getimage ile de resmini
        //getreadyminutes dakikasını
        Call<RastgeleTarif> tarifCall = ManegarAll.getInstance().getirRandomTarif(apiKey, String.valueOf(10), "appetizer");
        tarifCall.enqueue(new Callback<RastgeleTarif>() {
            @Override
            public void onResponse(Call<RastgeleTarif> call, Response<RastgeleTarif> response) {
                if (response.isSuccessful()) {
                    //RastgeleTarifin içinde tek birşey olduğu için recipi gönderiyorum adapterden de List<Recipe> olarak alıyorum
                    //yoksa hata alıyorum,list.addAll( response.body().getRecipes()); olarak yapıyorum yoksa hata çıkıyor ve çalışmıyor
                    List list = new ArrayList();
                    list.addAll(response.body().getRecipes());
                    rastgeleTarifAdapter = new RastgeleTarifAdapter(list, MainActivity.this);
                    Recylerappetizer.setAdapter(rastgeleTarifAdapter);
                    Log.e("random", response.body().getRecipes().get(0).getTitle());
                    Log.e("random", response.body().getRecipes().get(1).getTitle());
                    Log.e("random", response.body().getRecipes().get(2).getTitle());
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

    public void GetRandomRecipebreakfast() {
        //response.body().getRecipes().get(0).getTitle() böyle direkt yemeğin adını alıyoruz
        //getanalyzedInstructions ile de malzemelerini alıyoruz
        //getinstructions ile de talimatları alıyoruz
        //getimage ile de resmini
        //getreadyminutes dakikasını
        Call<RastgeleTarif> tarifCall = ManegarAll.getInstance().getirRandomTarif(apiKey, String.valueOf(10), "breakfast");
        tarifCall.enqueue(new Callback<RastgeleTarif>() {
            @Override
            public void onResponse(Call<RastgeleTarif> call, Response<RastgeleTarif> response) {
                if (response.isSuccessful()) {
                    //RastgeleTarifin içinde tek birşey olduğu için recipi gönderiyorum adapterden de List<Recipe> olarak alıyorum
                    //yoksa hata alıyorum,list.addAll( response.body().getRecipes()); olarak yapıyorum yoksa hata çıkıyor ve çalışmıyor
                    List list = new ArrayList();
                    list.addAll(response.body().getRecipes());
                    rastgeleTarifAdapter = new RastgeleTarifAdapter(list, MainActivity.this);
                    Recylerbreakfast.setAdapter(rastgeleTarifAdapter);
                    Log.e("random", response.body().getRecipes().get(0).getTitle());
                    Log.e("random", response.body().getRecipes().get(1).getTitle());
                    Log.e("random", response.body().getRecipes().get(2).getTitle());
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
    public void GetRandomRecipebreakfast2() {
        //response.body().getRecipes().get(0).getTitle() böyle direkt yemeğin adını alıyoruz
        //getanalyzedInstructions ile de malzemelerini alıyoruz
        //getinstructions ile de talimatları alıyoruz
        //getimage ile de resmini
        //getreadyminutes dakikasını
        Call<RastgeleTarif> tarifCall = ManegarAll.getInstance().getirRandomTarif(apiKey, String.valueOf(10), "breakfast");
        tarifCall.enqueue(new Callback<RastgeleTarif>() {
            @Override
            public void onResponse(Call<RastgeleTarif> call, Response<RastgeleTarif> response) {
                if (response.isSuccessful()) {
                    //RastgeleTarifin içinde tek birşey olduğu için recipi gönderiyorum adapterden de List<Recipe> olarak alıyorum
                    //yoksa hata alıyorum,list.addAll( response.body().getRecipes()); olarak yapıyorum yoksa hata çıkıyor ve çalışmıyor
                    List list = new ArrayList();
                    list.addAll(response.body().getRecipes());
                    rastgeleTarifAdapter = new RastgeleTarifAdapter(list, MainActivity.this);
                    Recylerbreakfast2.setAdapter(rastgeleTarifAdapter);
                    Log.e("random", response.body().getRecipes().get(0).getTitle());
                    Log.e("random", response.body().getRecipes().get(1).getTitle());
                    Log.e("random", response.body().getRecipes().get(2).getTitle());
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

    public void GetoutoSearch(String harf) {
        Call<List<Otomatiktanimlama>> call = ManegarAll.getInstance().GetoutoSearch(apiKey, harf);
        call.enqueue(new Callback<List<Otomatiktanimlama>>() {
            @Override
            public void onResponse(Call<List<Otomatiktanimlama>> call, Response<List<Otomatiktanimlama>> response) {
                if (response.isSuccessful()) {
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