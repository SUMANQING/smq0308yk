package com.smq.smq0308yk.model;

import android.os.Handler;
import android.os.Message;

import com.smq.smq0308yk.utils.OkHttpUtils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Time:2019/3/8
 * <p>
 * Author:Lenovo
 * <p>
 * Description:
 */
public class CarModel {
    private String url="http://172.17.8.100/ks/product/getCarts?uid=51";
    //创建handler
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    String json= (String) msg.obj;
                    onShowLinstener.onResult(json);
                    break;
            }
        }
    };
    public void getHttpData() {
        OkHttpUtils.doGet(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                Message message=new Message();
                message.what=0;
                message.obj=json;
                handler.sendMessage(message);
            }
        });
    }

    //创建接口
    public interface onShowLinstener{
        void onResult(String json);
    }
    public onShowLinstener onShowLinstener;

    public void setOnShowLinstener(CarModel.onShowLinstener onShowLinstener) {
        this.onShowLinstener = onShowLinstener;
    }
}
