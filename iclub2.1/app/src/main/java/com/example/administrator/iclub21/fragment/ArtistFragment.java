package com.example.administrator.iclub21.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.example.administrator.iclub21.R;
import com.example.administrator.iclub21.adapter.ArtistListAdapter;
import com.example.administrator.iclub21.adapter.ArtistPagerAdapter;
import com.example.administrator.iclub21.bean.ArtistHeadBean;
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

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArtistFragment extends Fragment {
       @ViewInject(R.id.artist_pager)
    private ViewPager artistPager;
    private HttpUtils httpUtils;
    @ViewInject(R.id.artist_list_gridView)
    private GridView artistGridView;
    List<ArtistHeadBean> headDate=new ArrayList<ArtistHeadBean>();

    public ArtistFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_artist, container, false);
        ViewUtils.inject(this, view);
             inti();
        return view;
    }

    private void inti() {
        httpUtils=new HttpUtils();
        initPager();
        intiHeadData();
      initListData();

    }

    private void initListData() {
        httpUtils.send(HttpRequest.HttpMethod.GET, AppUtilsUrl.getArtistList(), new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String result = responseInfo.result;
                if (result != null) {
                    ArtistParme<ArtistListBean> artistParme = JSONObject.parseObject(result, new TypeReference<ArtistParme<ArtistListBean>>() {
                    });
                    if ("success".equals(artistParme.getState())) {
                       // List<ArtistListBean> artistListData = artistParme.getValue();
                        //intiGridView(artistListData);
                      Log.e("name", artistParme.getValue().get(0).getArtistPicture().get(0).getName())  ;
                        ArtistListAdapter adapter=new ArtistListAdapter(artistParme.getValue(),getActivity());
                        artistGridView.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    }
                }

            }

            @Override
            public void onFailure(HttpException e, String s) {
                Log.e("onFailure",s);
            }
        });


    }

   /* private void intiGridView( List<ArtistListBean> artistListData) {
        ArtistListAdapter adapter=new ArtistListAdapter(artistListData,getActivity());
        artistGridView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }*/

    private void intiHeadData() {
          HttpUtils headHttpUtils=new HttpUtils();
        headHttpUtils.send(HttpRequest.HttpMethod.GET, AppUtilsUrl.getArtistHead(), new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                 String result=responseInfo.result;
                if (result!=null){
                    ArtistParme<ArtistHeadBean> headBean= JSONObject.parseObject(result,new TypeReference<ArtistParme<ArtistHeadBean>>(){});
                    if ("success".equals(headBean.getState())){
                       // headDate.addAll(headBean.getValue());
                        ArtistPagerAdapter adapter=new ArtistPagerAdapter(getActivity().getSupportFragmentManager(),headBean.getValue());
                        artistPager.setAdapter(adapter);

                    }

                }


            }

            @Override
            public void onFailure(HttpException e, String s) {

            }
        });


    }

    private void initPager() {


    }


}
