package com.smq.smq0308yk.presenter;

import com.smq.smq0308yk.model.CarModel;
import com.smq.smq0308yk.view.CarView;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Time:2019/3/8
 * <p>
 * Author:Lenovo
 * <p>
 * Description:
 */
public class CarPresenter<T> {

    private final CarModel carModel;
    private final CarView carView;
    private Reference<T> tReference;
    public CarPresenter(CarView view) {
        carModel = new CarModel();
        carView = view;
    }

    public void onRelated() {
        carModel.getHttpData();
        carModel.setOnShowLinstener(new CarModel.onShowLinstener() {
            @Override
            public void onResult(String json) {
                carView.getData(json);
            }
        });
    }

    //处理内存泄漏
    public void attachView(T t){
        tReference=new WeakReference<T>(t);
    }

    public void deatchView(){
        if (tReference==null){
            tReference.clear();
            tReference=null;
        }
    }
}
