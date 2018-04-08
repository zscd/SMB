package com.example.zsk.smb;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

//import com.example.zsk.smb.MainActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

import static com.example.zsk.smb.MainActivity.UPDATE_TEXT;

public class LoginActivity extends AppCompatActivity {

    private EditText id_login;
    private EditText password_login;
    private ImageView avatar_login;
    private CheckBox remember_password_login;
    private CheckBox auto_login;
    private Button button_login;
    private Button button_register;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
  // private String idvalue;
    //private String passwordvalue;
    //private static final int PASSWORD_MIWEN = 0x81;
    //private TextView activity_login_button_zhuce;

    private Handler handler = new Handler(){
        public void handleMessage(Message msg){
            switch (msg.what){
                case UPDATE_TEXT:
                    Toast.makeText(LoginActivity.this,"手机号或密码输入错误！",
                            Toast.LENGTH_SHORT).show();
                    break;
            }
            //super.handleMessage(msg);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        id_login=(EditText) findViewById(R.id.login_id);
        password_login=(EditText)findViewById(R.id.login_password);
        avatar_login = (ImageView)findViewById(R.id.login_avatar);
        remember_password_login = (CheckBox)findViewById(R.id.login_remember_password);
        auto_login = (CheckBox)findViewById(R.id.login_auto_login);
        button_login=(Button)findViewById(R.id.login_button);
        button_register = (Button)findViewById(R.id.activity_login_button_zhuce);
        boolean isRemember1 = pref.getBoolean("remember_password",false);
        boolean isRemember2 = pref.getBoolean("auto_login",false);
        if(isRemember1){
            //将账号和密码设置到文本框中
            String account = pref.getString("account","");
            String password = pref.getString("password","");
            id_login.setText(account);
            password_login.setText(password);
            remember_password_login.setChecked(true);
            if(isRemember2){
                auto_login.setChecked(true);
                Intent intent = new Intent(LoginActivity.this,BottomTabLayoutActivity.class);
                startActivity(intent);
            }
        }

        button_login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final String account = id_login.getText().toString();
                final String password = password_login.getText().toString();
                String url ="http://api.deepsleeping.tech/api/Login";
                String json = "{\"Phone\":\""+account+"\",\"Password\":\""+password+"\"}";
                HttpUtil.SendOkHttpRequest(url,json,new okhttp3.Callback(){
                    @Override
                    public void onResponse(Call call, Response response)throws IOException{
                        String responseData = response.body().string();
                        try{
                            JSONObject obj = new JSONObject(responseData);
                            String flag = obj.getString("Flag");
                            //parseJSONWithJSONObject(responseData);
                            if(flag.equals("1")){                                       //表示成功
                                editor = pref.edit();
                                if(remember_password_login.isChecked()){
                                    editor.putBoolean("remember_password",true);
                                    editor.putString("account",account);
                                    editor.putString("password",password);
                                    if(auto_login.isChecked()){
                                        editor.putBoolean("auto_login",true);
                                    }
                                }else {
                                    editor.clear();
                                }
                                editor.apply();
                                Intent intent = new Intent(LoginActivity.this,BottomTabLayoutActivity.class);
                                startActivity(intent);
                                finish();

                            }else {
                                Message message = new Message();
                                message.what = UPDATE_TEXT;
                                handler.sendMessage(message);
                            }

                        }catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    public void onFailure(Call call, IOException e){
                        System.out.println(e.getMessage());
                    }
                });


            }
        });

        button_register.setOnClickListener(new View.OnClickListener(){
          @Override
           public void onClick(View v){
              Intent intent = new Intent(LoginActivity.this,MainActivity.class);
              startActivity(intent);

           }
        });

    }

}
