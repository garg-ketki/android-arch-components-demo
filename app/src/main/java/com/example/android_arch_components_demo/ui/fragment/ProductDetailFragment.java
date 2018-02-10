package com.example.android_arch_components_demo.ui.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatDialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android_arch_components_demo.R;
import com.example.android_arch_components_demo.db.entity.Product;
import com.example.android_arch_components_demo.ui.adapter.CommentRecyclerViewAdapter;
import com.example.android_arch_components_demo.ui.viewholder.ProductVH;
import com.example.android_arch_components_demo.ui.viewmodel.ProductViewModel;

import java.util.ArrayList;


public class ProductDetailFragment extends AppCompatDialogFragment {

  private ProductViewModel viewModel;
  private RecyclerView rv;
  private CommentRecyclerViewAdapter adapter;
  private View view;

  public ProductDetailFragment() {
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    viewModel = ViewModelProviders.of(getActivity()).get(ProductViewModel.class);
    viewModel.getSelectedProduct().observe(this, data -> {
      setDataInUI(data);
      viewModel.fetchComments(data.getId()).observe(this, comments -> {
        adapter.modifyList(comments);
      });
    });
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    view = inflater.inflate(R.layout.fragment_product_detail, container, false);
    rv = view.findViewById(R.id.rv);
    adapter = new CommentRecyclerViewAdapter(new ArrayList<>());

    LinearLayoutManager manager = new LinearLayoutManager(getContext().getApplicationContext());
    manager.setOrientation(LinearLayoutManager.VERTICAL);
    rv.setLayoutManager(manager);

    rv.setAdapter(adapter);
    return view;
  }


  @Override
  public void onAttach(Context context) {
    super.onAttach(context);

  }

  public void setDataInUI(Product product) {
    ProductVH holder = new ProductVH(view);
    holder.title.setText(product.getName());
    holder.description.setText(product.getDescription());
    holder.price.setText("$" + product.getPrice());
  }
}
