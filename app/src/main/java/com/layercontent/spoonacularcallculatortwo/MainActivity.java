package com.layercontent.spoonacularcallculatortwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.layercontent.spoonacularcallculatortwo.Retrofit.BaseUrl;
import com.layercontent.spoonacularcallculatortwo.Retrofit.ManegarAll;
import com.layercontent.spoonacularcallculatortwo.search.Search;
import com.layercontent.spoonacularcallculatortwo.search.Tarifbilgi.TarifBilgi;
import com.layercontent.spoonacularcallculatortwo.search.benzertarifler.BenzerTarifler;
import com.layercontent.spoonacularcallculatortwo.search.rastgeletarif.RastgeleTarif;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
TextView idrandom;
Button button;
    private Handler myHandler;
private  String  apiKey="2f7c6f4d8ea7431785f543a865bdf46c";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        idrandom=findViewById(R.id.idrandom);
        GetRandomRecipe();
        button=findViewById(R.id.randomstart);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetBenzerRecipe();
                Log.e("xxx", BaseUrl.BASE_URLBENZER.toString());
            }
        });




    }

    public void GetRandomRecipe(){
        Call<RastgeleTarif>tarifCall= ManegarAll.getInstance().getirRandomTarif(apiKey);
        tarifCall.enqueue(new Callback<RastgeleTarif>() {
            @Override
            public void onResponse(Call<RastgeleTarif> call, Response<RastgeleTarif> response) {
                if (response.isSuccessful()){

                    Log.e("xxx", response.body().getRecipes().get(0).getSourceName());
                    Log.e("xxx", response.body().getRecipes().get(0).getExtendedIngredients().get(1).getId().toString());
                  BaseUrl.TarifID= Integer.valueOf(response.body().getRecipes().get(0).getExtendedIngredients().get(1).getId().toString());
                  BaseUrl baseUrl=new BaseUrl(Integer.valueOf(response.body().getRecipes().get(0).getExtendedIngredients().get(1).getId().toString()));
                    Log.e("xxx", BaseUrl.BASE_URLBENZER);
                    Log.e("xxx", String.valueOf(BaseUrl.TarifID));

                      /*new android.os.Handler().postDelayed(new Runnable() {
                          @Override
                          public void run() {
                              GetBenzerRecipe();
                          }
                      },5000);*/
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

    public void GetBenzerRecipe(){
      Call<BenzerTarifler>call=ManegarAll.getInstance().GetbenzerTarif(apiKey);
      call.enqueue(new Callback<BenzerTarifler>() {
          @Override
          public void onResponse(Call<BenzerTarifler> call, Response<BenzerTarifler> response) {
             if (response.isSuccessful())
             {
                 Log.e("xxxs", response.body().getId().toString());
             }

          }

          @Override
          public void onFailure(Call<BenzerTarifler> call, Throwable t) {
              Log.e("xxx", t.getMessage());

          }
      });



    }
}