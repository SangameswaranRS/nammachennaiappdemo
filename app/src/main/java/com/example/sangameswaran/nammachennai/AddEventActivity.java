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
 * Created by Sangameswaran on 24-03-2017.
 */

public class AddEventActivity extends AppCompatActivity implements View.OnClickListener{
    EditText venue,eventname,time,entry,contactmail,contactphone;
    Button addbtn;
    RadioGroup rdgp;

    String ctrl="AWARENESS";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_event_activity);

        venue=(EditText)findViewById(R.id.venue);
        eventname=(EditText)findViewById(R.id.eventname);
        time=(EditText)findViewById(R.id.time);
        entry=(EditText)findViewById(R.id.entry);
//        contactmail=(EditText)findViewById(R.id.contactmail);
        contactphone=(EditText)findViewById(R.id.contactphone);
        addbtn=(Button)findViewById(R.id.addbtn);
        rdgp=(RadioGroup)findViewById(R.id.category);
        rdgp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId==R.id.fitness)
                {
                    ctrl="FITNESS";
                }
                else if (checkedId==R.id.technical)
                {
                    ctrl="TECHNICAL";
                }
                else if (checkedId==R.id.awareness)
                {
                    ctrl="AWARENESS";
                }
                else if(checkedId==R.id.entertainment)
                {
                    ctrl="ENTERTAINMENT";
                }


            }
        });
        addbtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        int id=v.getId();
        if (id==R.id.addbtn)
        {

            //update the event
            String s1,s2,s3,s4,s5,s6;
            s1=venue.getText().toString();
            s2=eventname.getText().toString();
            s3=time.getText().toString();
            s4=entry.getText().toString();
            //s5=contactmail.getText().toString();
            SharedPreferences sharedPreferences10=getSharedPreferences("MyLoginID",MODE_PRIVATE);

//            SharedPreferences sp=getSharedPreferences("myShare",MODE_PRIVATE);
            s5=sharedPreferences10.getString("LoginID","poi login pannu");


            s6=contactphone.getText().toString();
            /*DatabaseReference init;
            init= FirebaseDatabase.getInstance().getReference();
            init.child("EVENTS/FITNESS/COUNT").setValue("0");
            init.child("EVENTS/TECHNICAL/COUNT").setValue("0");
            init.child("EVENTS/AWARENESS/COUNT").setValue("0");
            init.child("EVENTS/ENTERTAINMENT/COUNT").setValue("0");

            Toast.makeText(getApplicationContext(),"initok",Toast.LENGTH_SHORT).show();




*/
            DatabaseReference myref=FirebaseDatabase.getInstance().getReference("EVENTS/"+ctrl+"/COUNT");
            myref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value=dataSnapshot.getValue(String.class);

                    if (value.isEmpty())
                    {

                    }
                    else
                    {
                        int a=Integer.parseInt(value);
                        SharedPreferences sp = getSharedPreferences(ctrl, MODE_PRIVATE);
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putInt("COUNT", a);
                        editor.commit();

                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

            //read from shared preferences

            SharedPreferences sharedPreferences1=getSharedPreferences(ctrl,MODE_PRIVATE);

//            SharedPreferences sp=getSharedPreferences("myShare",MODE_PRIVATE);
            int b1=sharedPreferences1.getInt("COUNT",-1);

            EventModelClass modelClass=new EventModelClass();
            modelClass.setVenue(s1);
            modelClass.setEventname(s2);
            modelClass.setTime(s3);
            modelClass.setEntry(s4);
            modelClass.setContactmail(s5);
            modelClass.setContactphone(s6);
            modelClass.setCategory(ctrl);

            DatabaseReference reference=FirebaseDatabase.getInstance().getReference();
            reference.child("EVENTS/"+ctrl+"/NAME/"+b1).setValue(modelClass);
            b1++;
            DatabaseReference myref5=FirebaseDatabase.getInstance().getReference();
            myref5.child("EVENTS/"+ctrl+"/COUNT").setValue(""+b1);

            Toast.makeText(getApplicationContext(),"Event Added successfully",Toast.LENGTH_SHORT).show();








        }
    }
}
