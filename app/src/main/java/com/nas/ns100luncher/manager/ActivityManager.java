package com.nas.ns100luncher.manager;

import android.app.Activity;

import java.util.ArrayList;

/**
 * Activity的管理类，增加或者结束一个或者全部
 */

public class ActivityManager {

    public static ArrayList<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    public static void finishAll() {
        if (activities.size() > 0) {
            for (Activity activity : activities) {
                if (!activity.isFinishing()) {
                    activity.finish();
                }
            }
            activities.clear();
        }
    }

}
