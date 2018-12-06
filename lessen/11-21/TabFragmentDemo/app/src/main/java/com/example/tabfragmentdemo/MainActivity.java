package com.example.tabfragmentdemo;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        FriendFragment.OnFragmentInteractionListener,ContactFragment.OnFragmentInteractionListener
        ,SettingFragment.OnFragmentInteractionListener {

    private ViewPager mViewPager;
    private FragmentPagerAdapter mAdapter;
    private List<Fragment> mFragments;

    private LinearLayout mTabWechat;
    private LinearLayout mTabFriend;
    private LinearLayout mTabContact;
    private LinearLayout mTabSetting;

    private ImageButton mImgWechat;
    private ImageButton mImgFriend;
    private ImageButton mImgContact;
    private ImageButton mImgSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initEvents();
        initDatas();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
    }

    @Override
    public void onClick(View v) {
        resetImgs();
        switch (v.getId()){
            case R.id.id_tab_wechat:
                selectTab(0);
                break;
            case R.id.id_tab_friend:
                selectTab(1);
                break;
            case R.id.id_tab_contact:
                selectTab(2);
                break;
            case R.id.id_tab_setting:
                selectTab(3);
                break;
        }
    }

    private void initViews(){
        mViewPager=(ViewPager)findViewById(R.id.id_viewpager);
        mTabWechat=(LinearLayout)findViewById(R.id.id_tab_wechat);
        mTabFriend=(LinearLayout)findViewById(R.id.id_tab_friend);
        mTabContact=(LinearLayout)findViewById(R.id.id_tab_contact);
        mTabSetting=(LinearLayout)findViewById(R.id.id_tab_setting);
        mImgWechat=(ImageButton)findViewById(R.id.id_tab_wechat_img);
        mImgFriend=(ImageButton)findViewById(R.id.id_tab_friend_img);
        mImgContact=(ImageButton)findViewById(R.id.id_tab_contact_img);
        mImgSetting=(ImageButton)findViewById(R.id.id_tab_setting_img);
    }

    private void initEvents(){
        mTabWechat.setOnClickListener(this);
        mTabFriend.setOnClickListener(this);
        mTabSetting.setOnClickListener(this);
        mTabContact.setOnClickListener(this);
    }

    private void initDatas(){
        mFragments=new ArrayList<>();
        mFragments.add(new WechatFragment());
        mFragments.add(new FriendFragment());
        mFragments.add(new ContactFragment());
        mFragments.add(new SettingFragment());

        mAdapter=new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return mFragments.get(i);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }
        };

        mViewPager.setAdapter(mAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                mViewPager.setCurrentItem(i);
                resetImgs();
                selectTab(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    private void selectTab(int i){
        switch (i){
            case 0:
                mImgWechat.setImageResource(R.mipmap.tab_weixin);
                break;
            case 1:
                mImgFriend.setImageResource(R.mipmap.tab_find_frd);
                break;
            case 2:
                mImgContact.setImageResource(R.mipmap.tab_address);
                break;
            case 3:
                mImgContact.setImageResource(R.mipmap.tab_settings);
                break;
        }
        mViewPager.setCurrentItem(i);
    }

    private void resetImgs(){
        mImgWechat.setImageResource(R.mipmap.tab_weixin);
        mImgFriend.setImageResource(R.mipmap.tab_find_frd);
        mImgContact.setImageResource(R.mipmap.tab_address);
        mImgSetting.setImageResource(R.mipmap.tab_settings);
    }
}
