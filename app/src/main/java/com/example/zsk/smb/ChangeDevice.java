package com.example.zsk.smb;

import android.content.Intent;
import android.content.SharedPreferences;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;



public class ChangeDevice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_device);
        ImageView imageView =(ImageView)findViewById(R.id.return_arrow);
        TextView textView = (TextView)findViewById(R.id.device_id);
        RelativeLayout relativeLayout = (RelativeLayout)findViewById(R.id.coupon_popup);
        SharedPreferences pref = getSharedPreferences("id",MODE_PRIVATE);
        String id = pref.getString("id-code","0");
        String string = "当前设备ID: "+id;
        textView.setText(string);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
        relativeLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(ChangeDevice.this,BindingActivity.class);
                startActivity(intent);
            }
        });

    }
}
