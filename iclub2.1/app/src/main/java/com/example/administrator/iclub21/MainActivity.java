package com.example.administrator.iclub21;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.example.administrator.iclub21.util.HomeActivity;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inti();
     //TextView textView;
        //shshkksjdjdjdsgs
    }
    public  void inti(){
        Intent intent=new Intent(this, HomeActivity.class);
        startActivity(intent);

    }

}
