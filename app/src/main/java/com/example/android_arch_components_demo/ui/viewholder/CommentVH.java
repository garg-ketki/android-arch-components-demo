package com.example.android_arch_components_demo.ui.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.android_arch_components_demo.R;


/**
 * Created by ketkigarg on 23/01/18.
 */

public class CommentVH extends RecyclerView.ViewHolder {
  public TextView textTV, postedAtTV;

  public CommentVH(View itemView) {
    super(itemView);
    textTV = itemView.findViewById(R.id.tv_text);
    postedAtTV = itemView.findViewById(R.id.tv_postedAt);
  }
}
