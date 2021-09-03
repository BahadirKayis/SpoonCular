package com.layercontent.spoonacularcallculatortwo.Retrofit;

import androidx.annotation.NonNull;

public class BaseUrl {
    public static final String BASE_URL="https://api.spoonacular.com/recipes/";
    public  static  int TarifID;

    public BaseUrl(int tarifid) {
        TarifID=tarifid;
    }

    public static final String BASE_URLBENZER="https://api.spoonacular.com/recipes/"+TarifID+"/";






//Bu base link ana link olmalı alt kolları interface içerisinde belirtilir
  //  public static final String BASE_URLSEHİR="https://run.mocky.io/v3/";
}
