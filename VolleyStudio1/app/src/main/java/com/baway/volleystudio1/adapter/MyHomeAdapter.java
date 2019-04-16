package com.baway.volleystudio1.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baway.volleystudio1.R;
import com.baway.volleystudio1.bean.HoneBean;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * @Auther: 付尚凯
 * @Date: 2019.4.16 09:02:32
 * @Description:
 * @Email: 2024468244@qq.com
 */
public class MyHomeAdapter extends BaseAdapter {
    private Context context;
    private List<HoneBean.ResultBean> result;

    public MyHomeAdapter(Context context, List<HoneBean.ResultBean> resultBeanList) {
        this.context = context;
        this.result = resultBeanList;
    }

    @Override
    public int getCount() {
        return result == null ? null : result.size();
    }

    @Override
    public Object getItem(int position) {
        return result.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = View.inflate(context, R.layout.grid_item, null);
            viewHolder.imageView = convertView.findViewById(R.id.img);
            viewHolder.title = convertView.findViewById(R.id.infotitle);
            viewHolder.price = convertView.findViewById(R.id.price);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Glide.with(context).load(result.get(position).getMasterPic()).into(viewHolder.imageView);
        viewHolder.title.setText(result.get(position).getCommodityName());
        viewHolder.price.setText(result.get(position).getPrice() + "");

        return convertView;
    }

    class ViewHolder {
        private ImageView imageView;
        private TextView title;
        private TextView price;
    }

}
