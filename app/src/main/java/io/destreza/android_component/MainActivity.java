package io.destreza.android_component;

import android.app.DatePickerDialog;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;

import android.widget.TextView;

import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private int count=0;
    //for multiLanguage support
    Locale myLocale;
    String currentLanguage = "en", currentLang;
    int progressValue=0;
    Handler handler=new Handler();
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.time_picker_dialog);






       // getRatingBar();

        //getSeekbar();


        //createMultiEditTextOnClick();

        //pdfFileGenerate();

        //getMultiLanguage();

        //getGridView();

        //hideAndroidIcon();

        //Todo calling method for show progress bar
        //showProgressBar();
        // Todo calling method for show date picker
       //showDatePicker();

        showTimePicker();



    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void showTimePicker() {
        final TimePicker timePicker=findViewById(R.id.timePicker);
        Button timeBtn=findViewById(R.id.timePickeBtn);


        StringBuilder builder=new StringBuilder();
        builder.append(timePicker.getHour()+"/");
        builder.append(timePicker.getMinute()+"/");
       // builder.append(timePicker.get);
        timeBtn.setText("Current Date : "+builder);

    }

    private void showDatePicker() {
        final DatePicker datePicker=findViewById(R.id.datePicker);
        Button selectedBtn=findViewById(R.id.getSelectedDateBtn);
        final TextView currentDate=findViewById(R.id.currentTV);

        final Button showDatePicker=findViewById(R.id.showDatePickerDialog);

        //get current date
        StringBuilder builder=new StringBuilder();
        builder.append(datePicker.getMonth()+1+"/");
        builder.append(datePicker.getDayOfMonth()+"/");
        builder.append(datePicker.getYear());
        currentDate.setText("Current Date : "+builder);


        selectedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get changeable date
                StringBuilder builder=new StringBuilder();
                builder.append(datePicker.getMonth()+1+"/");
                builder.append(datePicker.getDayOfMonth()+"/");
                builder.append(datePicker.getYear());
                currentDate.setText("Change Date : "+builder);
            }
        });


        showDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar=Calendar.getInstance();
                int startYear=calendar.get(Calendar.YEAR);
                int month=calendar.get(Calendar.MONTH);
                int date=calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog=new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        showDatePicker.setText(i+"/"+(i1+1)+"/"+i2);
                    }
                },startYear,month,date);

                datePickerDialog.show();
            }
        });



    }

    private void showProgressBar() {
        final ProgressBar progressBar=findViewById(R.id.progressBar);
        final TextView progressStatusTV=findViewById(R.id.progresStatus);



        //progressBar.setProgress(progressValue);

        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                while (progressValue<=100)
                {
                    //progressStatusTV.setText(progressValue+"%");
                    //doWork(progressValue,progressBar,progressStatusTV);
                    try {
                        Thread.sleep(500);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //progressBar.setProgress(progressValue);
                            //progressStatusTV.setText(progressValue+"%");
                            progressValue=progressValue+5;

                            if(progressValue<=100)
                                doWork(progressValue,progressBar,progressStatusTV);

                        }
                    });
                }

            }
        });
        thread.start();

    }

    private void doWork(int progressValue,ProgressBar progressBar,TextView progressTV) {
        progressBar.setProgress(progressValue);
        progressTV.setText(String.valueOf(progressValue)+"%");
    }

    private void hideAndroidIcon() {
        Button hide=findViewById(R.id.hide);
        Button show=findViewById(R.id.show);
        hide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PackageManager p = getPackageManager();
                ComponentName componentName = new ComponentName(MainActivity.this, MainActivity.class);
                p.setComponentEnabledSetting(componentName,PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
            }
        });
        //show app

        /*PackageManager p = getPackageManager();
        ComponentName componentName = new ComponentName(this, MainActivity.class);
        p.setComponentEnabledSetting(componentName, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);*/
    }

    private void getGridView() {
        GridView gridView=findViewById(R.id.gridView);
        ArrayList<String> playerList=new ArrayList<>();
        playerList.add("Shakib Al Hasan");
        playerList.add("Tamim Iqbal");
        playerList.add("Mashrafre Mortaza");
        playerList.add("Shakib Al Hasan");
        playerList.add("Shakib Al Hasan");
        playerList.add("Shakib Al Hasan");
        playerList.add("Shakib Al Hasan");
        playerList.add("Shakib Al Hasan");
        playerList.add("Shakib Al Hasan");
        playerList.add("Shakib Al Hasan");
        playerList.add("Shakib Al Hasan");
        playerList.add("Shakib Al Hasan");
        playerList.add("Tamim Iqbal");
        playerList.add("Mashrafre Mortaza");
        playerList.add("Mashrafre Mortaza");
        playerList.add("Mashrafre Mortaza");
        playerList.add("Mashrafre Mortaza");
        playerList.add("Mashrafre Mortaza");
        playerList.add("Mashrafre Mortaza");
        playerList.add("Mashrafre Mortaza");
        playerList.add("Shakib Al Hasan");
        playerList.add("Shakib Al Hasan");
        playerList.add("Shakib Al Hasan");
        playerList.add("Shakib Al Hasan");
        playerList.add("Shakib Al Hasan");
        playerList.add("Shakib Al Hasan");
        playerList.add("Shakib Al Hasan");
        playerList.add("Shakib Al Hasan");
        playerList.add("Shakib Al Hasan");

        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,playerList);
        gridView.setAdapter(adapter);


      gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              startActivity(new Intent(MainActivity.this,Activity_Life_Cycle.class));
          }
      });
    }

    private void getMultiLanguage() {
        setLocale("bd");
    }
    public void setLocale(String localeName) {
        if (!localeName.equals(currentLanguage)) {
            myLocale = new Locale(localeName);
            Resources res = getResources();
            DisplayMetrics dm = res.getDisplayMetrics();
            Configuration conf = res.getConfiguration();
            conf.locale = myLocale;
            res.updateConfiguration(conf, dm);
            Intent refresh = new Intent(this, MainActivity.class);
            refresh.putExtra(currentLang, localeName);
            startActivity(refresh);
        } else {
            Toast.makeText(MainActivity.this, "Language already selected!", Toast.LENGTH_SHORT).show();
        }
    }
    private void pdfFileGenerate()
    {
        /*String FILE = Environment.getExternalStorageDirectory()
                + "/HelloWorld.pdf";*/

        final EditText msgET=findViewById(R.id.message);
        Button pdfGenBtn=findViewById(R.id.writeBtn);

        pdfGenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createPdf(msgET.getText().toString());
            }
        });



    }

    private void createPdf(String sometext){
        // create a new document
        PdfDocument document = new PdfDocument();
        // crate a page description
        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(300, 600, 1).create();
        // start a page
        PdfDocument.Page page = document.startPage(pageInfo);

        Canvas canvas = page.getCanvas();
        Paint paint = new Paint();
        paint.setColor(Color.RED);
       // canvas.drawCircle(50, 50, 30, paint);
        paint.setColor(Color.BLACK);
        canvas.drawText(sometext, 80, 50, paint);
        //canvas.drawt
        // finish the page
        document.finishPage(page);
// draw text on the graphics object of the page
        // Create Page 2
        pageInfo = new PdfDocument.PageInfo.Builder(300, 600, 2).create();
        page = document.startPage(pageInfo);
        canvas = page.getCanvas();
        paint = new Paint();
        paint.setColor(Color.BLUE);
        //canvas.drawCircle(100, 100, 100, paint);

        View content =findViewById(R.id.containt);
        content.draw(page.getCanvas());

        document.finishPage(page);
        // write the document content
        String directory_path = Environment.getExternalStorageDirectory().getPath() + "/mypdf/";
        File file = new File(directory_path);
        if (!file.exists()) {
            file.mkdirs();
        }
        String targetPdf = directory_path+"test-2.pdf";
        File filePath = new File(targetPdf);
        try {
            document.writeTo(new FileOutputStream(filePath));
            Toast.makeText(this, "Done", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            Log.e("main", "error "+e.toString());
            Toast.makeText(this, "Something wrong: " + e.toString(),  Toast.LENGTH_LONG).show();
        }
        // close the document
        document.close();
    }


    private void createMultiEditTextOnClick()
    {
        final LinearLayout edittextLL=findViewById(R.id.edittextContainer);
        Button addBtn=findViewById(R.id.addBtn);
        Button saveBtn=findViewById(R.id.saveBtn);
        //final EditText texts=new EditText(Main);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               EditText texts=new EditText(MainActivity.this);
               texts.setId(count);
               texts.setHint("Option "+count);
               edittextLL.addView(texts);
               count++;

            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String value="";
                for(int i=0;i<count;i++)
                {
                    EditText val=findViewById(i);
                    value=value+val.getText().toString();

                }
                Toast.makeText(MainActivity.this, ""+value, Toast.LENGTH_SHORT).show();
                edittextLL.removeAllViews();
                count=0;
            }
        });

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
