package com.example.zsk.smb;

import android.animation.ValueAnimator;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.view.Window;
import android.view.WindowManager;
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
    private Button get_code;
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
                    dimBackground(0.5f,1.0f);
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
        setContentView(R.layout.login_new);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        id_login=(EditText) findViewById(R.id.login_id);
        password_login=(EditText)findViewById(R.id.login_password);
        avatar_login = (ImageView)findViewById(R.id.login_avatar);
        remember_password_login = (CheckBox)findViewById(R.id.login_remember_password);
        auto_login = (CheckBox)findViewById(R.id.login_auto_login);
        button_login=(Button)findViewById(R.id.login_button);
        button_register = (Button)findViewById(R.id.activity_login_button_zhuce);
        get_code = (Button)findViewById(R.id.get_code);
        boolean isRemember1 = pref.getBoolean("remember_password",false);
        boolean isRemember2 = pref.getBoolean("auto_login",false);
        String exitFlag = getIntent().getStringExtra("flag");

        if(isRemember1){
            //将账号和密码设置到文本框中
            String account = pref.getString("account","");
            String password = pref.getString("password","");
            id_login.setText(account);
            password_login.setText(password);
            remember_password_login.setChecked(true);
            if(isRemember2){
                if(exitFlag == null) {
                    auto_login.setChecked(true);
                    Intent intent = new Intent(LoginActivity.this,BottomTabLayoutActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }

        button_login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final String account = id_login.getText().toString();
                final String password = password_login.getText().toString();
                String url ="http://api.deepsleeping.tech/api/Login";
                String json = "{\"Phone\":\""+account+"\",\"Password\":\""+password+"\"}";
                Toast.makeText(LoginActivity.this,"正在登录…",Toast.LENGTH_SHORT).show();
                dimBackground(1.0f,0.5f);
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
                                    editor.putString("token",obj.getString("Token"));
                                    if(auto_login.isChecked()){
                                        editor.putBoolean("auto_login",true);
                                    }
                                }else {
                                    editor.clear();
                                }
                                editor.apply();
                                if(isFirstRun()){
                                    Intent intent = new Intent(LoginActivity.this,BindingActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                                else{
                                    Intent intent = new Intent(LoginActivity.this,BottomTabLayoutActivity.class);
                                    startActivity(intent);
                                    finish();
                                }

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
        get_code.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                new CountDownTimer(30000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        get_code.setEnabled(false);
                        get_code.setText(String.format("%ds后重新发送",millisUntilFinished/1000));
                    }

                    @Override
                    public void onFinish() {
                        get_code.setEnabled(true);
                        get_code.setText("获取验证码");
                    }
                }.start();
            }
        });
    }

    private void dimBackground(final float from, final float to) {
        final Window window = getWindow();
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(from, to);
        valueAnimator.setDuration(500);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                WindowManager.LayoutParams params = window.getAttributes();
                params.alpha = (Float) animation.getAnimatedValue();
                window.setAttributes(params);
            }
        });

        valueAnimator.start();
    }
    private boolean isFirstRun(){
        SharedPreferences sharedPreferences = this.getSharedPreferences(
                "share", MODE_PRIVATE);
        //实例化SharedPreferences.Editor对象（第二步）
        boolean isFirstRun = sharedPreferences.getBoolean("isFirstRun", true);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (!isFirstRun) {
            return false;
        } else {
            //保存数据 （第三步）
            editor.putBoolean("isFirstRun", false);
            //提交当前数据 （第四步）
            editor.commit();
            return true;
        }
    }
}
