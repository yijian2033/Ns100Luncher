package com.nas.ns100luncher.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.nas.ns100luncher.R;
import com.nas.ns100luncher.base.BaseActivity;
import com.nas.ns100luncher.manager.ZxingHelper;
import com.nas.ns100luncher.utils.AppUtil;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private ImageView mIvTwoCode;
    private TextView mTvIp;
    private TextView mTvId;
    private AppUtil appUtil;
    private ImageButton mBtVideo;
    private ImageButton mBtPicture, mBtFolder, mBtSet, mBtMore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initListener();
    }

    private void initListener() {
        mBtVideo.setOnClickListener(this);
        mBtPicture.setOnClickListener(this);
        mBtFolder.setOnClickListener(this);
        mBtSet.setOnClickListener(this);
        mBtMore.setOnClickListener(this);
    }

    private void initView() {
        mIvTwoCode = (ImageView) findViewById(R.id.iv_twoCode);
        mTvIp = (TextView) findViewById(R.id.tv_ip);
        mTvId = (TextView) findViewById(R.id.tv_id);

        mBtVideo = (ImageButton) findViewById(R.id.bt_video);
        mBtPicture = (ImageButton) findViewById(R.id.bt_picture);
        mBtFolder = (ImageButton) findViewById(R.id.bt_folder);
        mBtSet = (ImageButton) findViewById(R.id.bt_set);
        mBtMore = (ImageButton) findViewById(R.id.bt_more);

    }

    private void initData() {
        //获取ip地址
        appUtil = AppUtil.getInstance(getApplicationContext());
        String hostIp = appUtil.getHostIp();
        String deviceId = appUtil.getDeviceId();
        Bitmap bitmap = ZxingHelper.getInstance().encodeAsBitmap(hostIp);

        mIvTwoCode.setImageBitmap(bitmap);
        mTvIp.setText("IP:" + hostIp);
//        mTvId.setText("ID:" + deviceId);
        mTvId.setText("ID:000001");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_video:
                VideoActivity.startAc(this);
                break;
            case R.id.bt_picture:
                PictureActivity.startAc(this);
                break;
            case R.id.bt_folder:
                FolderActivity.startAc(this);
                break;
            case R.id.bt_set:
                SetActivity.startAc(this);
                break;
            case R.id.bt_more:
                MoreActivity.startAc(this);
                break;
        }
    }

}
