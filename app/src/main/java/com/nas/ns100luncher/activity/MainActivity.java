package com.nas.ns100luncher.activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.Settings;
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
                Intent video = new Intent(Intent.ACTION_GET_CONTENT);
//                intent.setType("*/*");//设置类型，我这里是任意类型，任意后缀的可以这样写。
//              intent.setType("image/*");
//              intent.setType(“audio/*”); //选择音频
                video.setType("video/*"); //选择视频 （mp4 3gp 是android支持的视频格式）
//              intent.setType(“video/*;image/*”);//同时选择视频和图片
                video.addCategory(Intent.CATEGORY_OPENABLE);
                startActivityForResult(video, 1);
//                VideoActivity.startAc(this);
                break;
            case R.id.bt_picture:
                Intent image = new Intent(Intent.ACTION_GET_CONTENT);
//                intent.setType("*/*");//设置类型，我这里是任意类型，任意后缀的可以这样写。
              image.setType("image/*");
//              intent.setType(“audio/*”); //选择音频
//                video.setType("video/*"); //选择视频 （mp4 3gp 是android支持的视频格式）
//              intent.setType(“video/*;image/*”);//同时选择视频和图片
                image.addCategory(Intent.CATEGORY_OPENABLE);
                startActivityForResult(image, 1);
//                PictureActivity.startAc(this);
                break;
            case R.id.bt_folder:
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("*/*");//设置类型，我这里是任意类型，任意后缀的可以这样写。
//              intent.setType("image/*");
//              intent.setType(“audio/*”); //选择音频
//              intent.setType(“video/*”); //选择视频 （mp4 3gp 是android支持的视频格式）
//              intent.setType(“video/*;image/*”);//同时选择视频和图片
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                startActivityForResult(intent, 1);

//                FolderActivity.startAc(this);
                break;
            case R.id.bt_set:
                Intent setIntent = new Intent(Settings.ACTION_SETTINGS);
                startActivity(setIntent);
//                SetActivity.startAc(this);
                break;
            case R.id.bt_more:
                MoreActivity.startAc(this);
                break;
        }
    }

}
