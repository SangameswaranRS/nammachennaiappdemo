package com.example.sangameswaran.nammachennai;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

/**
 * Created by Sangameswaran on 25-03-2017.
 */

public class ViewEventAuthorizer extends AppCompatActivity implements View.OnClickListener{
    RadioGroup r;
    Button b;
    String ct="TECHNICAL"
;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_event_authorizer);
        r=(RadioGroup)findViewById(R.id.selector);
        b=(Button)findViewById(R.id.continuebtn);
        r.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId==R.id.entertainmentrdbtn)
                {
                    ct="ENTERTAINMENT";
                }
                else if (checkedId==R.id.technicalrdbtn)
                {
                    ct="TECHNICAL";
                }
                else if (checkedId==R.id.awarenessrdbtn)
                {
                    ct="AWARENESS";
                }
                else if (checkedId==R.id.fitnessrdbtn)
                {
                    ct="FITNESS";
                }
            }
        });


        b.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        if (id==R.id.continuebtn)
        {
            if(ct.equals("TECHNICAL"))
            {
                Intent intent=new Intent(this,TechnicalRecyclerViewActivity.class);
                startActivity(intent);
            }
            else if (ct.equals("AWARENESS"))
            {
                Intent intent=new Intent(this,AwarenessRecyclerView.class);
                startActivity(intent);
            }
            else if (ct.equals("FITNESS"))
            {
                Intent intent =new Intent(this,FitnessRecyclerViewActivity.class);
                startActivity(intent);
            }
            else if (ct.equals("ENTERTAINMENT"))
            {
                Intent intent=new Intent(this,EntertainmentRecyclerViewActivity.class);
                startActivity(intent);
            }
        }

    }
}
