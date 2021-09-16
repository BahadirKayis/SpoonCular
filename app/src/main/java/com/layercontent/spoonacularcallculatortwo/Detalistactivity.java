package com.layercontent.spoonacularcallculatortwo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.layercontent.spoonacularcallculatortwo.Retrofit.ManegarAll;
import com.layercontent.spoonacularcallculatortwo.search.Tarifbilgi.TarifBilgi;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Detalistactivity extends AppCompatActivity {


    ImageView imageViewanaresim;
    TextView tarifinadi;
    private final String  apiKey = "2f7c6f4d8ea7431785f543a865bdf46c";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalistactivity);

        tarifinadi=findViewById(R.id.textView11);
        imageViewanaresim=findViewById(R.id.imageAnaresim);
       GetTarifInfo((getIntent().getStringExtra("randomtarifid")));

    }
    public void GetTarifInfo(String TarifID) {
        Call<TarifBilgi> call = ManegarAll.getInstance().GetTarifBilgisi(TarifID, apiKey);
        call.enqueue(new Callback<TarifBilgi>() {
            @Override
            public void onResponse(Call<TarifBilgi> call, Response<TarifBilgi> response) {
                if (response.isSuccessful()) {
                    Log.e("tarif", response.body().getImage());
                    String resim=response.body().getImage();


                 Picasso.get().load(resim).into(imageViewanaresim);
                    tarifinadi.setText(response.body().getTitle().toString());
                }
            }

            @Override
            public void onFailure(Call<TarifBilgi> call, Throwable t) {
                Log.e("tarifhata", t.getMessage());
            }
        });

    }
}