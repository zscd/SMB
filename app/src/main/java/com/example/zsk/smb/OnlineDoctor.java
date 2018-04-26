package com.example.zsk.smb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class OnlineDoctor extends AppCompatActivity {

    RelativeLayout relativeLayout_2;
    RelativeLayout relativeLayout_3;
    RelativeLayout relativeLayout_4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_doctor);
        ImageView imageview = (ImageView)findViewById(R.id.return_arrow);
        relativeLayout_2 = (RelativeLayout)findViewById(R.id.relativelayout_2);
        relativeLayout_3 = (RelativeLayout)findViewById(R.id.relativelayout_3);
        relativeLayout_4 = (RelativeLayout)findViewById(R.id.relativelayout_4);
        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        relativeLayout_2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OnlineDoctor.this,ChattingDoctor.class);
                startActivity(intent);
            }
        });
        relativeLayout_3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OnlineDoctor.this,ChattingDoctor.class);
                startActivity(intent);
            }
        });
        relativeLayout_4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OnlineDoctor.this,ChattingDoctor.class);
                startActivity(intent);
            }
        });
    }
}
