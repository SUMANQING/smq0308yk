package com.smq.smq0308yk.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.smq.smq0308yk.R;
import com.smq.smq0308yk.bean.JsonBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Time:2019/3/8
 * <p>
 * Author:Lenovo
 * <p>
 * Description:
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<JsonBean.DataBean> list=null;

    //构造方法
    public MyAdapter(Context context, ArrayList<JsonBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.item_list1,null);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        final JsonBean.DataBean dataBean = this.list.get(i);
        //展示商家
        myViewHolder.textView.setText(list.get(i).getSellerName());
        //为子类设置布局管理器
        myViewHolder.recyclerView.setLayoutManager(new LinearLayoutManager(context));
        final List<JsonBean.DataBean.ListBean> list2 = dataBean.getList();
        SecondAdapter adapter=new SecondAdapter(context, (ArrayList<JsonBean.DataBean.ListBean>) list2);
        myViewHolder.recyclerView.setAdapter(adapter);

        //父控制子类
        adapter.setChildCheckListener(new SecondAdapter.OnChildCheckListener() {
            @Override
            public void oncheck() {
                if (onParentCheckListener!=null){
                    onParentCheckListener.checked(dataBean);
                }
                boolean value=true;
                for (int j=0;j<list2.size();j++){

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private final CheckBox checkBox;
        private final TextView textView;
        private final RecyclerView recyclerView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //找控件
            checkBox = itemView.findViewById(R.id.check_one);
            textView = itemView.findViewById(R.id.shop_title);
            recyclerView = itemView.findViewById(R.id.ryc_one);
        }
    }

    public interface OnParentCheckListener{
        void checked(JsonBean.DataBean data);
    }
    public OnParentCheckListener onParentCheckListener;

    public void setOnParentCheckListener(OnParentCheckListener onParentCheckListener) {
        this.onParentCheckListener = onParentCheckListener;
    }
}
