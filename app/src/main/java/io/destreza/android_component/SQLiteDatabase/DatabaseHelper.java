package io.destreza.android_component.SQLiteDatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="Sports";
    public static final int DATAVASE_VERSION=2;
    Context context;
    //Todo create player table abttribuits
    public static final String PLAYER_TABLE ="Player";
    public static final String ID_PLAYER="id_player";
    public static final String PLAYER_NAME="player_name";
    public static final String PLAYER_TYPE="player_type";
    public static final String AGE="age";

    public static final String CREATE_PLAYER_TABLE="CREATE TABLE "+ PLAYER_TABLE +"("+
            ID_PLAYER+" integer primary key AUTOINCREMENT, "+
            PLAYER_NAME+" text, "+
            PLAYER_TYPE+" text, "+
            AGE+" text );";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATAVASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_PLAYER_TABLE);
            Toast.makeText(context, "Successfully create", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Toast.makeText(context, "onUpgrade method is called", Toast.LENGTH_SHORT).show();
    }
}
