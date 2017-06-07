package com.yang.user.mynewsdemo.ui.fragment;import android.os.Bundle;import android.support.annotation.Nullable;import android.support.design.widget.TabLayout;import android.support.v4.app.Fragment;import android.support.v4.view.ViewPager;import android.view.LayoutInflater;import android.view.View;import android.view.ViewGroup;import com.yang.user.mynewsdemo.R;import com.yang.user.mynewsdemo.ui.adapter.PagerAdaper;import com.yang.user.mynewsdemo.ui.adapter.ZhihuMainAdapter;import com.yang.user.mynewsdemo.ui.fragment.tabfragment.DailyFragment;import com.yang.user.mynewsdemo.ui.fragment.tabfragment.HotFragment;import com.yang.user.mynewsdemo.ui.fragment.tabfragment.SectionFragment;import com.yang.user.mynewsdemo.ui.fragment.tabfragment.ThemeFragment;import java.util.ArrayList;import java.util.List;import butterknife.BindView;import butterknife.ButterKnife;/** * Create By */public class ZhihuMainFragment extends Fragment {    @BindView(R.id.tab_zhihu_main)    TabLayout mTabLayout;    @BindView(R.id.vp_zhihu_main)    ViewPager mViewPager;    String[] tabTitle = new String[]{"日报", "主题", "专栏", "热门"};    List<Fragment> fragments = new ArrayList<Fragment>();    ZhihuMainAdapter mAdapter;    private View view;    @Nullable    @Override    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {        view = inflater.inflate(R.layout.fragment_zhihu, container, false);        ButterKnife.bind(this, view);//        initView();        initData();        return view;    }    private void initData() {        fragments.add(new DailyFragment());        fragments.add(new ThemeFragment());        fragments.add(new SectionFragment());        fragments.add(new HotFragment());        mAdapter = new ZhihuMainAdapter(getChildFragmentManager(), fragments);        mViewPager.setAdapter(mAdapter);        //TabLayout配合ViewPager有时会出现不显示Tab文字的Bug,需要按如下顺序        mTabLayout.addTab(mTabLayout.newTab().setText(tabTitle[0]));        mTabLayout.addTab(mTabLayout.newTab().setText(tabTitle[1]));        mTabLayout.addTab(mTabLayout.newTab().setText(tabTitle[2]));        mTabLayout.addTab(mTabLayout.newTab().setText(tabTitle[3]));        mTabLayout.setupWithViewPager(mViewPager);        mTabLayout.getTabAt(0).setText(tabTitle[0]);        mTabLayout.getTabAt(1).setText(tabTitle[1]);        mTabLayout.getTabAt(2).setText(tabTitle[2]);        mTabLayout.getTabAt(3).setText(tabTitle[3]);    }    private void initView() {        mViewPager.setAdapter(new PagerAdaper(getActivity().getSupportFragmentManager()));        /**让标题栏和viewpager联动起来*/        mTabLayout.setupWithViewPager(mViewPager);    }}