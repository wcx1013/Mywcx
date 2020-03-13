package com.example.mywcx.ui.fragment;

import com.example.mywcx.R;
import com.example.mywcx.adapter.TopicAdapter;
import com.example.mywcx.base.BaseFragment;
import com.example.mywcx.interfaces.TopicConstract;
import com.example.mywcx.models.bean.TopicBean;
import com.example.mywcx.persenter.TopicPersenter;

import java.util.ArrayList;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class TopicFragment extends BaseFragment<TopicConstract.Persenter> implements TopicConstract.View {
    private RecyclerView mTopic_recy;
    private ArrayList<TopicBean.DataBean.TopicListBean> topicBean;
    private TopicAdapter topicAdapter;
    @Override
    protected int getLayout() {
        return R.layout.fragment_topic;

    }

    @Override
    protected void initView() {
        mTopic_recy = getView().findViewById(R.id.topic_recy);
        topicBean = new ArrayList<>();
        topicAdapter = new TopicAdapter(topicBean, context);
        mTopic_recy.setLayoutManager(new LinearLayoutManager(getContext()));
        mTopic_recy.setAdapter(topicAdapter);
    }

    @Override
    protected void initData() {
        persenter.getTopicData();
    }

    @Override
    protected TopicConstract.Persenter createPersenter() {
        return new TopicPersenter();
    }

    @Override
    public void getTopicDataReturn(TopicBean result) {
        topicAdapter.updata(result.getData().getTopicList());
    }
}
