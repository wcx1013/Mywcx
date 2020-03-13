package com.example.mywcx.interfaces;


import com.example.mywcx.models.bean.TopicBean;

public interface TopicConstract {
    interface View extends IBaseView {
        void getTopicDataReturn(TopicBean result);
    }

    interface Persenter extends IBasePersenter<View> {
        void getTopicData();
    }
}
