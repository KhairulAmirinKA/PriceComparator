package RoomDB;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ProductRepository {

    private ProductDao productDao;
    private LiveData<List<ProductItem>> allProducts;

    public ProductRepository(Application application) {
        ProductDatabase db =  ProductDatabase.getDatabase(application);

        productDao = db.productDao();
        allProducts = productDao.getAllProducts();
    }

    //get all product data
    public LiveData<List<ProductItem>> getAllProducts() {
        return allProducts;
    }

    //insert Product into database
    void insertProduct(ProductItem productItem){
        ProductDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                productDao.insertProduct(productItem);
            }
        });
    }

    //delete all
    void deleteAll(){
        ProductDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                productDao.deleteAll();
            }
        });
    }

    //sort products
    public LiveData<List<ProductItem>> sortProducts(){
        return productDao.sortProducts();
    }


}
