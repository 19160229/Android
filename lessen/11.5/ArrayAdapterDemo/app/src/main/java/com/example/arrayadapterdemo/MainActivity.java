package com.example.arrayadapterdemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView news_category_list;
    private int checkPosition=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        news_category_list=(ListView)findViewById(R.id.news_category);
//        news_category_list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
//        news_category_list.setAdapter(new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_single_choice,getResources().getStringArray(R.array.news_category)));
        news_category_list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        news_category_list.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice,
                getResources().getStringArray(R.array.news_category)));
    }
}
