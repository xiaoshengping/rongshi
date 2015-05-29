package com.example.administrator.iclub21.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.iclub21.R;
import com.example.administrator.iclub21.http.MyAppliction;
import com.example.administrator.iclub21.url.AppUtilsUrl;
import com.example.administrator.iclub21.util.LoginActivity;
import com.example.administrator.iclub21.util.RoleActivity;
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
            ViewUtils.inject(this,view);
        init();
        return view;
    }

    private void init() {
        cancel.setOnClickListener(this);
        loginLayout.setOnClickListener(this);
        roleLayout.setOnClickListener(this);

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
                cancel.setVisibility(View.GONE);
                loginLayout.setVisibility(View.VISIBLE);
                break;
            case  R.id.mine_role_layout:
                if (state.equals("1")||state.equals("2")||state.equals("3")){
                    Intent intent1=new Intent(getActivity(),RoleActivity.class);
                    intent1.putExtra("state",state);
                    startActivity(intent1);

                }else if(state.equals("")) {
                    Intent intent2=new Intent(getActivity(),LoginActivity.class);
                    startActivityForResult(intent2,1);
                }
                break;

        }
    }
}
