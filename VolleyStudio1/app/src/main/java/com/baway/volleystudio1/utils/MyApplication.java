package com.baway.volleystudio1.utils;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * @Auther: 付尚凯
 * @Date: 2019.4.16 19:01:08
 * @Description:
 * @Email: 2024468244@qq.com
 */
public class MyApplication extends Application {

    private static RequestQueue requestQueue;

    @Override
    public void onCreate() {
        super.onCreate();
        requestQueue = Volley.newRequestQueue(getApplicationContext());
    }

    public static RequestQueue requestQueue() {
        return requestQueue;
    }

}
