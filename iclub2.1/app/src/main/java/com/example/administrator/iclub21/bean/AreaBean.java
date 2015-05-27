package com.example.administrator.iclub21.bean;

import android.content.Context;

import com.example.administrator.iclub21.R;

/**
 * Created by Administrator on 2015/5/27.
 */
public class AreaBean {

//    private String[] s;
    public String getArea(Context context,int num){
//        str = context.getString(R.string.hello_world);
//        str = "fasdfasdf";
//        String str = "abc-d";
         String[] s = context.getString(R.string.area).split(";");
//        String pattern="_";
//        Pattern pat=Pattern.compile(pattern);
//        final String[] rs = pat.split(str);
        return s[num];
    }

}
