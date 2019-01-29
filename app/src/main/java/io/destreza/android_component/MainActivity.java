package io.destreza.android_component;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.SeekBar;
<<<<<<< HEAD
import android.widget.TextView;
=======
import android.widget.Spinner;
>>>>>>> e6a275648f84ea78836d49875d7b17dcfe8d092d
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private int count=0;
    //for multiLanguage support
    Locale myLocale;
    String currentLanguage = "en", currentLang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD
        setContentView(R.layout.multi_language_support);
=======
        setContentView(R.layout.spinner);
>>>>>>> e6a275648f84ea78836d49875d7b17dcfe8d092d

       // getRatingBar();

        //getSeekbar();

<<<<<<< HEAD
        //createMultiEditTextOnClick();

        //pdfFileGenerate();

        getMultiLanguage();

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
=======
        //getBaseSpinner
        customSpinnerLayout();
>>>>>>> e6a275648f84ea78836d49875d7b17dcfe8d092d
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
