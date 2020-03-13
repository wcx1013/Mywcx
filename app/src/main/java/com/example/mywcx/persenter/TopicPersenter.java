package com.example.mywcx.persenter;


import com.example.mywcx.base.BasePersenter;
import com.example.mywcx.common.CommonSubscriber;
import com.example.mywcx.interfaces.TopicConstract;
import com.example.mywcx.models.HttpManager;
import com.example.mywcx.models.bean.TopicBean;
import com.example.mywcx.utils.RxUtils;

public class TopicPersenter extends BasePersenter<TopicConstract.View> implements TopicConstract.Persenter {
    @Override
    public void getTopicData() {
        addSubscribe(HttpManager.getInstance().getShopApi().getTopicData()
                .compose(RxUtils.<TopicBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<TopicBean>(mView){

                    @Override
                    public void onNext(TopicBean topicBean) {
                        mView.getTopicDataReturn(topicBean);
                    }
                }));
    }
}
