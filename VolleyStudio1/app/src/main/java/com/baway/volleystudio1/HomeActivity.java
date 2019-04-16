package com.baway.volleystudio1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.baway.volleystudio1.adapter.MyHomeAdapter;
import com.baway.volleystudio1.bean.HoneBean;
import com.baway.volleystudio1.homemvp.Contract;
import com.baway.volleystudio1.homemvp.ShowPresenter;
import com.baway.volleystudio1.utils.NetIsConnect;
import com.google.gson.Gson;

import java.util.List;

public class HomeActivity extends AppCompatActivity implements Contract.IShowVIew {

    private GridView gridview;
    private ShowPresenter showPresenter;
    private String home_url = "http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?&page=1&count=30&keyword=%E7%94%B7%E9%9E%8B";
    private static final String TAG = "HomeActivity";
    private List<HoneBean.ResultBean> resultBeanList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        gridview = findViewById(R.id.gv);

        boolean isconnect = NetIsConnect.isconnect(HomeActivity.this);
        if (isconnect) {
            showPresenter = new ShowPresenter();
            showPresenter.attach(HomeActivity.this);

            showPresenter.mutual(home_url);
            Toast.makeText(HomeActivity.this, "网络正常", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(HomeActivity.this, "网络错误", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void ResultData(String resultdata) {
        Gson gson = new Gson();
        HoneBean honeBean = gson.fromJson(resultdata, HoneBean.class);
        resultBeanList = honeBean.getResult();
        MyHomeAdapter myHomeAdapter = new MyHomeAdapter(HomeActivity.this, resultBeanList);
        gridview.setAdapter(myHomeAdapter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
        showPresenter.detach();
        showPresenter = null;
    }
}
