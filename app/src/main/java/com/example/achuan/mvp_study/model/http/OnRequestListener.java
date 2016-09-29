package com.example.achuan.mvp_study.model.http;

import com.example.achuan.mvp_study.model.bean.WindBean;

/**
 * Created by achuan on 16-9-29.
 *功能：使用接口来回调服务返回的结果
 */
public interface OnRequestListener {
    void onFinish(WindBean windBean);
    void onError(Throwable throwable);
}
