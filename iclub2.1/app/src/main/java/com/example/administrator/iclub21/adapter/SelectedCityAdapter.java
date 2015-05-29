package com.example.administrator.iclub21.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.iclub21.R;
import com.example.administrator.iclub21.bean.AreaBean;

/**
 * Created by Administrator on 2015/5/27.
 */
public class SelectedCityAdapter extends BaseAdapter{

    private Context mContext;
    private ViewHodle viewHodle;
    private AreaBean areaBean = new AreaBean();
    private LayoutInflater mInflater;

    public SelectedCityAdapter(Context context) {
        this.mInflater = LayoutInflater.from(context);
        mContext = context;
    }

    @Override
    public int getCount() {
        return 34;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.city_list_layout,null);
            viewHodle = new ViewHodle();

            viewHodle.province_tv = (TextView) convertView.findViewById(R.id.province_tv);
//            holder.text = (TextView) convertView.findViewById(R.id.ItemText);
//            holder.bt = (Button) convertView.findViewById(R.id.ItemButton);
            convertView.setTag(viewHodle);
        }
        else{
            viewHodle = (ViewHodle)convertView.getTag();
        }
        String s = areaBean.getArea(mContext,position);
        viewHodle.province_tv.setText(s);

        return convertView;
    }

    public class ViewHodle{
        private TextView province_tv;

    }
}
