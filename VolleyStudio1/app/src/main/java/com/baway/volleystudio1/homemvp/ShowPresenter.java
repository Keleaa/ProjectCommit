package com.baway.volleystudio1.homemvp;

/**
 * @Auther: 付尚凯
 * @Date: 2019.4.16 18:48:13
 * @Description:
 * @Email: 2024468244@qq.com
 */
public class ShowPresenter implements Contract.IShowPresenter {

    private ShowModel showModel;
    private Contract.IShowVIew ishowview;

    @Override
    public void attach(Contract.IShowVIew iShowVIew) {
        showModel = new ShowModel();
        this.ishowview = iShowVIew;
    }

    @Override
    public void mutual(String url) {
        showModel.loaddata(url, new Contract.IShowModel.ModelCallBack() {
            @Override
            public void ModelSuccess(String result) {
                ishowview.ResultData(result);
            }

            @Override
            public void ModelError() {

            }
        });

    }

    @Override
    public void detach() {
        if (ishowview != null) {
            ishowview = null;
        }
        if (showModel != null) {
            showModel = null;
        }
        System.gc();
    }
}
