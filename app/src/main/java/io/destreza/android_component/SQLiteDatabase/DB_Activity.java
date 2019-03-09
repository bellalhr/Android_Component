package io.destreza.android_component.SQLiteDatabase;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import io.destreza.android_component.R;

public class DB_Activity extends AppCompatActivity {
    private DataSources dataSources;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db_);

       dataSources=new DataSources(this);
       dataSources.openDatabase();

       //Todo insert the record into player table

     /*  Players p1=new Players("Musfiqur Rahim","Batsman/WicketKipper","30");

       if(dataSources.insertPlayerInfo(p1))
       {
           Toast.makeText(this, "Successfully insert this record", Toast.LENGTH_SHORT).show();
       }
       else {
           Toast.makeText(this, "This record is not inserted", Toast.LENGTH_SHORT).show();
       }*/

      //Todo show all players list
        List<Players> pList= dataSources.getPlayersList();
        if(pList.size()>0)
        {
            for(int i=0;i<pList.size();i++)
            {
                Log.e("playerInfo","Name "+pList.get(i).getPlayerName());
                Log.e("playerInfo","Type "+pList.get(i).getPlayerType());
                Log.e("playerInfo","age "+pList.get(i).getPlayerAge());
                Log.e("playerInfo","-------------------------------------");
            }
        }

    }
}
