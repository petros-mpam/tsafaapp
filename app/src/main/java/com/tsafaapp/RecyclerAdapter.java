package com.tsafaapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Teo on 12/11/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    ArrayList<Items> arrayList = new ArrayList<>();
    RecyclerAdapter(ArrayList<Items> arrayList)
    {
        this.arrayList = arrayList;
    }






    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.c_flag.setImageResource(arrayList.get(position).getFlag_id());
        holder.c_name.setText(arrayList.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder
    {

        ImageView c_flag;
        TextView c_name;

        public MyViewHolder(View itemView) {
            super(itemView);
            c_flag = (ImageView) itemView.findViewById(R.id.flag);
            c_name = (TextView) itemView.findViewById(R.id.name);
        }
    }


    public void setFilter(ArrayList<Items> newList)
    {
        arrayList = new ArrayList<>();
        arrayList.addAll(newList);

        notifyDataSetChanged();

    }
}
