package com.smq.smq0308yk.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.smq.smq0308yk.R;
import com.smq.smq0308yk.bean.JsonBean;

import java.util.ArrayList;

/**
 * Time:2019/3/8
 * <p>
 * Author:Lenovo
 * <p>
 * Description:
 */
public class SecondAdapter extends RecyclerView.Adapter<SecondAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<JsonBean.DataBean.ListBean> list=null;

    public SecondAdapter(Context context, ArrayList<JsonBean.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.item_list2,null);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.name.setText(list.get(i).getSubhead());
        myViewHolder.money.setText("￥："+ list.get(i).getPrice());
        Glide.with(context).load(list.get(i).getDetailUrl()).into(myViewHolder.imageView);

        myViewHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setCheck(boolean checked){
        for (int i=0;i<list.size();i++){

            notifyDataSetChanged();
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private final CheckBox checkBox;
        private final ImageView imageView;
        private final TextView name;
        private final TextView money;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.check_two);
            imageView = itemView.findViewById(R.id.img);
            name = itemView.findViewById(R.id.name);
            money = itemView.findViewById(R.id.money);
        }
    }

    //创建接口
    public interface OnChildCheckListener{
        void oncheck();
    }
    public OnChildCheckListener childCheckListener;

    public void setChildCheckListener(OnChildCheckListener childCheckListener) {
        this.childCheckListener = childCheckListener;
    }
}
