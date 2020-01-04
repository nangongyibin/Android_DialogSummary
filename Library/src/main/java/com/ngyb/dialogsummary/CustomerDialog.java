package com.ngyb.dialogsummary;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ngyb.dialogsummary.adapter.MyAdapter;
import com.ngyb.dialogsummary.constant.Constant;
import com.ngyb.utils.SharedPreferencesUtils;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2019/11/3 18:19
 */
public class CustomerDialog extends Dialog {

    private ListView lvDialogStyle;
    private SharedPreferencesUtils sharedPreferencesUtils;
    private MyAdapter myAdapter;
    public int currentPosition;

    public CustomerDialog(@NonNull Context context) {
        super(context);
        Window window = getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        params.gravity = Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL;
        window.setAttributes(params);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_customer_dialog);
        init();
    }

    private void init() {
        initView();
        initClass();
        initAdapter();
        initToast();
        initListener();
    }

    private void initListener() {
        lvDialogStyle.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                currentPosition = position;
                myAdapter.notifyDataSetChanged();
                sharedPreferencesUtils.setInt(Constant.TOAST_STYLE_COLOR, myAdapter.drawables[position]);
                dismiss();
            }
        });
    }

    private void initToast() {
        int drawableId = sharedPreferencesUtils.getInt(Constant.TOAST_STYLE_COLOR, myAdapter.drawables[0]);
        for (int i = 0; i < myAdapter.drawables.length; i++) {
            if (myAdapter.drawables[i] == drawableId) {
                currentPosition = i;
                break;
            }
        }
    }

    private void initAdapter() {
        myAdapter = new MyAdapter(getContext(), this);
        lvDialogStyle.setAdapter(myAdapter);
    }

    private void initClass() {
        sharedPreferencesUtils = new SharedPreferencesUtils(getContext());
    }

    private void initView() {
        lvDialogStyle = findViewById(R.id.lv_dialog_style);
    }
}
