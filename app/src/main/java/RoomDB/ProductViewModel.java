package RoomDB;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProductViewModel extends AndroidViewModel {

    private ProductRepository productRepository;
    private  LiveData<List<ProductItem>> allProducts;


    public ProductViewModel(@NonNull Application application) {
        super(application);

        productRepository = new ProductRepository(application);
        allProducts = productRepository.getAllProducts();
    }

    public LiveData<List<ProductItem>> getAllProducts() {
        return allProducts;
    }

    public void insertProduct(ProductItem productItem){
        productRepository.insertProduct(productItem);
    }
}
