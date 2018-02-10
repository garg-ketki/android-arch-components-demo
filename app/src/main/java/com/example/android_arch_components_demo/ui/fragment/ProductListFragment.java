package com.example.android_arch_components_demo.ui.fragment;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android_arch_components_demo.R;
import com.example.android_arch_components_demo.db.entity.Product;
import com.example.android_arch_components_demo.ui.activity.MainActivity;
import com.example.android_arch_components_demo.ui.adapter.ProductRecyclerViewAdapter;
import com.example.android_arch_components_demo.ui.viewmodel.ProductViewModel;

import java.util.ArrayList;
import java.util.List;

public class ProductListFragment extends AppCompatDialogFragment {
  private ProductViewModel viewModel;
  private ProductRecyclerViewAdapter adapter;
  private RecyclerView rv;
  private List<Product> productList;

  public ProductListFragment() {
    productList = new ArrayList<>();
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    viewModel = ViewModelProviders.of(getActivity()).get(ProductViewModel.class);
    viewModel.fetchProducts().observe(getActivity(), data -> {
      productList = data;
      adapter.modifyList(productList);
    });
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_product_list, container, false);
    rv = view.findViewById(R.id.rv);
    adapter = new ProductRecyclerViewAdapter(productList, new MyClickListener());

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

  @Override
  public void onDetach() {
    super.onDetach();
  }

  public class MyClickListener implements View.OnClickListener {
    @Override
    public void onClick(View view) {
      if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
        int position = rv.getChildLayoutPosition(view);
        viewModel.setSelectedProduct(productList.get(position));
        ((MainActivity) getActivity()).initProductDetailFragment();
      }
    }
  }
}
