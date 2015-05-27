package com.example.administrator.iclub21.util;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.example.administrator.iclub21.R;
import com.example.administrator.iclub21.adapter.ArtistListAdapter;
import com.example.administrator.iclub21.bean.ArtistHeadBean;
import com.example.administrator.iclub21.bean.LoginValueBean;
import com.example.administrator.iclub21.bean.ParmeBean;
import com.example.administrator.iclub21.bean.artist.ArtistListBean;
import com.example.administrator.iclub21.bean.artist.ArtistParme;
import com.example.administrator.iclub21.url.AppUtilsUrl;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.security.NoSuchAlgorithmException;

public class LoginActivity extends ActionBarActivity implements View.OnClickListener {
    @ViewInject(R.id.edit_phone)
    private EditText phoneEdit;
    @ViewInject(R.id.edit_psw)
    private EditText pswEdit;
    @ViewInject(R.id.login_button)
    private Button loginButton;
    @ViewInject(R.id.login_reten_tv)
    private TextView returnTV;
    @ViewInject(R.id.register_tv)
    private TextView RegisterTv;

    private HttpUtils httpUtils;
   // private  String uid;
    //private  String psw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ViewUtils.inject(this);
        init();
    }
     //程序入口
    private void init() {
       intiView();

    }
    private void intiView() {
        // loginButton.setOnClickListener(this);
        returnTV.setOnClickListener(this);
        loginButton.setOnClickListener(this);
        RegisterTv.setOnClickListener(this);
        httpUtils=new HttpUtils();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_reten_tv:
                Intent intent=new Intent(LoginActivity.this,HomeActivity.class);
                intent.putExtra("state","");
                //设置返回数据
                LoginActivity.this.setResult(RESULT_OK, intent);
                LoginActivity.this.finish();
                break;
            case R.id.login_button:
                 String uid=  phoneEdit.getText().toString();
                 String  psw=MD5Uutils.MD5(pswEdit.getText().toString());
                if(uid!=null&&psw!=null){
                try {
                    intiLoginData(uid,psw);
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
                }
                break;
            case R.id.register_tv:
               Intent registerIntent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivityForResult(registerIntent,1);

                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String uid = data.getExtras().getString("uid");
        String psw = data.getExtras().getString("psw");
        try {
            intiLoginData(uid,psw);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    //登录数据
    private void intiLoginData(final String uid,String psw) throws NoSuchAlgorithmException {

        if (uid.length()!=11){
            Toast.makeText(LoginActivity.this,"您输入的电话号码不正确",Toast.LENGTH_LONG).show();

        }else {
            httpUtils.send(HttpRequest.HttpMethod.POST,AppUtilsUrl.getLoginData(uid,psw) , new RequestCallBack<String>() {
                @Override
                public void onSuccess(ResponseInfo<String> responseInfo) {
                    String rerult=responseInfo.result;
                    Log.e("intiData",rerult);
                    if (rerult!=null){

                        ParmeBean<LoginValueBean> artistParme= JSONObject.parseObject(rerult, new TypeReference<ParmeBean<LoginValueBean>>() {
                        });
                        LoginValueBean loginValueBean=  artistParme.getValue();
                       // Log.e("makeText",loginValueBean.getState());
                        if ("success".equals(artistParme.getState())&&uid.equals(loginValueBean.getUid())){
                            Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_LONG).show();
                            Intent intent=new Intent(LoginActivity.this,HomeActivity.class);
                            intent.putExtra("state",loginValueBean.getState());
                            //设置返回数据
                            LoginActivity.this.setResult(RESULT_OK, intent);
                            finish();
                        }else {
                            Toast.makeText(LoginActivity.this,"密码或用户名错误",Toast.LENGTH_LONG).show();


                        }
                    }


                }

                @Override
                public void onFailure(HttpException e, String s) {
                    // Log.e("onFailure",s);
                }
            });

        }
        //Log.e("psw",MD5Uutils.encryptMd5(psw));





    }


}
