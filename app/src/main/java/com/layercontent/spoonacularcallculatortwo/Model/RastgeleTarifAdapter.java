package com.layercontent.spoonacularcallculatortwo.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.layercontent.spoonacularcallculatortwo.R;
import com.layercontent.spoonacularcallculatortwo.search.rastgeletarif.RastgeleTarif;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RastgeleTarifAdapter extends RecyclerView.Adapter<RastgeleTarifAdapter.tariflerigetir>{

    List<RastgeleTarif>rastgeleTarifList;
    Context context;

    public RastgeleTarifAdapter(List<RastgeleTarif> rastgeleTarifList, Context context) {
        this.rastgeleTarifList = rastgeleTarifList;
        this.context = context;
    }

    @NonNull
    @Override
    public tariflerigetir onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.support_simple_spinner_dropdown_item,parent,false);
        return new tariflerigetir(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RastgeleTarifAdapter.tariflerigetir holder, int position) {
        holder.randomTitle.setText(rastgeleTarifList.get(position).getRecipes().get(position).getTitle());
        Picasso.get().load(rastgeleTarifList.get(position).getRecipes().get(position).getImage()).into(holder.randomresim);
    }

    @Override
    public int getItemCount() {
        return rastgeleTarifList.size();
    }

    public class tariflerigetir extends RecyclerView.ViewHolder {
        ImageView randomresim;
        TextView randomTitle;
        public tariflerigetir(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
            randomresim=itemView.findViewById(R.id.randomResim);
            randomTitle=itemView.findViewById(R.id.randomTitle);

        }
    }
}
