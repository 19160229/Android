package com.example.tabfragmentdemo;

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

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    View.OnClickListener onClickListener=new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            resetImgs();
        }
    };

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
        mTabWechat.setOnClickListener(onClickListener);
        mTabFriend.setOnClickListener(onClickListener);
        mTabSetting.setOnClickListener(onClickListener);
        mTabContact.setOnClickListener(onClickListener);
    }

    private void initDatas(){
        mFragments=new ArrayList<>();
        mFragments.add(new WechatFragment());
    }

    private void resetImgs(){
        mImgWechat.setImageResource(R.mipmap.tab_weixin);
        mImgFriend.setImageResource(R.mipmap.tab_find_frd);
        mImgContact.setImageResource(R.mipmap.tab_address);
        mImgSetting.setImageResource(R.mipmap.tab_settings);
    }
}
