package com.example.android_arch_components_demo.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android_arch_components_demo.R;
import com.example.android_arch_components_demo.db.entity.Comment;
import com.example.android_arch_components_demo.ui.viewholder.CommentVH;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by ketkigarg on 23/01/18.
 */

public class CommentRecyclerViewAdapter extends RecyclerView.Adapter<CommentVH> {
  private List<Comment> commentList;

  public CommentRecyclerViewAdapter(List<Comment> commentList) {
    this.commentList = commentList;
  }

  @Override
  public CommentVH onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_comment_info,
        parent, false);
    return new CommentVH(view);
  }

  @Override
  public void onBindViewHolder(CommentVH holder, int position) {
    Comment comment = commentList.get(position);
    holder.textTV.setText(comment.getText());
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
    String date = dateFormat.format(comment.getPostedAt());
    holder.postedAtTV.setText(date);
  }

  @Override
  public int getItemCount() {
    return commentList.size();
  }

  public void modifyList(List<Comment> comments) {
    this.commentList.clear();
    this.commentList = comments;
    notifyDataSetChanged();
  }
}
