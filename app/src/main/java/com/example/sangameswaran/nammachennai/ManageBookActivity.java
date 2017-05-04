package com.example.sangameswaran.nammachennai;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Sangameswaran on 25-03-2017.
 */

public class ManageBookActivity extends AppCompatActivity implements View.OnClickListener {

    RadioGroup rdgp;
    EditText e1, e2;
    Button b1;
    String ctrl = "sell";



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manage_book_layout);
        rdgp = (RadioGroup) findViewById(R.id.handleradiogroup);
        e1 = (EditText) findViewById(R.id.gets1);
        e2 = (EditText) findViewById(R.id.gets2);
        b1 = (Button) findViewById(R.id.alterbtn);
        b1.setOnClickListener(this);

        rdgp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rent) {
                    ctrl = "sell";
                } else if (checkedId == R.id.retreive) {
                    ctrl = "retreive";
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.alterbtn) {
            //handle alter button clicks

            String s1, s2;
            s1 = e1.getText().toString();
            s2 = e2.getText().toString();
            if (s1.equals("") || s2.equals("")) {
                Toast.makeText(getApplicationContext(), "Enter the details to alter", Toast.LENGTH_LONG).show();

            } else {
                //get data from shared preference
                SharedPreferences sharedPreferences = getSharedPreferences("MYBOOKS"+s1+s2, MODE_PRIVATE);
                final int si = sharedPreferences.getInt(s1 + s2, -2);
                Toast.makeText(getApplicationContext(), "Altering " + si + "book on database", Toast.LENGTH_LONG).show();

                //sell button pressed.. reduce count

                DatabaseReference myref = FirebaseDatabase.getInstance().getReference("BOOKS/" + si);
                myref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        BookModelClass modelClass = new BookModelClass();
                        modelClass = dataSnapshot.getValue(BookModelClass.class);
                        Toast.makeText(getApplicationContext(),"Got class",Toast.LENGTH_SHORT).show();
                        //String b = modelClass.getAvailablity();
                        if (ctrl.equals("sell"))
                        {
                            modelClass.setAvailablity("NA");
                            DatabaseReference reference=FirebaseDatabase.getInstance().getReference("BOOKS/"+si);
                            reference.setValue(modelClass);Toast.makeText(getApplicationContext(),"write success",Toast.LENGTH_SHORT).show();

                        }
                        else if(ctrl.equals("retreive"))
                        {
                            modelClass.setAvailablity("AVAILABLE");
                            DatabaseReference reference=FirebaseDatabase.getInstance().getReference("BOOKS/"+si);
                            reference.setValue(modelClass);
                            Toast.makeText(getApplicationContext(),"write success",Toast.LENGTH_SHORT).show();
                        }



                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }


        }
    }



    }
