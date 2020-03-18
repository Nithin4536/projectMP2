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

public class RecycleAdapter4 extends RecyclerView.Adapter<RecycleAdapter4.ViewHolder>
{

private ArrayList<drink_> arrydri;
private Context context;

public RecycleAdapter4(ArrayList<drink_> arrydri, Context context){

this.arrydri=arrydri;
this.context=context;
}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleitem4,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    Picasso.get().load(arrydri.get(position).getStrDrinkThumb()).into(holder.dkimg);
        holder.dkname1.setText(arrydri.get(position).getStrDrink());
        holder.dkname2.setText(arrydri.get(position).getStrMeasure1());
        holder.dkname3.setText(arrydri.get(position).getStrMeasure2());
        holder.dkname4.setText(arrydri.get(position).getStrMeasure3());
        holder.dkname5.setText(arrydri.get(position).getStrMeasure4());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

    ImageView dkimg;
    TextView dkname1,dkname2,dkname3,dkname4,dkname5;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dkimg = itemView.findViewById(R.id.img_dk);
            dkname2 = itemView.findViewById(R.id.txt_dk2);
            dkname1=itemView.findViewById(R.id.txt_dk1);
            dkname3=itemView.findViewById(R.id.txt_dk3);
            dkname4=itemView.findViewById(R.id.txt_dk4);
            dkname5=itemView.findViewById(R.id.txt_dk5);

            itemView.setTag(this);


        }
    }






 }
