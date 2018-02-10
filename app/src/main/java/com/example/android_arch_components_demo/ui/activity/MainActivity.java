package com.example.android_arch_components_demo.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.android_arch_components_demo.R;
import com.example.android_arch_components_demo.ui.fragment.ProductDetailFragment;
import com.example.android_arch_components_demo.ui.fragment.ProductListFragment;


public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    initProductListFragment();
  }

  private void initProductListFragment() {
    ProductListFragment productListFragment = new ProductListFragment();
    FragmentManager manager = getSupportFragmentManager();
    manager.beginTransaction().replace(R.id.fragment_container, productListFragment).commit();
  }

  public void initProductDetailFragment() {
    ProductDetailFragment productDetailFragment = new ProductDetailFragment();
    FragmentManager manager = getSupportFragmentManager();
    manager.beginTransaction().addToBackStack(null).add(R.id.fragment_container,
        productDetailFragment).commit();
  }
}
