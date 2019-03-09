package io.destreza.android_component.Room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

@Dao
public interface DaoAccess {
    @Insert
    void insertSingleUser(User user);
    @Query("SELECT * FROM User WHERE userId = :userId")
    User selectSingleUser(int userId );
    @Update
    void updateSingleUser(User user);
    @Delete
    void deleteSingleUser(User user);
}
