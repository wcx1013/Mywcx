package com.example.mywcx.models.api;

import com.example.mywcx.models.bean.TopicBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface ShopApi {
    @GET("index")
    Flowable<TopicBean> getTopicData();
}
