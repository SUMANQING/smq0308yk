package com.smq.smq0308yk.frag;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.smq.smq0308yk.R;
import com.smq.smq0308yk.widget.Custom_Main;

public class Frag_Main extends Fragment {

    private Custom_Main custom_main;
    private Button button;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.frag_main,null,false);
        custom_main = view.findViewById(R.id.cus_main);
        button = view.findViewById(R.id.main);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(custom_main,"translationY",0f,60f,0f);
                objectAnimator.setDuration(2000);
                objectAnimator.start();
                objectAnimator = ObjectAnimator.ofFloat(custom_main,"alpha",1f,0.3f);
                objectAnimator.setDuration(2000);
                objectAnimator.start();

            }
        });
        return view;
    }
}
