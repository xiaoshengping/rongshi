package com.example.administrator.iclub21.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.example.administrator.iclub21.R;
import com.example.administrator.iclub21.adapter.RecruitmentListAdapter;
import com.example.administrator.iclub21.bean.artist.ArtistParme;
import com.example.administrator.iclub21.bean.recruitment.RecruitmentImageBean;
import com.example.administrator.iclub21.bean.recruitment.RecruitmentListBean;
import com.example.administrator.iclub21.bean.recruitment.SlideShowView;
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
public class RecruitmentFragment extends Fragment {

//    @ViewInject(R.id.tv1)
//    private TextView tv1;
    @ViewInject(R.id.v1)
    private View v1;
    @ViewInject(R.id.recruitment_listView)
    private ListView recruitmentList;
    @ViewInject(R.id.recruiment_list_title)
    private LinearLayout recruiment_list_title;

    private RecruitmentListAdapter recruitmentAdapter;

//   private LinearLayout recruitment_title_ll;

    public RecruitmentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_recruitment, container, false);
        ViewUtils.inject(this, view);

        inti();
        return view;
//        return inflater.inflate(R.layout.fragment_recruitment, container, false);
    }


    private void inti() {

//        recruitment_title_ll = (LinearLayout)(getActivity()).findViewById(R.id.recruitment_title_ll);


//        initRecruitmentListData();
        initRecruitmentImageData();
        recruitmentList.setOnScrollListener(new AbsListView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
//                if(firstVisibleItem ==1){
//                    recruiment_list_title.setVisibility(View.INVISIBLE);
////                    recruiment_list_title_ad.setVisibility(View.VISIBLE);
//                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem,int visibleItemCount, int totalItemCount) {

//
                if (firstVisibleItem >=1 ) {
                    recruitmentAdapter.floatingCollar=true;
//                    recruiment_list_title_ad.setVisibility(View.GONE);
//                } else if(firstVisibleItem ==1 ) {
                    recruiment_list_title.setVisibility(View.VISIBLE);
//                    if(recruiment_list_title_ad ==null){
                    recruiment_list_title_ad = (LinearLayout) view.findViewById(R.id.recruiment_list_title);
                    recruiment_list_title_ad.setVisibility(View.INVISIBLE);


//                    recruiment_list_title_ad.setVisibility(View.GONE);
//                }else if(firstVisibleItem ==1){
//                    recruiment_list_title.setVisibility(View.INVISIBLE);
//                    recruiment_list_title_ad.setVisibility(View.VISIBLE);
               }else {
                    recruiment_list_title.setVisibility(View.GONE);
                    if(recruiment_list_title_ad!=null){
                        recruitmentAdapter.floatingCollar=false;
                        recruiment_list_title_ad.setVisibility(View.VISIBLE);

                    }

                }

//                recruitmentAdapter.notifyDataSetChanged();

            }
        });

    }

    private LinearLayout recruiment_list_title_ad=null;


    //获取广告图片
    private void initRecruitmentImageData() {
        HttpUtils httpUtils=new HttpUtils();
        httpUtils.send(HttpRequest.HttpMethod.GET, AppUtilsUrl.getRecruitmentImage(), new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String result = responseInfo.result;
                if (result != null) {
                    ArtistParme<RecruitmentImageBean> recruitmentImageBean = JSONObject.parseObject(result, new TypeReference<ArtistParme<RecruitmentImageBean>>() {
                    });
                    if (recruitmentImageBean.getState().equals("success")) {
                        List<RecruitmentImageBean> recruitmentImageData = recruitmentImageBean.getValue();

                        View header = View.inflate(getActivity(), R.layout.recruitment_list_header, null);//头部内容
                        SlideShowView ssv = new SlideShowView(getActivity(),recruitmentImageData);

                        LinearLayout header_ll = (LinearLayout) header.findViewById(R.id.header_ll);
                        header_ll.addView(ssv);

                        LinearLayout.LayoutParams layoutParams= new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, (int)(getResources().getDimension(R.dimen.ssv_height)));
                        layoutParams.setMargins(0, 0, 0, 0);
                        ssv.setLayoutParams(layoutParams);
//                        ImageView recruitment_list_header = (ImageView)header.findViewById(R.id.recruitment_list_header);
//                        tv1.setText(talentData.get(0).getPath());

//                        BitmapUtils bitmapUtils = new BitmapUtils(getActivity());

//                        bitmapUtils.display(recruitment_list_header, "http://www.iclubapps.com/upload/"+recruitmentImageData.get(0).getPath());
                        recruitmentList.addHeaderView(header);//添加头部
                        initRecruitmentListData(0);

                    }

                }


            }

            @Override
            public void onFailure(HttpException e, String s) {

            }
        });


    }

    //获取招聘列表
    public void initRecruitmentListData(int city) {
        HttpUtils httpUtils=new HttpUtils();
        httpUtils.send(HttpRequest.HttpMethod.GET, AppUtilsUrl.getRecruitmentList(city), new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {

                String result = responseInfo.result;
                if (result != null) {
                    ArtistParme<RecruitmentListBean> recruitmentListBean = JSONObject.parseObject(result, new TypeReference<ArtistParme<RecruitmentListBean>>() {
                    });
                    if (recruitmentListBean.getState().equals("success")) {
                        List<RecruitmentListBean> recruitmentListData = recruitmentListBean.getValue();
                        recruitmentAdapter = new RecruitmentListAdapter(recruitmentListData, getActivity());
                        recruitmentList.setAdapter(recruitmentAdapter);
                        recruitmentAdapter.notifyDataSetChanged();

                    }

                }


            }

            @Override
            public void onFailure(HttpException e, String s) {

            }
        });


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
//        super.onActivityResult(requestCode,resultCode,data);
//        switch(requestCode){
//            case RESULT_OK:
   /*取得来自SecondActivity页面的数据，并显示到画面*/
        Bundle bundle = data.getExtras();

         /*获取Bundle中的数据，注意类型和key*/
        int name = bundle.getInt("Name");
        Toast.makeText(getActivity(), name + "", Toast.LENGTH_SHORT).show();
        initRecruitmentListData(name);
//                boolean ismale = bundle.getBoolean("Ismale");
//        }
    }




}
