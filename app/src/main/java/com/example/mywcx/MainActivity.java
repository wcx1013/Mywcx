package com.example.mywcx;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mywcx.adapter.MainViewPagerAdapter;
import com.example.mywcx.base.BaseActivity;
import com.example.mywcx.interfaces.IBasePersenter;
import com.example.mywcx.ui.fragment.HomeFragment;
import com.example.mywcx.ui.fragment.MeFragment;
import com.example.mywcx.ui.fragment.ShopingFragment;
import com.example.mywcx.ui.fragment.SortFragment;
import com.example.mywcx.ui.fragment.TopicFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.toobar)
    Toolbar mToobar;
    @BindView(R.id.viewpager)
    ViewPager mViewpager;
    @BindView(R.id.tablayout)
    TabLayout mTablayout;



    @Override
    protected IBasePersenter createPersenter() {
        return null;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        setSupportActionBar(mToobar);
        MainViewPagerAdapter myViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager(), initFragment());
        mViewpager.setAdapter(myViewPagerAdapter);
        mTablayout.setupWithViewPager(mViewpager);

        for (int i = 0; i <myViewPagerAdapter.getCount() ; i++) {
            TabLayout.Tab tab = mTablayout.getTabAt(i);
            tab.setCustomView(intabview(i));
        }
    }
    private View intabview(int i) {
        View view = View.inflate(this, R.layout.tab_view, null);
        ImageView iv = view.findViewById(R.id.tab_iv);
        TextView tv = view.findViewById(R.id.tab_tv);
        switch (i){
            case 0:
                iv.setImageResource(R.mipmap.home);
                tv.setText("首页");
                break;
            case 1:
                iv.setImageResource(R.mipmap.weicang);
                tv.setText("专题");
                break;
            case 2:
                iv.setImageResource(R.mipmap.menu);
                tv.setText("分类");
                break;
            case 3:
                iv.setImageResource(R.mipmap.cart);
                tv.setText("购物车");
                break;
            case 4:
                iv.setImageResource(R.mipmap.me);
                tv.setText("我的");
                break;
        }
        return view;
    }

    private List<Fragment> initFragment(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        HomeFragment homeFragment = new HomeFragment();
        MeFragment meFragment = new MeFragment();
        ShopingFragment shopingFragment = new ShopingFragment();
        SortFragment sortFragment = new SortFragment();
        TopicFragment topicFragment = new TopicFragment();
        fragments.add(homeFragment);
        fragments.add(topicFragment);
        fragments.add(sortFragment);
        fragments.add(shopingFragment);
        fragments.add(meFragment);
        return fragments;
    }
}
