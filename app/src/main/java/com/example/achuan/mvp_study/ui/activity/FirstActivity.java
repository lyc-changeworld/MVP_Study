package com.example.achuan.mvp_study.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.achuan.mvp_study.R;
import com.example.achuan.mvp_study.base.MVPBaseActivity;
import com.example.achuan.mvp_study.contract.FirstContract;
import com.example.achuan.mvp_study.model.bean.WindBean;
import com.example.achuan.mvp_study.presenter.FirstPresenterImpl;

import butterknife.BindView;
/**
 * Created by achuan on 2016/09/29
 * 功能：对presenter发号示令,令其对model和view层进行数据的交互和刷新
 * 本身也充当view层的显示效果
 */
public class FirstActivity extends MVPBaseActivity<FirstContract.View, FirstPresenterImpl> implements FirstContract.View {

    @BindView(R.id.my_tv)
    TextView mMyTv;
    @BindView(R.id.my_pr)
    ProgressBar mMyPr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected FirstPresenterImpl createPresenter() {
        return new FirstPresenterImpl(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initEventAndData() {
        mPresenter.loadData();//加载网络数据
    }


    @Override
    public void showData(WindBean windBean) {
        String showData = "城市：" + windBean.getCity()
                + "\n风向：" + windBean.getWd()
                + "\n风级：" + windBean.getWs()
                + "\n发布时间：" + windBean.getTime();
        mMyTv.setText(showData);
    }
    @Override
    public void showProgress() {
        mMyPr.setVisibility(View.VISIBLE);
    }
    @Override
    public void hideProgress() {
        mMyPr.setVisibility(View.GONE);
    }

    @Override
    public void showError(String msg) {

    }
}
