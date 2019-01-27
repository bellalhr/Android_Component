package io.destreza.android_component;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner);

       // getRatingBar();

        //getSeekbar();

        //getBaseSpinner
        customSpinnerLayout();
    }



    private void getRatingBar() {
        Button ratinBtn=findViewById(R.id.getRatingBtn);
        final RatingBar ratingBar=findViewById(R.id.ratingBar);

        ratinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float rating=ratingBar.getRating();
                Toast.makeText(MainActivity.this, "Rating "+rating, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getSeekbar(){
        SeekBar seekBar=findViewById(R.id.seekbar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Toast.makeText(MainActivity.this, "OnProgressChanged "+progress, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //Toast.makeText(MainActivity.this, "OnProgressChanged "+seekBar.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //Toast.makeText(MainActivity.this, "OnProgressChanged "+seekBar.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void customSpinnerLayout()
    {
        Spinner spinner=findViewById(R.id.spinner);
        spinner.setPrompt("Select Country");
        int[] flags={
                R.drawable.bird_10,
                R.drawable.bird_11,
                R.drawable.bird_20,
                R.drawable.bird_21,
                R.drawable.bird_22,
                R.drawable.bird_23,
        };

        String[] countryName={"Bangladesh","India","Sri Lanka","Japan","Australia","Singapur"};

        SpinnerBaseAdapter adapter=new SpinnerBaseAdapter(this,flags,countryName);
        spinner.setAdapter(adapter);


    }


}
