package com.example.simplefragmentdemo;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class NewsListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<Map<String,Object>> mDataList;
    //private LayoutInflater mLayoutInflater;

    public NewsListAdapter(Context mContext,List<Map<String,Object>> mDataList){
        this.mContext=mContext;
        this.mDataList=mDataList;
        // mLayoutInflater=LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Map<String,Object> entity=mDataList.get(i);
        if(null==entity){
            return;
        }
        ViewHolder holder=(ViewHolder)viewHolder;
        holder.news_title.setText(entity.get("news_title").toString());
        holder.news_info.setText(entity.get("news_info").toString());
        holder.news_thumb.setImageResource(Integer.parseInt(entity.get("news_thumb").toString()));
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView news_title;
        ImageView news_thumb;
        TextView news_info;
        public ViewHolder(final View itemView){
            super(itemView);
            news_title=(TextView)itemView.findViewById(R.id.news_title);
            news_thumb=(ImageView)itemView.findViewById(R.id.news_thumb);
            news_info=(TextView)itemView.findViewById(R.id.news_info);
            itemView.findViewById(R.id.news_container).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position=getAdapterPosition();
                    new AlertDialog.Builder(v.getContext())
                            .setTitle(mDataList.get(position).get("news_title").toString())
                            .setMessage(mDataList.get(position).get("news_info").toString())
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            })
                            .show();
                }
            });
        }
    }
}
