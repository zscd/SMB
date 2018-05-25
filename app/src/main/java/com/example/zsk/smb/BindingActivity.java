package com.example.zsk.smb;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.StringTokenizer;


public class BindingActivity extends AppCompatActivity {

    EditText editText_1;
    EditText editText_2;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binding);
        editText_1 = (EditText)findViewById(R.id.binding_id);
        editText_2 = (EditText)findViewById(R.id.verification_code);
        button = (Button)findViewById(R.id.binding_button);

       button.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){
               final String id = editText_1.getText().toString();
               final String code = editText_2.getText().toString();
               Intent intent = new Intent(BindingActivity.this,BottomTabLayoutActivity.class);
               SharedPreferences.Editor editor = getSharedPreferences("id",MODE_PRIVATE).edit();
               editor.putString("id-code",id);
               editor.apply();
               startActivity(intent);
           }
       });
    }
}
