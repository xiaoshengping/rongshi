package com.example.administrator.iclub21.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.administrator.iclub21.R;
import com.example.administrator.iclub21.util.ResumeActivity;
import com.example.administrator.iclub21.util.RoleActivity;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * A simple {@link Fragment} subclass.
 */
public class RoleTalentsFragment extends Fragment implements View.OnClickListener {
    @ViewInject(R.id.talents_image)
    private ImageView talentsImage;
   @ViewInject(R.id.cloess_talents_tv)
    private TextView cloessTalents;
    @ViewInject(R.id.cwei_talents_tv)
    private TextView cweiTalents;


    public RoleTalentsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_role_talents, container, false);
        ViewUtils.inject(this,view);
         inti();
        return view;
    }

    private void inti() {
        intiView();


    }

    private void intiView() {
        cloessTalents.setOnClickListener(this);
        cweiTalents.setOnClickListener(this);


        Bundle bundle=getArguments();
        int imageUrl= bundle.getInt("iamgeUrl");
        talentsImage.setBackgroundResource(imageUrl);
        if (imageUrl==R.mipmap.talents_icon_d){
            cloessTalents.setVisibility(View.VISIBLE);
            cweiTalents.setVisibility(View.VISIBLE);


        }


    }


    @Override
    public void onClick(View v) {
           switch (v.getId()){
               case R.id.cloess_talents_tv:
                   Intent intent=new Intent(getActivity(), RoleActivity.class);
                   startActivity(intent);
                   break;
               case R.id.cwei_talents_tv:
                    Intent intentAdd=new Intent(getActivity(),ResumeActivity.class);
                   startActivity(intentAdd);
                   break;

           }
    }
}
