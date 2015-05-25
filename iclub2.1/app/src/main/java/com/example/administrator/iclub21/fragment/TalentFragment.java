package com.example.administrator.iclub21.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.example.administrator.iclub21.R;
import com.example.administrator.iclub21.adapter.TalentListAdapter;
import com.example.administrator.iclub21.bean.artist.ArtistParme;
import com.example.administrator.iclub21.bean.talent.TalentValueBean;
import com.example.administrator.iclub21.url.AppUtilsUrl;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TalentFragment extends Fragment {
    @ViewInject(R.id.talent_listView)
          private ListView talentList;

    public TalentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_talent, container, false);
        ViewUtils.inject(this,view);
        inti();
        return view;
    }

    private void inti() {

        initTalentData();
    }

    private void initTalentData() {
        HttpUtils httpUtils=new HttpUtils();

      httpUtils.send(HttpRequest.HttpMethod.GET, AppUtilsUrl.getTalentList(), new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String result=responseInfo.result;
                if (result!=null) {
                    ArtistParme<TalentValueBean> talentBean = JSONObject.parseObject(result, new TypeReference<ArtistParme<TalentValueBean>>() {
                    });
                    if (talentBean.getState().equals("success")){
                      List<TalentValueBean> talentData= talentBean.getValue();
                        TalentListAdapter talentAdapter=new TalentListAdapter(talentData,getActivity());
                        talentList.setAdapter(talentAdapter);
                        talentAdapter.notifyDataSetChanged();

                    }

                }


            }

            @Override
            public void onFailure(HttpException e, String s) {

            }
        });


    }


}
