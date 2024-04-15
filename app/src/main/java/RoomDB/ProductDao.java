package RoomDB;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertProduct(ProductItem... productItems);

    @Delete
    void delete(ProductItem productItem);

    @Query("DELETE FROM ProductItem")
    void deleteAll();

    @Query("SELECT * FROM ProductItem")
    LiveData<List<ProductItem>> getAllProducts();
}
