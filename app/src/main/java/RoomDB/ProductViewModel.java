package RoomDB;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProductViewModel extends AndroidViewModel {

    private final ProductRepository productRepository;
    private  LiveData<List<ProductItem>> allProducts;


    public ProductViewModel(@NonNull Application application) {
        super(application);

        productRepository = new ProductRepository(application);
        allProducts = productRepository.getAllProducts();
    }

    //get all data
    public LiveData<List<ProductItem>> getAllProducts() {
        return allProducts;
    }

    //insert new data
    public void insertProduct(ProductItem productItem){
        productRepository.insertProduct(productItem);
    }

    //delete all data
    public void deleteAll(){
        productRepository.deleteAll();
    }

    //sort products
    public LiveData<List<ProductItem>> sortProducts(){
        return productRepository.sortProducts();

    }
}
