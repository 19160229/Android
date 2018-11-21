package com.example.simplefragmentdemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetailFragment extends Fragment {

    private RecyclerView recyclerView;

    public DetailFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.detail_fragment,container,false);
        recyclerView=(RecyclerView)view.findViewById(R.id.news_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //recyclerView.setItemAnimator(new DefaultItemAnimator());
        List<Map<String,Object>> mData=getData();
        recyclerView.setAdapter(new NewsListAdapter(getActivity(),mData));
        return view;
    }

    private List<Map<String,Object>> getData(){
        List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("news_title","毡帽系列");
        map.put("news_info","此系列服装有点cute，像不像小车夫。");
        map.put("news_thumb",R.drawable.i1);
        list.add(map);
        map=new HashMap<String, Object>();
        map.put("news_title","蜗牛系列");
        map.put("news_info","宝宝变成了小蜗牛，爬啊爬啊爬啊。");
        map.put("news_thumb",R.drawable.i2);
        list.add(map);
        map=new HashMap<String, Object>();
        map.put("news_title","小蜜蜂系列");
        map.put("news_info","小蜜蜂，嗡嗡嗡，飞到西，飞到东。");
        map.put("news_thumb",R.drawable.i3);
        list.add(map);
        map=new HashMap<String, Object>();
        map.put("news_title","毡帽系列");
        map.put("news_info","此系列服装有点cute，像不像小车夫。");
        map.put("news_thumb",R.drawable.i1);
        list.add(map);
        map=new HashMap<String, Object>();
        map.put("news_title","蜗牛系列");
        map.put("news_info","宝宝变成了小蜗牛，爬啊爬啊爬啊。");
        map.put("news_thumb",R.drawable.i2);
        list.add(map);
        map=new HashMap<String, Object>();
        map.put("news_title","小蜜蜂系列");
        map.put("news_info","小蜜蜂，嗡嗡嗡，飞到西，飞到东。");
        map.put("news_thumb",R.drawable.i3);
        list.add(map);
        return list;
    }
}
