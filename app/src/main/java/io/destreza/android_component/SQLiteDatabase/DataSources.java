package io.destreza.android_component.SQLiteDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DataSources {
    DatabaseHelper databaseHelper;
    SQLiteDatabase db;

    public DataSources(Context context)
    {
        databaseHelper=new DatabaseHelper(context);
    }
    public void openDatabase()
    {
        db=databaseHelper.getWritableDatabase();
    }
    public void closeDatabase()
    {
        db.close();
    }

    public boolean insertPlayerInfo(Players players)
    {
        this.openDatabase();
        ContentValues values=new ContentValues();
        values.put(DatabaseHelper.PLAYER_NAME,players.getPlayerName());
        values.put(DatabaseHelper.PLAYER_TYPE,players.getPlayerType());
        values.put(DatabaseHelper.AGE,players.getPlayerAge());
        long rowNumber=db.insert(DatabaseHelper.PLAYER_TABLE,null,values);
        this.closeDatabase();

        if(rowNumber>0)
            return true;
        else
            return false;
    }


    public List<Players> getPlayersList()
    {
        List<Players> playersList=new ArrayList<>();

        this.openDatabase();

        Cursor cursor=db.query(DatabaseHelper.PLAYER_TABLE,
                null,null,null,null,null,null);
        if(cursor!=null && cursor.getCount()>0)
        {
            cursor.moveToFirst();
            do{
                String playerName=cursor.getString(cursor.getColumnIndex(DatabaseHelper.PLAYER_NAME));
                String playerType=cursor.getString(cursor.getColumnIndex(DatabaseHelper.PLAYER_TYPE));
                String playerAge=cursor.getString(cursor.getColumnIndex(DatabaseHelper.AGE));


                Players players=new Players(playerName,playerType,playerAge);

                playersList.add(players);
            }
            while (cursor.moveToNext());
        }
        this.closeDatabase();
        cursor.close();
        return playersList;
    }

}
