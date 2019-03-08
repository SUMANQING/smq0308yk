package com.smq.smq0308yk;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.smq.smq0308yk.frag.Frag_GoodsCar;
import com.smq.smq0308yk.frag.Frag_Main;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {

    private ViewPager pager;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager = findViewById(R.id.pager);
        radioGroup = findViewById(R.id.radio);

        final ArrayList<Fragment> arrayList=new ArrayList<>();
        arrayList.add(new Frag_GoodsCar());
        arrayList.add(new Frag_Main());
        radioGroup.check(radioGroup.getChildAt(0).getId());

        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return arrayList.get(i);
            }

            @Override
            public int getCount() {
                return arrayList.size();
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.button:
                        pager.setCurrentItem(0);
                        break;
                    case R.id.button2:
                        pager.setCurrentItem(1);
                        break;
                }
            }
        });

        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                radioGroup.check(radioGroup.getChildAt(i).getId());
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }
}
