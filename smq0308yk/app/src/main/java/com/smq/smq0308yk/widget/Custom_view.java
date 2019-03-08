package com.smq.smq0308yk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.smq.smq0308yk.R;

/**
 * Time:2019/3/8
 * <p>
 * Author:Lenovo
 * <p>
 * Description:
 */
public class Custom_view extends RelativeLayout implements View.OnClickListener {

    private int i;
    private EditText num;

    public Custom_view(Context context) {
        super(context);
    }

    public Custom_view(Context context, AttributeSet attrs) {
        super(context, attrs);
        getData();
    }

    public Custom_view(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void getData() {
        View view=LayoutInflater.from(getContext()).inflate(R.layout.custom_view,null);
        //找控件
        Button jia=view.findViewById(R.id.jia);
        Button jian=view.findViewById(R.id.jian);
        num = view.findViewById(R.id.num);
        //设置点击事件
        jia.setOnClickListener(this);
        jian.setOnClickListener(this);
        //给num赋值
        i = 1;
        num.setText(i +"");
        addView(view);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.jia:
                i++;
                num.setText(i+"");
                break;
            case R.id.jian:
                if (i<2){
                    Toast.makeText(getContext(), "不能再减了！", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    i--;
                    num.setText(i+"");
                }
                break;
        }
    }
}
