package com.bryan.hybrid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.json.JSONObject;

import cn.pedant.SafeWebViewBridge.UriRouter;

/**
 * Author：Cxb on 2016/5/26 13:55
 */
public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            String param=bundle.getString(UriRouter.PARAM);
            try {
                JSONObject jsonObject=new JSONObject(param);
                Toast.makeText(this,jsonObject.toString(),Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
