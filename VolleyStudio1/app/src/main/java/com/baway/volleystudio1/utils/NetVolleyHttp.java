package com.baway.volleystudio1.utils;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

/**
 * @Auther: 付尚凯
 * @Date: 2019.4.16 19:04:55
 * @Description:
 * @Email: 2024468244@qq.com
 */
public class NetVolleyHttp {
    private static final NetVolleyHttp ourInstance = new NetVolleyHttp();

    public static NetVolleyHttp getInstance() {
        return ourInstance;
    }

    private NetVolleyHttp() {
    }

    //get请求
    public void volleyHttpGet(String url, final Volleycallback volleycallback) {
        StringRequest getRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                volleycallback.volleySuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                volleycallback.volleyError(error);
            }
        });
        //设置tag标签
        getRequest.setTag("testget");
        //将请求加入请求队列
        MyApplication.requestQueue().add(getRequest);


    }

    //定义接口
    public interface Volleycallback {
        void volleySuccess(String result);

        void volleyError(VolleyError error);
    }

}
