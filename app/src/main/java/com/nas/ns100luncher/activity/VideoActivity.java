package com.nas.ns100luncher.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nas.ns100luncher.R;
import com.nas.ns100luncher.base.BaseActivity;

public class VideoActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
    }

    public static void startAc(Context context) {
        context.startActivity(new Intent(context, VideoActivity.class));
    }

}
