package io.destreza.android_component.Room;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import io.destreza.android_component.R;

public class RoomActivity extends AppCompatActivity {
    private static final String DATABASE_NAME = "Student_DB";
    private UserDatabase userDatabase;
    private User user1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        userDatabase = Room.databaseBuilder(this,
                UserDatabase.class, DATABASE_NAME)
                //.fallbackToDesctructiveMigration()
                .build();


        //Toast.makeText(RoomActivity.this, "Successfully insert", Toast.LENGTH_SHORT).show();

        new Thread(new Runnable() {
            @Override
            public void run() {
                User user =new User();
                user.setUserId(3);
                user.setUserName("Zubayer Hosain");
                userDatabase.daoAccess () . insertSingleUser (user);

                user1=userDatabase.daoAccess().selectSingleUser(3);
                Log.e("user",user1.getUserName());
            }
        }) .start();

    }
}
