package com.layercontent.spoonacularcallculatortwo.Model;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.layercontent.spoonacularcallculatortwo.Detalistactivity;
import com.layercontent.spoonacularcallculatortwo.MainActivity;
import com.layercontent.spoonacularcallculatortwo.R;
import com.layercontent.spoonacularcallculatortwo.search.rastgeletarif.RastgeleTarif;
import com.layercontent.spoonacularcallculatortwo.search.rastgeletarif.Recipe;
import com.squareup.picasso.Picasso;

import java.util.Collection;
import java.util.List;

public class RastgeleTarifAdapter extends RecyclerView.Adapter<RastgeleTarifAdapter.tariflerigetir> {

    List<Recipe> rastgeleTarifList;
    Context context;

    public RastgeleTarifAdapter(List<Recipe> rastgeleTarifList, Context context) {
        this.rastgeleTarifList = rastgeleTarifList;
        this.context = context;
    }

    @NonNull
    @Override
    public tariflerigetir onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.randomtarifler, parent, false);
        return new tariflerigetir(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RastgeleTarifAdapter.tariflerigetir holder, int position) {
        holder.randomTitle.setText(rastgeleTarifList.get(position).getTitle());
        Picasso.get().load(rastgeleTarifList.get(position).getImage()).into(holder.randomresim);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context,Detalistactivity.class);
                i.putExtra(rastgeleTarifList.get(position).getId().toString(),"randomtarifid");
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {

        return rastgeleTarifList.size();
    }

    public class tariflerigetir extends RecyclerView.ViewHolder {
        ImageView randomresim;
        TextView randomTitle;
        LinearLayout linearLayout;

        public tariflerigetir(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
            linearLayout=itemView.findViewById(R.id.linearLayout);
            randomresim = itemView.findViewById(R.id.randomResim);
            randomTitle = itemView.findViewById(R.id.randomTitle);

        }
    }
}
