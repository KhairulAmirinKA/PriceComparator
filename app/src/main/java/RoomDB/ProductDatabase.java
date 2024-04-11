package RoomDB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {ProductItem.class}, version = 1)
public abstract class ProductDatabase extends RoomDatabase {
    public abstract ProductDao productDao();

    private static ProductDatabase INSTANCE;

    private static final Object sLock = new Object();

    public static ProductDatabase getInstance(Context context){
        synchronized (sLock){
            if (INSTANCE==null){

                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        ProductDatabase.class,
                        "ProductDatabase.db")
                        .allowMainThreadQueries()
                        .build();
            }
        }
        return INSTANCE;
    }

}
