package com.example.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecycleAdapter2 extends RecyclerView.Adapter<RecycleAdapter2.ViewHolder> {

    private ArrayList<drink_> arrydri;
    private Context context;

    public RecycleAdapter2(ArrayList<drink_> arrydri, Context context){
        this.arrydri = arrydri;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleitem2,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleAdapter2.ViewHolder holder, int position) {
        Picasso.get().load(arrydri.get(position).getStrDrinkThumb()).into(holder.dkimg);
        holder.dkname.setText(arrydri.get(position).getStrCategory());
        holder.dkname1.setText(arrydri.get(position).getStrInstructions());
    }

    @Override
    public int getItemCount() {
        return arrydri.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView dkimg;
        TextView dkname,dkname1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dkimg = itemView.findViewById(R.id.img_dk);
            dkname = itemView.findViewById(R.id.txt_dk);
            dkname1=itemView.findViewById(R.id.txt_dk1);

            itemView.setTag(this);

        }
    }
}
