package com.example.achuan.mvp_study.contract;

import com.example.achuan.mvp_study.base.BaseView;
import com.example.achuan.mvp_study.model.bean.WindBean;

/**
 * Created by achuan on 16-9-29.
 * 功能：展示各个层要实现的方法,声明回调接口
 * 一般至装view和presenter层的方法
 */
public interface FirstContract {
    //view层要实现的抽象方法
    interface View extends BaseView{
        void showData(WindBean windBean);
        void showProgress();
        void hideProgress();
    }
    //Presenter层要实现的抽象方法
     interface Presenter{
        void loadData();
    }
    //Model层要实现的抽象方法
     interface Model{
    }
}