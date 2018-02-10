package com.example.android_arch_components_demo.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.android_arch_components_demo.db.entity.Comment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ketkigarg on 23/01/18.
 */

@Dao
public interface CommentDao {

  @Query("Select * from COMMENT WHERE productId=:productId")
  LiveData<List<Comment>> getAllComments(long productId);

  @Query("delete from COMMENT")
  void deleteAll();

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  Long[] insert(ArrayList<Comment> comments);
}
