package io.destreza.android_component.Threads;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import io.destreza.android_component.R;

public class BasicThread extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_thread);

        Log.e("Log","Previous thread called");

        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    Thread.sleep(1000);
                    Log.e("Log","Thread is running");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();



        try {
            Thread.sleep(3000);
            Log.e("Log","After thread called");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
