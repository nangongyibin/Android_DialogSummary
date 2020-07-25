package com.ngyb.dialogsummary;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/7/25 16:22
 */
public class SelfDialog extends Dialog {
    private static final String TAG = "SelfDialog";
    private Button yes; // 确定按钮
    private onYesOnClickListener yesOnClickListener;
    private String str = "";
    private int drawable = R.drawable.check;
    private ImageView iv;
    private TextView message;

    public SelfDialog(@NonNull Context context) {
        super(context, R.style.NgybDialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_layout);
//        按空白处不能取消动画
        setCanceledOnTouchOutside(false);
//        初始化界面控件
        initView();
//        初始化界面控件的事件
        initData();
        initEvent();
    }

    /**
     * 初始化界面的确定和取消监听器
     */
    private void initEvent() {
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (yesOnClickListener != null) {
                    yesOnClickListener.onYesClick();
                }
            }
        });
    }

    private void initData() {
        if (message != null && str != null) {
            message.setText(str);
        }
        if (iv != null) {
            iv.setImageResource(drawable);
        }
    }

    private void initView() {
        yes = findViewById(R.id.btn);
        iv = findViewById(R.id.iv);
        message = findViewById(R.id.message);
    }

    public void setRes(int drawable, String str) {
        this.drawable = drawable;
        this.str = str;
    }

    /**
     * 设置确定按钮和取消被点击的接口
     */
    public interface onYesOnClickListener {
        public void onYesClick();
    }

    /**
     * 设置确定按钮的显示内容和监听
     *
     * @param onYesOnClickListener
     */
    public void setYesOnClickListener(onYesOnClickListener onYesOnClickListener) {
        this.yesOnClickListener = onYesOnClickListener;
    }
}
