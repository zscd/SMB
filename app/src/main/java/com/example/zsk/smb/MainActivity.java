package com.example.zsk.smb;

//import com.example.zsk.smb.LoginActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.print.PrinterCapabilitiesInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.security.PrivateKey;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    public static final int UPDATE_TEXT = 1;
    public  static final int ONUPDATE_TEXT = 0;
    private EditText phonenum;
    private EditText password;
    private EditText password_again;
    private Button rigister_button;
    private Button return_button;

    private Handler handler = new Handler(){
        public void handleMessage(Message msg){
            switch (msg.what){
                case UPDATE_TEXT:
                    Toast.makeText(MainActivity.this, "注册成功！",
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                    break;
                case ONUPDATE_TEXT:
                    Toast.makeText(MainActivity.this, "注册失败！",
                            Toast.LENGTH_SHORT).show();
            }
            //super.handleMessage(msg);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phonenum = (EditText)findViewById(R.id.Rigister_EditText_Phonenum);
        password = (EditText)findViewById(R.id.Rigister_EditText_EnterPassword);
        password_again = (EditText)findViewById(R.id.Rigister_EditText_ConfirmPassword);
        rigister_button = (Button)findViewById(R.id.Rigister_Button_Rigister);
        return_button = (Button)findViewById(R.id.Rigister_Button_Return);
        rigister_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String num= phonenum.getText().toString();
                String psw_1 = password.getText().toString();
                String psw_2 = password_again.getText().toString();
                if(psw_1.equals(psw_2)){
                    attemptRigister(num,psw_1);
                }
                else{
                    Toast.makeText(MainActivity.this,"密码不一致，重新输入",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        return_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(MainActivity.this,"放弃注册！",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    void attemptRigister(final String num ,final String password){

        new Thread(){
            @Override
            public void run(){
                try{
                    String url = "http://api.deepsleeping.tech/api/Register";
                    OkHttpClient client = new OkHttpClient();
                    String json = "{\"Phone\":\""+num+"\",\"Password\":\""+password+"\",\"Name\":\"未知\",\"Sex\":\"未知\",\"BirthDate\":\"2018-01-01\"}";

                    MediaType JSON = MediaType.parse("application/json;charset=utf-8");
                    RequestBody requestbody = RequestBody.create(JSON,json);
                    Request request = new Request.Builder()
                            .url(url)
                            .post(requestbody)
                            .build();
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
                  //  System.out.println(responseData);
                   //下一步解析json数据
                    parseJSONWithJSONObject(responseData);
                }
                catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }.start();
    }
    private void parseJSONWithJSONObject(String jsonData) {
        try {
                JSONObject obj = new JSONObject(jsonData);
                String flag = obj.getString("Flag");
               // System.out.println(flag+" flag equals");
                Message message = new Message();
                if (flag.equals("1")) {
                    message.what = UPDATE_TEXT;
                        //handler.sendMessage(message);
                } else {
                    message.what = ONUPDATE_TEXT;
                }
                handler.sendMessage(message);


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("又跳过来了！");
        }
    }
}
