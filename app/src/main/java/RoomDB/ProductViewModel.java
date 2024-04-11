package RoomDB;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProductViewModel extends AndroidViewModel {

    private ProductDao productDao;
    private ExecutorService executorService;

    public ProductViewModel(@NonNull Application application) {
        super(application);

        productDao = ProductDatabase.getInstance(application).productDao();
        executorService = Executors.newSingleThreadExecutor();
    }

    LiveData<List<ProductItem>> getAllProducts(){
        return productDao.getAllProducts();
    }




}
