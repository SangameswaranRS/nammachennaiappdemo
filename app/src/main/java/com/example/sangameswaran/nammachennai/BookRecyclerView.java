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

public class BookRecyclerView extends RecyclerView.Adapter<BookRecyclerView.BookRecyclerViewHolder> {

    ArrayList<BookModelClass> arrayList = new ArrayList<>();

    BookRecyclerView(ArrayList<BookModelClass> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public BookRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_class_layout, parent, false);
        BookRecyclerViewHolder holder = new BookRecyclerViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(BookRecyclerViewHolder holder, int position) {

        BookModelClass modelClass = arrayList.get(position);
        holder.v1.setText("BOOK NAME:" + modelClass.getBookname());
        holder.v2.setText("BOOK ISBN:" + modelClass.getBookisbn());
        holder.v3.setText("BOOK AUTHOR:" + modelClass.getAuthorname());
        holder.v4.setText("AVAILABLITY STATUS:" + modelClass.getAvailablity());
        holder.v5.setText("BOOK EDITION:" + modelClass.getBookedition());
        holder.v6.setText("BOOK PUBLISHERS" + modelClass.getPublishers());
        holder.v7.setText("OWNER USER ID:" + modelClass.getOwnername());
        holder.v8.setText("OWNER CONTACT NUMBER:" + modelClass.getOwnercontactnum());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class BookRecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView v1, v2, v3, v4, v5, v6, v7, v8;

        public BookRecyclerViewHolder(View itemView) {
            super(itemView);
            v1 = (TextView) itemView.findViewById(R.id.tv1);
            v2 = (TextView) itemView.findViewById(R.id.tv2);
            v3 = (TextView) itemView.findViewById(R.id.tv3);
            v4 = (TextView) itemView.findViewById(R.id.tv4);
            v5 = (TextView) itemView.findViewById(R.id.tv5);
            v6 = (TextView) itemView.findViewById(R.id.tv6);
            v7 = (TextView) itemView.findViewById(R.id.tv7);
            v8 = (TextView) itemView.findViewById(R.id.tv8);


        }
    }
}
