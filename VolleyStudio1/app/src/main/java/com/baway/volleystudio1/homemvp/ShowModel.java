package com.baway.volleystudio1.homemvp;


import com.android.volley.VolleyError;
import com.baway.volleystudio1.utils.NetVolleyHttp;

/**
 * @Auther: 付尚凯
 * @Date: 2019.4.16 18:47:37
 * @Description:
 * @Email: 2024468244@qq.com
 */
public class ShowModel implements Contract.IShowModel {
    @Override
    public void loaddata(String url, final ModelCallBack modelCallBack) {
        //请求数据
        NetVolleyHttp.getInstance().volleyHttpGet(url, new NetVolleyHttp.Volleycallback() {
            @Override
            public void volleySuccess(String result) {
                modelCallBack.ModelSuccess(result);
            }

            @Override
            public void volleyError(VolleyError error) {
                modelCallBack.ModelError();
            }
        });

    }
}
