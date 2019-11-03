package com.ngyb.dialogsummary.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ngyb.dialogsummary.CustomerDialog;
import com.ngyb.dialogsummary.R;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2019/11/3 20:00
 */
public class MyAdapter extends BaseAdapter {
    private CustomerDialog customerDialog;
    public int[] drawables = new int[]{R.drawable.shape_alpha_style,R.drawable.shape_orange_style,R.drawable.shape_blue_style,
    R.drawable.shape_gray_style,R.drawable.shape_green_style};
    public String[] title = new String[]{"半透明", "活力橙", "卫士蓝", "金属灰", "苹果绿"};
    private Context context;

    public MyAdapter(Context context, CustomerDialog customerDialog) {
        this.context = context;
        this.customerDialog = customerDialog;
    }

    @Override
    public int getCount() {
        return title.length;
    }

    @Override
    public String getItem(int position) {
        return title[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_dialog_style, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tvStyle.setText(title[position]);
        viewHolder.ivStyleColor.setBackgroundResource(drawables[position]);
        if (position == customerDialog.currentPosition) {
            viewHolder.ivSelected.setVisibility(View.VISIBLE);
        } else {
            viewHolder.ivSelected.setVisibility(View.GONE);
        }
        return convertView;
    }

    class ViewHolder {

        private final ImageView ivSelected;
        private final ImageView ivStyleColor;
        private final TextView tvStyle;

        public ViewHolder(View view) {
            ivSelected = view.findViewById(R.id.iv_selected);
            ivStyleColor = view.findViewById(R.id.iv_style_color);
            tvStyle = view.findViewById(R.id.tv_style);
        }
    }
}
