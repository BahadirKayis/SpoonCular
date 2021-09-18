package com.layercontent.spoonacularcallculatortwo;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.layercontent.spoonacularcallculatortwo.search.Tarifbilgi.ExtendedIngredient;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Textviewadd extends androidx.appcompat.widget.AppCompatTextView{
    List<ExtendedIngredient>liste;

    public Textviewadd(@NonNull @NotNull Context context, List<ExtendedIngredient> liste) {
        super(context);
        this.liste = liste;
    }


    }
