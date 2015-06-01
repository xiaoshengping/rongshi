package com.example.administrator.iclub21.util;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.iclub21.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

public class ResumeActivity extends ActionBarActivity implements View.OnClickListener {

    @ViewInject(R.id.add_resume_tv)
    private TextView addResumeTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume);
        ViewUtils.inject(this);
        inti();

    }

    private void inti() {
        intiView();

    }

    private void intiView() {
        addResumeTv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_resume_tv:
                addResumeTv.setVisibility(View.GONE);
                break;

        }
    }
}
