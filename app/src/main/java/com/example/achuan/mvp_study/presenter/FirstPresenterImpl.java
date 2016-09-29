package com.example.achuan.mvp_study.presenter;
import com.example.achuan.mvp_study.base.BasePresenter;
import com.example.achuan.mvp_study.contract.FirstContract;
import com.example.achuan.mvp_study.model.FirstModelImpl;
import com.example.achuan.mvp_study.model.bean.WindBean;
import com.example.achuan.mvp_study.model.http.AsyncHttpUtil;
import com.example.achuan.mvp_study.model.http.OnRequestListener;

/**
* Created by MVPHelper on 2016/09/29
 * 功能：Presenter层实现对view层和model层的连接操作
*/
public class FirstPresenterImpl extends BasePresenter<FirstContract.View> implements FirstContract.Presenter{

    private FirstContract.View mView;//view接口角色
    //Model层接口角色
    private FirstContract.Model mModel=new FirstModelImpl();

    public FirstPresenterImpl(FirstContract.View view) {
        mView = view;
    }

    //加载数据的方法,也就是我们的业务逻辑
    @Override
    public void loadData() {
        mView.showProgress();
        final String address="http://www.weather.com.cn/adat/sk/101010100.html";
        AsyncHttpUtil.sendHttpRequest(address, new OnRequestListener() {
            @Override
            public void onFinish(WindBean windBean) {
                //通过presenter层将model层获得的数据传递给view层
                mView.showData(windBean);
                mView.hideProgress();
            }
            @Override
            public void onError(Throwable throwable) {
            }
        });
    }
}