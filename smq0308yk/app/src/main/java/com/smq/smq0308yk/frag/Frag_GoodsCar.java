package com.smq.smq0308yk.frag;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import com.google.gson.Gson;
import com.smq.smq0308yk.R;
import com.smq.smq0308yk.adapter.MyAdapter;
import com.smq.smq0308yk.bean.JsonBean;
import com.smq.smq0308yk.presenter.CarPresenter;
import com.smq.smq0308yk.view.CarView;

import java.util.ArrayList;
import java.util.List;

public class Frag_GoodsCar extends Fragment implements CarView {

    private RecyclerView recyclerView;
    private CarPresenter carPresenter;
    private CheckBox checkBox;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.frag_car,null,false);
        //找控件
        recyclerView = view.findViewById(R.id.ryc);
        checkBox = view.findViewById(R.id.check);

        //设置布局管理器
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        //调用p层
        carPresenter = new CarPresenter(this);
        carPresenter.onRelated();
        return view;
    }

    @Override
    public void getData(String json) {
        if (json!=null){
            //gson解析
            Gson gson=new Gson();
            JsonBean jsonBean = gson.fromJson(json, JsonBean.class);
            final List<JsonBean.DataBean> data = jsonBean.getData();
            //适配器显示
            MyAdapter myAdapter=new MyAdapter(getActivity(), (ArrayList<JsonBean.DataBean>) data);
            recyclerView.setAdapter(myAdapter);

            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (checkBox.isChecked()){

                    }
                }
            });
        }
    }

    //解除绑定
    @Override
    public void onDestroy() {
        super.onDestroy();
        carPresenter.deatchView();
    }
}
