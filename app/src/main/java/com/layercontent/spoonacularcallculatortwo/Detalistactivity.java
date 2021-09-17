package com.layercontent.spoonacularcallculatortwo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.layercontent.spoonacularcallculatortwo.Retrofit.ManegarAll;
import com.layercontent.spoonacularcallculatortwo.search.Tarifbilgi.TarifBilgi;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Detalistactivity extends AppCompatActivity {
CheckBox checkvegetarian,checkvegan,checkgluten,checkdairy;

    ImageView imageViewanaresim;
    TextView tarifinadi,textdishtypes,textscore,textlikes,texthealtscore,textView12;
    boolean isboolen;
    LinearLayout linearmaddeler;
    private final String  apiKey = "2f7c6f4d8ea7431785f543a865bdf46c";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalistactivity);
checkvegetarian=findViewById(R.id.vegetarian);
        checkdairy=findViewById(R.id.dairyfree);
        checkgluten=findViewById(R.id.glutenfree);
        checkvegan=findViewById(R.id.vegan);
        textdishtypes=findViewById(R.id.dishtypes);

        tarifinadi=findViewById(R.id.textView11);
        textscore=findViewById(R.id.Score);
        textlikes=findViewById(R.id.Likes);
        texthealtscore=findViewById(R.id.healtscore);
        imageViewanaresim=findViewById(R.id.imageAnaresim);
        textView12=findViewById(R.id.textView12);
       GetTarifInfo((getIntent().getStringExtra("randomtarifid")));

       linearmaddeler=findViewById(R.id.linearmaddeler);


    }
    public void GetTarifInfo(String TarifID) {
        Call<TarifBilgi> call = ManegarAll.getInstance().GetTarifBilgisi(TarifID, apiKey);
        call.enqueue(new Callback<TarifBilgi>() {
            @Override
            public void onResponse(Call<TarifBilgi> call, Response<TarifBilgi> response) {
                if (response.isSuccessful()) {
                 Picasso.get().load(response.body().getImage()).into(imageViewanaresim);
                    tarifinadi.setText(response.body().getTitle());
                    isboolen=response.body().getVegetarian();
                  checkvegetarian.setChecked(response.body().getVegetarian());
                    checkdairy.setChecked(response.body().getDairyFree());
                    checkgluten.setChecked(response.body().getGlutenFree());
                    checkvegan.setChecked(response.body().getVegan());

                    textdishtypes.setText(response.body().getDishTypes().toString());
                    textscore.setText(response.body().getSpoonacularScore().toString());
                    textlikes.setText(response.body().getAggregateLikes().toString());
                    texthealtscore.setText(response.body().getHealthScore().toString());
                    textView12.setText(response.body().getSummary());

                }
            }

            @Override
            public void onFailure(Call<TarifBilgi> call, Throwable t) {
                Log.e("tarifhata", t.getMessage());
            }
        });

    }
}