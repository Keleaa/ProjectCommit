package com.baway.volleystudio1.homemvp;

/**
 * @Auther: 付尚凯
 * @Date: 2019.4.16 18:43:22
 * @Description: 契约接口类
 * @Email: 2024468244@qq.com
 */
public interface Contract {

    //view层接口
    public interface IShowVIew {
        void ResultData(String resultdata);
    }

    //model层接口
    public interface IShowModel {
        void loaddata(String url, ModelCallBack modelCallBack);

        interface ModelCallBack {
            void ModelSuccess(String result);

            void ModelError();
        }
    }

    //presenter层接口
    public interface IShowPresenter {
        void attach(IShowVIew iShowVIew);

        void mutual(String url);

        void detach();
    }

}
