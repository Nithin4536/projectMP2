package com.example.project;

import android.content.Context;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerAdapter5 extends RecyclerView.Adapter<RecyclerAdapter5.ViewHolder> {

    private ArrayList<drink_> arrydri;
    private Context context;

public RecyclerAdapter5(ArrayList<drink_> arrydri,Context context) {
    this.arrydri = arrydri;
    this.context = context;
}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleitem5,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Picasso.get().load(arrydri.get(position).getStrDrinkThumb()).into(holder.dkimg);
        holder.dkname.setText(arrydri.get(position).getStrDrink());
        holder.dkname1.setText(arrydri.get(position).getIdDrink());
        holder.dkname2.setText(arrydri.get(position).getStrCategory());

    }

    @Override
    public int getItemCount() {
        return arrydri.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{

        ImageView dkimg;
        TextView dkname,dkname1,dkname2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dkimg = itemView.findViewById(R.id.img_dk);
            dkname = itemView.findViewById(R.id.txt_dk2);
            dkname1=itemView.findViewById(R.id.txt_dk1);
            dkname2=itemView.findViewById(R.id.txt_dk4);


        }
    }
}