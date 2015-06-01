package com.example.administrator.iclub21.fragment;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.iclub21.R;
import com.example.administrator.iclub21.http.MyAppliction;
import com.example.administrator.iclub21.url.AppUtilsUrl;
import com.example.administrator.iclub21.util.LoginActivity;
import com.example.administrator.iclub21.util.RoleActivity;
import com.example.administrator.iclub21.util.SQLhelper;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;


/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends Fragment implements View.OnClickListener {
    @ViewInject(R.id.login_layout)
      private TextView loginLayout;
    @ViewInject(R.id.login_cancel)
    private LinearLayout cancel;
    @ViewInject(R.id.mine_head_iv)
    private ImageView headTv;
    @ViewInject(R.id.mine_name)
    private TextView mineName;
    @ViewInject(R.id.mine_role_layout)
    private LinearLayout roleLayout;

    private String state;

    public MineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            View view=inflater.inflate(R.layout.fragment_mine, container, false);
            ViewUtils.inject(this, view);
        init();
        return view;
    }

    private void init() {
        cancel.setOnClickListener(this);
        loginLayout.setOnClickListener(this);
        roleLayout.setOnClickListener(this);
        SQLhelper sqLhelper=new SQLhelper(getActivity());
        SQLiteDatabase db= sqLhelper.getWritableDatabase();
        Cursor cursor=db.query("user",null,null,null,null,null,null);
        while (cursor.moveToNext()) {
            String states = cursor.getString(0);
            if (states!=null){
                loginLayout.setVisibility(View.GONE);
                cancel.setVisibility(View.VISIBLE);
            }

        }
        cursor.close();
        db.close();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, final Intent data) {
        state = data.getExtras().getString("state");//得到新Activity 关闭后返回的数据
        if (state.equals("1")||state.equals("2")||state.equals("3")){
            loginLayout.setVisibility(View.GONE);
            cancel.setVisibility(View.VISIBLE);
            MyAppliction.imageLoader.displayImage(AppUtilsUrl.ImageBaseUrl + data.getStringExtra("imageUrl"), headTv, MyAppliction.RoundedOptions);
            mineName.setText(data.getStringExtra("userName"));

        }else {
            loginLayout.setVisibility(View.VISIBLE);
            cancel.setVisibility(View.GONE);

        }


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_layout:
                Intent intent=new Intent(getActivity(),LoginActivity.class);
                startActivityForResult(intent,1);
                break;
            case R.id.login_cancel:
                showExitGameAlert();
                break;
            case  R.id.mine_role_layout:
              SQLhelper sqLhelper=new SQLhelper(getActivity());
              SQLiteDatabase db= sqLhelper.getWritableDatabase();
                Cursor cursor=db.query("user",null,null,null,null,null,null);
                while (cursor.moveToNext()) {
                    String states = cursor.getString(0);

                }
                cursor.close();
                db.close();
                Intent intent1 = new Intent(getActivity(), RoleActivity.class);
                startActivity(intent1);
                break;

        }
    }


    //对话框
    private void showExitGameAlert() {
        final AlertDialog dlg = new AlertDialog.Builder(getActivity()).create();
        dlg.show();
        Window window = dlg.getWindow();
        // *** 主要就是在这里实现这种效果的.
        // 设置窗口的内容页面,shrew_exit_dialog.xml文件中定义view内容
        window.setContentView(R.layout.shrew_exit_dialog);
        TextView tailte = (TextView) window.findViewById(R.id.tailte_tv);
        tailte.setText("确定注册账号？");
        // 为确认按钮添加事件,执行退出应用操作
        TextView ok = (TextView) window.findViewById(R.id.btn_ok);
        ok.setText("确定");
        ok.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cancel.setVisibility(View.GONE);
                loginLayout.setVisibility(View.VISIBLE); // 退出应用...
                SQLhelper sqLhelper = new SQLhelper(getActivity());
                SQLiteDatabase db = sqLhelper.getWritableDatabase();
                Cursor cursor = db.query("user", null, null, null, null, null, null);
                while (cursor.moveToNext()) {
                    String states = cursor.getString(0);
                    Log.e("states", states);
                    if (states != null) {

                        db.delete("user", null, null);

                    }
                }
                cursor.close();
                db.close();
                dlg.cancel();
            }
        });

        // 关闭alert对话框架
        TextView cancel = (TextView) window.findViewById(R.id.btn_cancel);
        cancel.setText("取消");
        cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dlg.cancel();
            }
        });
    }

}
