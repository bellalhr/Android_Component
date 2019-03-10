package io.destreza.android_component.SimpleLiveDataViewModel;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import io.destreza.android_component.MainActivity;
import io.destreza.android_component.R;

public class SimpleActivity extends AppCompatActivity {
    String apiUrl ="https://ifconfig.co/json";

    TextView tv1,tv2, tv3;
    String ip, Country,latlng;

    SimpleViewModel model;
    String res="";

    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);

        context =getApplicationContext();

        tv1 =findViewById(R.id.textView);
        tv2 =findViewById(R.id.textView2);
        tv3 =findViewById(R.id.textView3);

        //getConfigValue();
        model = ViewModelProviders.of(SimpleActivity.this).get(SimpleViewModel.class);

/*
        final Observer<String> countryOb = new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

                tv2.setText("Country: "+s);
                Log.d("data::",s);
            }
        };
        model.getCountryName().observe(this, countryOb);

*/

        final Observer<IpInfoModel> ipInfoOb = new Observer<IpInfoModel>() {
            @Override
            public void onChanged(@Nullable IpInfoModel ipInfoModel) {

                Log.d("data::",ipInfoModel.getCountryName()+"---"+ipInfoModel.getIp());

                tv1.setText("IP: "+ipInfoModel.getIp());
                tv2.setText("Country: "+ipInfoModel.getCountryName());
                tv3.setText("Location: : "+ipInfoModel.getLoc());

            }
        };
        model.getIpConfig().observe(this,ipInfoOb);

        
    }
}
