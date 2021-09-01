package com.layercontent.spoonacularcallculatortwo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.layercontent.spoonacularcallculatortwo.Retrofit.ManegarAll;
import com.layercontent.spoonacularcallculatortwo.search.Search;
import com.layercontent.spoonacularcallculatortwo.search.Tarifbilgi.TarifBilgi;
import com.layercontent.spoonacularcallculatortwo.search.benzertarifler.BenzerTarifler;
import com.layercontent.spoonacularcallculatortwo.search.rastgeletarif.RastgeleTarif;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
TextView idrandom;
private  String  apiKey="2f7c6f4d8ea7431785f543a865bdf46c";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        idrandom=findViewById(R.id.idrandom);
        GetRandomRecipe();

    }
    public void GetRandomRecipe(){
        Call<RastgeleTarif>tarifCall= ManegarAll.getInstance().getirRandomTarif(apiKey);
        tarifCall.enqueue(new Callback<RastgeleTarif>() {
            @Override
            public void onResponse(Call<RastgeleTarif> call, Response<RastgeleTarif> response) {
                if (response.isSuccessful()){

                    Log.e("xxx", response.body().getRecipes().get(0).getSourceName());

                }
                else
                {
                    Log.e("xxx", "girmedi" );
                }

            }

            @Override
            public void onFailure(Call<RastgeleTarif> call, Throwable t) {
                Log.e("xxx", t.getMessage() );

            }
        });
    }
}