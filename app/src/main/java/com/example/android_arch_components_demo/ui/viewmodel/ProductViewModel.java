package com.example.android_arch_components_demo.ui.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.example.android_arch_components_demo.db.AppDatabase;
import com.example.android_arch_components_demo.db.entity.Comment;
import com.example.android_arch_components_demo.db.entity.Product;

import java.util.List;

/**
 * Created by ketkigarg on 23/01/18.
 */

public class ProductViewModel extends AndroidViewModel {

  private MutableLiveData<Product> selectedProduct = new MutableLiveData<>();
  private AppDatabase mdb;

  public ProductViewModel(Application application) {
    super(application);
    mdb = AppDatabase.getInstance(application);
    createDB();
  }

  private void createDB() {
    mdb.mock();
  }

  public MutableLiveData<Product> getSelectedProduct() {
    return selectedProduct;
  }

  public void setSelectedProduct(Product product) {
    selectedProduct.setValue(product);
  }

  public LiveData<List<Comment>> fetchComments(long productId) {
    return mdb.getCommentDao().getAllComments(productId);
  }

  public LiveData<List<Product>> fetchProducts() {
    return mdb.getProductDao().getAllProducts();
  }


}
