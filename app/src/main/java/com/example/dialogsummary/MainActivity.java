package com.example.dialogsummary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.ngyb.dialogsummary.CustomerDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void on(View view) {
        CustomerDialog customerDialog = new CustomerDialog(this);
        customerDialog.show();
    }
}
