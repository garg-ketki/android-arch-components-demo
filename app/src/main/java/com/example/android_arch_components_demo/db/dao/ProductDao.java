package com.example.android_arch_components_demo.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.android_arch_components_demo.db.entity.Product;

import java.util.List;

/**
 * Created by ketkigarg on 23/01/18.
 */

@Dao
public interface ProductDao {

  @Query("Select * from product")
  LiveData<List<Product>> getAllProducts();

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  long insertProduct(Product product);

  @Query("delete from product")
  void deleteAll();
}
