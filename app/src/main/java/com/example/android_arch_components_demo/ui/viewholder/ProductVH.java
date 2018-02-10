package com.example.android_arch_components_demo.ui.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.android_arch_components_demo.R;


/**
 * Created by ketkigarg on 23/01/18.
 */

public class ProductVH extends RecyclerView.ViewHolder {
  public TextView title, description, price;

  public ProductVH(View itemView) {
    super(itemView);
    title = itemView.findViewById(R.id.title);
    description = itemView.findViewById(R.id.description);
    price = itemView.findViewById(R.id.price);
  }
}
