package com.example.administrator.iclub21.util;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.administrator.iclub21.R;
import com.example.administrator.iclub21.adapter.SelectedCityAdapter;

/**
 * Created by Administrator on 2015/5/27.
 */
public class SelectedCityActivity extends ActionBarActivity {

    private ListView selecte_city_lv;
    private SelectedCityAdapter scAdaper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        init();
    }

    private void init() {
        scAdaper = new SelectedCityAdapter(this);
        selecte_city_lv = (ListView)findViewById(R.id.selecte_city_lv);
        selecte_city_lv.setAdapter(scAdaper);
        scAdaper.notifyDataSetChanged();

        selecte_city_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 5){

                }
            }
        });


    }

}
