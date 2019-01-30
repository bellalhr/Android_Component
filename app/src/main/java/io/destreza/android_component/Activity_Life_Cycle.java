package io.destreza.android_component;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Activity_Life_Cycle extends AppCompatActivity {
    private static final String LOG="add3";
    private TextView currentTV,changeableTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__life__cycle);
        currentTV=findViewById(R.id.currentTV);
        changeableTV=findViewById(R.id.changeTV);

        currentTV.setText("Current Message");
        changeableTV.setText("Current Message");

        Log.e(LOG,"onCreate is called");

    }

    @Override
    protected void onStart() {
        Log.e(LOG,"onStart is called");
        super.onStart();
    }
    @Override
    protected void onResume() {
        Log.e(LOG,"onResume is called");
        //currentTV.setText("Current Message");
        //changeableTV.setText("Hi i am changeable activity");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.e(LOG,"onPause is called");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.e(LOG,"onStop is called");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        Log.e(LOG,"onRestart is called");
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        Log.e(LOG,"onDestroy is called");
        super.onDestroy();
    }


    public void goSecondActivity(View view) {
        startActivity(new Intent(Activity_Life_Cycle.this,MainActivity.class));
    }
}
