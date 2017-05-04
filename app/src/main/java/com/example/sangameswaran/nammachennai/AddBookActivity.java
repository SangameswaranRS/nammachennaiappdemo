package com.example.sangameswaran.nammachennai;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Sangameswaran on 25-03-2017.
 */

public class AddBookActivity extends AppCompatActivity implements View.OnClickListener {
    EditText e1,e2,e3,e4,e5,e6,e7,e8;
    Button b1;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.add_book_activity_layout);
        e1=(EditText)findViewById(R.id.bookname);
        e2=(EditText)findViewById(R.id.bookisbn);
        e3=(EditText)findViewById(R.id.authorname);
        e4=(EditText)findViewById(R.id.availablity);
        e5=(EditText)findViewById(R.id.publisher);
        e6=(EditText)findViewById(R.id.bookedition);
        e7=(EditText)findViewById(R.id.ownername);
        e8=(EditText)findViewById(R.id.ownercontact);
        b1=(Button)findViewById(R.id.submitbtn);
        b1.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        int id=v.getId();
        if (id==R.id.submitbtn)
        {
            String s1,s2,s3,s4,s5,s6,s7,s8;
            s1=e1.getText().toString();
            s2=e2.getText().toString();
            s3=e3.getText().toString();
            s4=e4.getText().toString();
            s5=e5.getText().toString();
            s6=e6.getText().toString();
            s7=e7.getText().toString();
            s8=e8.getText().toString();

            SharedPreferences sharedPreferences1=getSharedPreferences("MyLoginID",MODE_PRIVATE);

//            SharedPreferences sp=getSharedPreferences("myShare",MODE_PRIVATE);
            String  b1=sharedPreferences1.getString("LoginID","poi login pannu");
            Log.d("OOTTT","b1="+b1);
            int fla=1;
            if (s7.equals(b1))
            {
                fla=0;

            }
            Log.d("OOT","VAALLLLLLLUUUUEEEEEEEEEEEEEEEEEE"+fla);

            if((s1.equals("")||s2.equals("")||s3.equals("")||s4.equals("")||s5.equals("")||s6.equals("")||s7.equals("")||s8.equals(""))||fla==1)
            {

                Toast.makeText(getApplicationContext(),"Enter all the fields to add book/Verify your User id",Toast.LENGTH_LONG).show();
            }

            else
            {

            DatabaseReference mdatabaseref;
            mdatabaseref= FirebaseDatabase.getInstance().getReference("BOOKCOUNT");

                //mdatabaseref.setValue("1");

            mdatabaseref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value=dataSnapshot.getValue(String.class);
                    int a=Integer.parseInt(value);
                    SharedPreferences sharedPreferences=getSharedPreferences("GLOBALCOUNTERS",MODE_PRIVATE);
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putInt("BOOKCOUNT",a);
                    editor.commit();
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
                SharedPreferences sp=getSharedPreferences("GLOBALCOUNTERS",MODE_PRIVATE);
                int b=sp.getInt("BOOKCOUNT",-1);
                b++;
                Toast.makeText(getApplicationContext(),"Updated total number of books in the database is"+b,Toast.LENGTH_LONG).show();

                DatabaseReference myref3;
                myref3=FirebaseDatabase.getInstance().getReference();
                myref3.child("BOOKCOUNT").setValue(""+b);

                //write b to shared preferences for later access.
                SharedPreferences sharedPreferences=getSharedPreferences("MYBOOKS"+s1+s2,MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putInt(s1+s2,b);
                Log.d("TTAAAAAAAAAGGGGGGG","ajsv"+s1+s2);
                editor.commit();

                DatabaseReference myref2;
                myref2=FirebaseDatabase.getInstance().getReference();
                BookModelClass modelClass=new BookModelClass(s1,s2,s3,s4,s5,s6,s7,s8);
                myref2.child("BOOKS/"+b).setValue(modelClass);
                Toast.makeText(getApplicationContext(),"Book Successfully added to peer network",Toast.LENGTH_LONG).show();







            }


    }
}}
