package com.layercontent.spoonacularcallculatortwo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.layercontent.spoonacularcallculatortwo.Model.BenzerTarifAdapter;
import com.layercontent.spoonacularcallculatortwo.Retrofit.ManegarAll;
import com.layercontent.spoonacularcallculatortwo.search.Tarifbilgi.TarifBilgi;
import com.layercontent.spoonacularcallculatortwo.search.benzertarifler.BenzerTarifler;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Detalistactivity extends AppCompatActivity {
    CheckBox checkvegetarian, checkvegan, checkgluten, checkdairy;

    ImageView imageViewanaresim;
    TextView tarifinadi, textdishtypes, textscore, textlikes, texthealtscore, textView12;
    boolean isboolen;
    LinearLayout linearmaddeler;
    TextView textView;
    private final String apiKey = "a30512c1612c4422a8ce81571ed5bbde";//api2 a30512c1612c4422a8ce81571ed5bbde //api1 2f7c6f4d8ea7431785f543a865bdf46c
    RecyclerView benzerRecy;

    List<Integer> benserresimler=new ArrayList<>();
    List<TarifBilgi> resimler2=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalistactivity);
        checkvegetarian = findViewById(R.id.vegetarian);
        checkdairy = findViewById(R.id.dairyfree);
        checkgluten = findViewById(R.id.glutenfree);
        checkvegan = findViewById(R.id.vegan);
        textdishtypes = findViewById(R.id.dishtypes);

        tarifinadi = findViewById(R.id.textView11);
        textscore = findViewById(R.id.Score);
        textlikes = findViewById(R.id.Likes);
        texthealtscore = findViewById(R.id.healtscore);
        imageViewanaresim = findViewById(R.id.imageAnaresim);
        textView12 = findViewById(R.id.textView12);
        GetTarifInfo((getIntent().getStringExtra("randomtarifid")));

        linearmaddeler = findViewById(R.id.linearmaddeler);
        benzerRecy=findViewById(R.id.recylerbenzer);

        textView = new TextView(this);
        GetBenzerRecipe((getIntent().getStringExtra("randomtarifid")));

        benzerRecy.setHasFixedSize(true);
        benzerRecy.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));


    }

    public void GetTarifInfo(String TarifID) {
        Call<TarifBilgi> call = ManegarAll.getInstance().GetTarifBilgisi(TarifID, apiKey);
        call.enqueue(new Callback<TarifBilgi>() {
            @Override
            public void onResponse(Call<TarifBilgi> call, Response<TarifBilgi> response) {
                if (response.isSuccessful()) {
                    Picasso.get().load(response.body().getImage()).into(imageViewanaresim);
                    tarifinadi.setText(response.body().getTitle());
                    isboolen = response.body().getVegetarian();
                    checkvegetarian.setChecked(response.body().getVegetarian());
                    checkdairy.setChecked(response.body().getDairyFree());
                    checkgluten.setChecked(response.body().getGlutenFree());
                    checkvegan.setChecked(response.body().getVegan());

                    textdishtypes.setText(response.body().getDishTypes().toString());
                    textscore.setText(response.body().getSpoonacularScore().toString());
                    textlikes.setText(response.body().getAggregateLikes().toString());
                    texthealtscore.setText(response.body().getHealthScore().toString());
                    textView12.setText(response.body().getSummary());

                  //  LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                 //Tariflerin malzemelrini yazdırma yeri text ekliyoruz
                    for (int i = 0; i < response.body().getExtendedIngredients().size();i++) {
                        textView = new TextView(Detalistactivity.this);
                        //textView.setId(response.body().getExtendedIngredients().get(i).getId());
                        textView.setTextColor(Color.parseColor("#FF000000"));

                          textView.setText(response.body().getExtendedIngredients().get(i).getOriginal());
                        linearmaddeler.addView(textView);
                       // linearmaddeler.removeView(textView);
                    }

                }
            }

            @Override
            public void onFailure(Call<TarifBilgi> call, Throwable t) {
                Log.e("tarifhata", t.getMessage());
            }
        });

    }
public void GetTarifInfobenzer(String TarifID){
            Call<TarifBilgi> call = ManegarAll.getInstance().GetTarifBilgisi(TarifID, apiKey);
            call.enqueue(new Callback<TarifBilgi>() {
                @Override
                public void onResponse(Call<TarifBilgi> call, Response<TarifBilgi> response) {
                    if (response.isSuccessful()) {
                        resimler2.add(response.body());

                    }


                }

                @Override
                public void onFailure(Call<TarifBilgi> call, Throwable t) {

                }
            });


}

    public void GetBenzerRecipe(String TarifID) {
        Call<List<BenzerTarifler>> call = ManegarAll.getInstance().GetbenzerTarif(TarifID, apiKey);
        call.enqueue(new Callback<List<BenzerTarifler>>() {
            @Override
            public void onResponse(Call<List<BenzerTarifler>> call, Response<List<BenzerTarifler>> response) {
                if (response.isSuccessful()) {

                    Log.e("benzer", response.body().get(0).getId().toString());

                    for (int i=0;i<response.body().size();i++){
                        benserresimler.add(response.body().get(i).getId());
                    }
                    for (int a=0;a<benserresimler.size();a++){
                        GetTarifInfobenzer(benserresimler.get(a).toString());


                    }

                       Log.e("xxx", String.valueOf(resimler2.size()));
                        BenzerTarifAdapter benzerTarifAdapter=new BenzerTarifAdapter(response.body(),Detalistactivity.this,resimler2);
                        benzerRecy.setAdapter(benzerTarifAdapter);




                }

            }

            @Override
            public void onFailure(Call<List<BenzerTarifler>> call, Throwable t) {
                Log.e("benzerhata", t.getMessage());
            }
        });
    }

}