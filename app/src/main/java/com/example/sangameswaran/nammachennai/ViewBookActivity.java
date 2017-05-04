package com.example.sangameswaran.nammachennai;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by Sangameswaran on 25-03-2017.
 */

public class ViewBookActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager manager;
    ArrayList<BookModelClass> arrayList=new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_book_activity_layout);


        recyclerView=(RecyclerView)findViewById(R.id.bookrecyclerview);

        manager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);


        //copy from firebase database and set the adapter

        DatabaseReference myref= FirebaseDatabase.getInstance().getReference("BOOKCOUNT");


        myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value=dataSnapshot.getValue(String.class);
                int a=Integer.parseInt(value);
                SharedPreferences sp=getSharedPreferences("myShare",MODE_PRIVATE);
                SharedPreferences.Editor editor=sp.edit();
                editor.putInt("bookCount",a);
                editor.commit();


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        SharedPreferences sp=getSharedPreferences("myShare",MODE_PRIVATE);
        int b=sp.getInt("bookCount",-1);
        if(b==-1)
        {
            Toast.makeText(getApplicationContext(),"Error in connectivity",Toast.LENGTH_LONG).show();
        }
        else
        {
            for(int i=b;i>0;i--)
            {
                DatabaseReference mdatabasereference;
                mdatabasereference=FirebaseDatabase.getInstance().getReference("BOOKS/"+i);
                mdatabasereference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        if (dataSnapshot.hasChildren()) {
                            BookModelClass modelClass = new BookModelClass();
                            modelClass = dataSnapshot.getValue(BookModelClass.class);
                            arrayList.add(modelClass);
                        }


                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        }
        adapter=new BookRecyclerView(arrayList);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);






    }


}
