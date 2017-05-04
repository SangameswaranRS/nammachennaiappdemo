package com.example.sangameswaran.nammachennai;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener {

    EditText e1,e2;
    Button login,signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        e1=(EditText)findViewById(R.id.emailEditText);
        e2=(EditText)findViewById(R.id.passwordEditText);
        login=(Button)findViewById(R.id.loginBtn);
        signup=(Button)findViewById(R.id.signupBtn);
        login.setOnClickListener(this);
        signup.setOnClickListener(this);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Developed by team Segmentation Fault", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DatabaseReference myref54= FirebaseDatabase.getInstance().getReference("BOOKCOUNT");


        myref54.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value=dataSnapshot.getValue(String.class);
                int a=Integer.parseInt(value);
                SharedPreferences sp=getSharedPreferences("myShare",MODE_PRIVATE);
                SharedPreferences.Editor editor=sp.edit();
                editor.putInt("bookCount",a);
                Log.d("kdfkash","bookc="+a);
                editor.commit();


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });




        DatabaseReference myref=FirebaseDatabase.getInstance().getReference("EVENTS/FITNESS/COUNT");
        myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value=dataSnapshot.getValue(String.class);
                if (value.equals(""))
                {

                }
                else {
                    int a = Integer.parseInt(value);
                    SharedPreferences sp = getSharedPreferences("FITNESS", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt("COUNT", a);
                    editor.commit();
                    //successful
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        DatabaseReference myref2=FirebaseDatabase.getInstance().getReference("EVENTS/TECHNICAL/COUNT");
        myref2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value=dataSnapshot.getValue(String.class);
                if (value.equals(""))
                {

                }
                else {
                    int a = Integer.parseInt(value);
                    SharedPreferences sp = getSharedPreferences("TECHNICAL", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt("COUNT", a);
                    editor.commit();
                    //successful
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        DatabaseReference myref3=FirebaseDatabase.getInstance().getReference("EVENTS/AWARENESS/COUNT");
        myref3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value=dataSnapshot.getValue(String.class);
                if (value.equals(""))
                {

                }
                else {
                    int a = Integer.parseInt(value);
                    SharedPreferences sp = getSharedPreferences("AWARENESS", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt("COUNT", a);
                    editor.commit();
                    //successful
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        DatabaseReference myref4=FirebaseDatabase.getInstance().getReference("EVENTS/ENTERTAINMENT/COUNT");
        myref4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value=dataSnapshot.getValue(String.class);
                if (value.equals(""))
                {

                }
                else {
                    int a = Integer.parseInt(value);
                    SharedPreferences sp = getSharedPreferences("ENTERTAINMENT", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt("COUNT", a);
                    editor.commit();
                    //successful
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
















        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            Toast.makeText(getApplicationContext(),"Thanks for using",Toast.LENGTH_SHORT).show();
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action

            Intent intent=new Intent(this,AddEventActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_gallery) {
            Intent intent=new Intent(this,ViewEventAuthorizer.class);
            startActivity(intent);

        } else if (id == R.id.nav_slideshow) {
            Intent intent=new Intent(this,AddBookActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_manage) {
            Intent intent=new Intent(this,ViewBookActivity.class);
            startActivity(intent);

        }
        else if (id==R.id.manageBook)
        {
            Intent intent=new Intent(this,ManageBookActivity.class);
            startActivity(intent);
        }
        else if (id==R.id.homebtn)
        {
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
        }
        else if (id==R.id.map)
        {
            Intent intent=new Intent(this,MapsActivity.class);
            startActivity(intent);
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {

        int id=v.getId();
        if(id==R.id.loginBtn)
        {
            final String s1,s2;
            s1=e1.getText().toString();
            s2=e2.getText().toString();

            if(s1.equals("")||s2.equals(""))
            {
                Toast.makeText(getApplicationContext(),"Enter your login info to continue",Toast.LENGTH_SHORT).show();
            }
            else {
                DatabaseReference myref = FirebaseDatabase.getInstance().getReference("USERS/"+s1);
                myref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChildren())
                        {
                            UserModelClass modelClass=new UserModelClass();
                            modelClass=dataSnapshot.getValue(UserModelClass.class);
                            Log.d("MAIN ACTIVITY LOGIN","name"+modelClass.getName()+"Pass:"+modelClass.getPassword());
                            if (s1.equals(modelClass.getName())&&s2.equals(modelClass.getPassword()))
                            {

                                SharedPreferences sp4=getSharedPreferences("MyLoginID",MODE_PRIVATE);
                                SharedPreferences.Editor editor3=sp4.edit();
                                editor3.putString("LoginID",s1);
                                editor3.commit();


                                SharedPreferences sp5=getSharedPreferences("MyLoginPW",MODE_PRIVATE);
                                SharedPreferences.Editor editor5=sp5.edit();
                                editor3.putString("LoginPW",s2);
                                editor3.commit();

                                Toast.makeText(getApplicationContext(),"Authentication Successful, you may continue",Toast.LENGTH_SHORT).show();

                            }

                            else
                            {
                                Toast.makeText(getApplicationContext(),"Incorrect password",Toast.LENGTH_SHORT).show();
                            }

                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"User ID doesnot exist use Sign in Button",Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
             }

        }
        else if (id==R.id.signupBtn)
        {
            final String s1,s2;
            s1=e1.getText().toString();
            s2=e2.getText().toString();

            UserModelClass modelClass=new UserModelClass(s1,s2);
            DatabaseReference rf3=FirebaseDatabase.getInstance().getReference();
            rf3.child("USERS/"+s1).setValue(modelClass);
            Toast.makeText(getApplicationContext(),"Signning up",Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(),"Signup Successful",Toast.LENGTH_SHORT).show();
        }
    }
}
