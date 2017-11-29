package com.tsafaapp.mRecycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.tsafaapp.R;

/**
 * Created by Teo on 11/29/2017.
 */

public class MyViewHolder extends RecyclerView.ViewHolder{

    //OUR VIEWS

    TextView nametxt;

    public MyViewHolder(View itemView) {
        super(itemView);

        nametxt = (TextView)itemView.findViewById(R.id.nameTxt);
    }



}
