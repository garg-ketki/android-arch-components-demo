package com.example.android_arch_components_demo.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android_arch_components_demo.R;
import com.example.android_arch_components_demo.db.entity.Product;
import com.example.android_arch_components_demo.ui.fragment.ProductListFragment;
import com.example.android_arch_components_demo.ui.viewholder.ProductVH;

import java.util.List;

/**
 * Created by ketkigarg on 23/01/18.
 */

public class ProductRecyclerViewAdapter extends RecyclerView.Adapter<ProductVH> {
  private List<Product> productList;
  private ProductListFragment.MyClickListener myClickListener;

  public ProductRecyclerViewAdapter(List<Product> productList,
                                    ProductListFragment.MyClickListener myClickListener) {
    this.productList = productList;
    this.myClickListener = myClickListener;
  }

  @Override
  public ProductVH onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_product_info,
        parent, false);
    view.setOnClickListener(myClickListener);
    return new ProductVH(view);
  }

  @Override
  public void onBindViewHolder(ProductVH holder, int position) {
    Product product = productList.get(position);
    holder.title.setText(product.getName());
    holder.description.setText(product.getDescription());
    holder.price.setText("$" + product.getPrice());
  }

  public void modifyList(List<Product> productList) {
    this.productList.clear();
    this.productList = productList;
    notifyDataSetChanged();
  }

  @Override
  public int getItemCount() {
    return productList.size();
  }
}
