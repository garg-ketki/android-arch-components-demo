package com.example.android_arch_components_demo.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.android_arch_components_demo.db.dao.CommentDao;
import com.example.android_arch_components_demo.db.dao.ProductDao;
import com.example.android_arch_components_demo.db.entity.Comment;
import com.example.android_arch_components_demo.db.entity.Product;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by ketkigarg on 23/01/18.
 */

@Database(entities = {Comment.class, Product.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
  private static final String TAG = AppDatabase.class.getSimpleName();
  private static AppDatabase INSTANCE;

  public static AppDatabase getInstance(Context context) {
    if (INSTANCE == null) {
      synchronized (AppDatabase.class) {
        if (INSTANCE == null) {
          INSTANCE = Room.databaseBuilder(context, AppDatabase.class, "db_product").build();
        }
      }
    }
    return INSTANCE;
  }

  public abstract CommentDao getCommentDao();

  public abstract ProductDao getProductDao();

  public void mock() {
    new InsertionAsyncTask().execute(INSTANCE);
  }

  class InsertionAsyncTask extends AsyncTask<AppDatabase, Void, Void> {

    @Override
    protected Void doInBackground(AppDatabase... appDatabases) {
      ProductDao productDao = appDatabases[0].getProductDao();
      productDao.deleteAll();
      CommentDao commentDao = appDatabases[0].getCommentDao();
      for (int i = 0; i < 10; i++) {
        Product product = new Product();
        product.setName("Name" + i);
        product.setDescription("Description" + i);
        product.setPrice(i);
        long id = productDao.insertProduct(product);
        ArrayList<Comment> comments = new ArrayList<>();
        for (int j = 0; j < 3; j++) {
          Comment comment = new Comment();
          comment.setText("comment text: " + i + j);
          comment.setProductId(id);
          comment.setPostedAt(new Date(System.currentTimeMillis()));
          comments.add(comment);
        }
        commentDao.insert(comments);
      }
      Log.v(TAG, productDao.getAllProducts().toString());
      return null;
    }
  }
}
