package com.example.administrator.iclub21.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.administrator.iclub21.R;
import com.example.administrator.iclub21.bean.recruitment.RecruitmentListBean;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2015/5/26.
 */
public class RecruitmentListAdapter extends AppBaseAdapter<RecruitmentListBean> {
    private ViewHodle viewHodle;
    public RecruitmentListAdapter(List<RecruitmentListBean> data, Context context) {
        super(data, context);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return data.size()+1;
    }

    @Override
    public View createView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.recruitment_list_layout, parent, false);
                viewHodle = new ViewHodle(convertView);
                convertView.setTag(viewHodle);
            } else {
                viewHodle = (ViewHodle) convertView.getTag();
            }
        if(position==0) {

            viewHodle.recruiment_list_title.setVisibility(View.VISIBLE);
            viewHodle.recruitment_list_ll.setVisibility(View.GONE);

        }else{
            viewHodle.recruiment_list_title.setVisibility(View.GONE);
            viewHodle.recruitment_list_ll.setVisibility(View.VISIBLE);
            init(position-1);
        }

        return convertView;
    }

    private void init(int position) {

        String pattern=" ";
        Pattern pat=Pattern.compile(pattern);
        final String[] rs = pat.split(data.get(position).getPuttime());

        viewHodle.recruitment_position.setText(data.get(position).getPosition());
        viewHodle.recruitment_puttime.setText(rs[0]);
        viewHodle.recruitment_companyName.setText(data.get(position).getCompanyName());
        if(data.get(position).getLabel().equals("")) viewHodle.recruitment_label.setVisibility(View.INVISIBLE);
        viewHodle.recruitment_workPlace.setText(data.get(position).getWorkPlace());
        viewHodle.recruitment_star.setRating(data.get(position).getStar());

    }

    public class ViewHodle{
        @ViewInject(R.id.recruitment_position)
        private TextView recruitment_position;
        @ViewInject(R.id.recruitment_puttime)
        private TextView recruitment_puttime;
        @ViewInject(R.id.recruitment_companyName)
        private TextView recruitment_companyName;
        @ViewInject(R.id.recruitment_label)
        private TextView recruitment_label;
        @ViewInject(R.id.recruitment_workPlace)
        private TextView recruitment_workPlace;
        @ViewInject(R.id.recruitment_star)
        private RatingBar recruitment_star;
        @ViewInject(R.id.recruiment_list_title)
        private LinearLayout recruiment_list_title;
        @ViewInject(R.id.recruitment_list_ll)
        private LinearLayout recruitment_list_ll;

        public ViewHodle(View view) {
            super();
            ViewUtils.inject(this, view);
        }
    }
}
