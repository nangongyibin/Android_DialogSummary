package com.example.dialogsummary;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ngyb.dialogsummary.CustomerDialog;
import com.ngyb.dialogsummary.SelfDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void on(View view) {
//        CustomerDialog customerDialog = new CustomerDialog(this);
//        customerDialog.show();
        SelfDialog selfDialog = new SelfDialog(this);
        selfDialog.setRes(R.drawable.check,"立即提交！！！！");
        selfDialog.show();
    }
}
