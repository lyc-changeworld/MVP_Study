package com.example.achuan.mvp_study.model.http;

import com.example.achuan.mvp_study.model.bean.WindBean;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by achuan on 16-9-29.
 * 功能：网络请求的封装
 */
public class AsyncHttpUtil {

    public static void sendHttpRequest(final String address,final OnRequestListener listener){
        AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
        asyncHttpClient.get(address, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                try {
                    WindBean mainModelBean = new WindBean();
                    JSONObject weatherinfo = response.getJSONObject("weatherinfo");
                    mainModelBean.setCity(weatherinfo.getString("city"));
                    mainModelBean.setWd(weatherinfo.getString("WD"));
                    mainModelBean.setWs(weatherinfo.getString("WS"));
                    mainModelBean.setTime(weatherinfo.getString("time"));
                    //注册回调方法
                    if(listener!=null)
                    {
                        listener.onFinish(mainModelBean);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                if(listener!=null)
                {
                    listener.onError(throwable);
                }
            }
        });
    }
}
