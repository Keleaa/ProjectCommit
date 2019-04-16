package com.baway.volleystudio1.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * @Auther: 付尚凯
 * @Date: 2019.4.16 19:17:47
 * @Description:
 * @Email: 2024468244@qq.com
 */
public class NetIsConnect {
    public static boolean isconnect(Context context) {
        if (context != null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isAvailable();
            }
        }
        return false;
    }
}
