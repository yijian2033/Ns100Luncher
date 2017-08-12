package com.nas.ns100luncher.utils;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.support.annotation.VisibleForTesting;

/**
 * Created by yijian2033 on 2017/8/12.
 */

public class AppUtil {

    private static AppUtil instance = null;
    private Context mContext;
    private final WifiManager mWifiManager;

    private AppUtil(Context context) {
        this.mContext = context;
        mWifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
    }

    public static AppUtil getInstance(Context context) {
        if (instance == null) {
            instance = new AppUtil(context);
        }
        return instance;
    }

    /**
     * 获取版本号
     *
     * @return
     */
    public String getDeviceId() {
        String display = Build.DISPLAY;
        return display;
    }

    /**
     * 获取连接的wifiip地址
     * 如果为空表示wifi没有连接
     *
     * @return
     */
    public String getHostIp() {
        boolean wifiEnabled = mWifiManager.isWifiEnabled();
        if (!wifiEnabled) {
            mWifiManager.setWifiEnabled(true);
        }
        WifiInfo info = mWifiManager.getConnectionInfo();
        int ipAddress = info.getIpAddress();
        String ip = intToIp(ipAddress);
        return ip;
    }

    /**
     * 讲int数据转换为String类型的ip
     *
     * @param i
     * @return
     */
    private String intToIp(int i) {
        return (i & 0xFF) + "." +
                ((i >> 8) & 0xFF) + "." +
                ((i >> 16) & 0xFF) + "." +
                (i >> 24 & 0xFF);
    }
}
