package com.layercontent.spoonacularcallculatortwo.Model;

import android.content.Context;
import android.content.Intent;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.layercontent.spoonacularcallculatortwo.Detalistactivity;
import com.layercontent.spoonacularcallculatortwo.R;
import com.layercontent.spoonacularcallculatortwo.search.Tarifbilgi.TarifBilgi;
import com.layercontent.spoonacularcallculatortwo.search.benzertarifler.BenzerTarifler;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class BenzerTarifAdapter extends RecyclerView.Adapter<BenzerTarifAdapter.benzertarif> {
    List<BenzerTarifler>benzerTarifAdapterList;
    Context context;
List<TarifBilgi>tarifBilgiList;



    public BenzerTarifAdapter(List<BenzerTarifler> benzerTarifAdapterList, Context context, List <TarifBilgi> tarifBilgiList) {
        this.benzerTarifAdapterList = benzerTarifAdapterList;
        this.context = context;
        this.tarifBilgiList = tarifBilgiList;
    }

    @NonNull
    @NotNull
    @Override
    public benzertarif onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.benzertarifler,parent,false);
        return new benzertarif(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull BenzerTarifAdapter.benzertarif holder, int position) {
        Picasso.get().load(tarifBilgiList.get(position).getImage()).into(holder.benzerresim);
        holder.benzerTitle.setText(benzerTarifAdapterList.get(position).getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context, Detalistactivity.class);
                i.putExtra("randomtarifid",benzerTarifAdapterList.get(position).getId().toString());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return benzerTarifAdapterList.size();
    }

    public class benzertarif extends RecyclerView.ViewHolder {
        ImageView benzerresim;
        TextView benzerTitle;
        LinearLayout linearLayout;
        public benzertarif(@NonNull @NotNull View itemView) {
            super(itemView);
            linearLayout=itemView.findViewById(R.id.linearLayoutbenzer);
            benzerresim = itemView.findViewById(R.id.benzerResim);
            benzerTitle = itemView.findViewById(R.id.benzerTitle);

        }
    }
}
