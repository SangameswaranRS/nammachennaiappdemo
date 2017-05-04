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

public class TechnicalRecyclerViewActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager manager;
    ArrayList<EventModelClass> arrayList = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.technical_recycler_view);
        recyclerView = (RecyclerView) findViewById(R.id.technicalrecyclerview);
        manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        SharedPreferences sp = getSharedPreferences("TECHNICAL", MODE_PRIVATE);
        int b = sp.getInt("COUNT", -1);
        if (b < 0) {
            Toast.makeText(getApplicationContext(), "Connectivity Error", Toast.LENGTH_SHORT).show();
        } else {
            for (int i = b; i > 0; i--) {
                DatabaseReference myref = FirebaseDatabase.getInstance().getReference("EVENTS/TECHNICAL/NAME/" + i);
                myref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChildren()) {

                            EventModelClass modelClass = new EventModelClass();

                            modelClass = dataSnapshot.getValue(EventModelClass.class);
                            arrayList.add(modelClass);

                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
            adapter = new RecyclerViewAdapter(arrayList);
            recyclerView.setAdapter(adapter);
            recyclerView.setHasFixedSize(true);


        }
    }

    }

