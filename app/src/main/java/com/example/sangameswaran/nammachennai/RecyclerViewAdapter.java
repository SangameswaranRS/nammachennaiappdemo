package com.example.sangameswaran.nammachennai;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sangameswaran on 25-03-2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {
    ArrayList<EventModelClass> arr=new ArrayList<>();
    RecyclerViewAdapter(ArrayList<EventModelClass> modelClasses)
    {
        this.arr=modelClasses;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_layout,parent,false);
        RecyclerViewHolder holder=new RecyclerViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        EventModelClass modelClass=arr.get(position);
        holder.v1.setText("EVENT NAME"+modelClass.getEventname());
        holder.v2.setText("VENUE:"+modelClass.getVenue());
        holder.v3.setText("TIME:"+modelClass.getTime());
        holder.v4.setText("CATEGORY"+modelClass.getCategory());
        holder.v5.setText("ENTRY:"+modelClass.getEntry());
        holder.v6.setText("EMAIL CONTACT:"+modelClass.getContactmail());
        holder.v7.setText("PHONE CONTACT:"+modelClass.getContactphone());



    }

    @Override
    public int getItemCount() {
        return arr.size();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder
    {
        TextView v1,v2,v3,v4,v5,v6,v7,v8;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            v1=(TextView) itemView.findViewById(R.id.tv1);
            v2=(TextView) itemView.findViewById(R.id.tv2);
            v3=(TextView) itemView.findViewById(R.id.tv3);
            v4=(TextView) itemView.findViewById(R.id.tv4);
            v5=(TextView) itemView.findViewById(R.id.tv5);
            v6=(TextView) itemView.findViewById(R.id.tv6);
            v7=(TextView) itemView.findViewById(R.id.tv7);
         //   v8=(TextView) itemView.findViewById(R.id.tv8);





        }
    }
}
