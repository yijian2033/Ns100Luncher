package com.nas.ns100luncher.activity;

import android.app.Activity;


/**
 * 视频播放器
 */
public class PlayerActivity extends Activity{
//    private CustomVideoView videoVv;
//    private int lastPlayedTime;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_palyer);
//        App.get().addActivity(this);
//
//        videoVv = (CustomVideoView)findViewById(R.id.vv_player_video);
//        MediaController controller= new MediaController(this);
//        videoVv.setMediaController(controller);
//
//        Uri uri = getIntent().getData(); // Uri.parse(item.path) intent.getStringExtra("path");
//        videoVv.setVideoPath(uri.getPath());
//        lastPlayedTime = 0;
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        videoVv.getHolder().setFixedSize(videoVv.getWidth(), videoVv.getHeight());
//        videoVv.start();
//        if(lastPlayedTime > 0) {
//            videoVv.seekTo(lastPlayedTime);
//        }
//    }
//
//    @Override
//    protected void onPause() {
//        videoVv.pause();
//        lastPlayedTime = videoVv.getCurrentPosition();
//        super.onPause();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        finish(); // 退出Activity
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//    }
//
////    public boolean onKeyDown(int keyCode, KeyEvent event) {
////        if (keyCode == KeyEvent.KEYCODE_BACK) {
////            finish();
////            return true;
////        }
////        return super.onKeyDown(keyCode, event);
////    }

}
