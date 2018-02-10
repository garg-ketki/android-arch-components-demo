package com.example.android_arch_components_demo.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.example.android_arch_components_demo.db.typeconverter.DateConverter;

import java.util.Date;

/**
 * Created by ketkigarg on 23/01/18.
 */

@Entity(foreignKeys = {
    @ForeignKey(entity = Product.class, childColumns = "productId",
        parentColumns = "id", onDelete = ForeignKey.CASCADE)
})
public class Comment {
  @PrimaryKey(autoGenerate = true)
  private long id;
  private long productId;
  private String text;
  @TypeConverters(DateConverter.class)
  private Date postedAt;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getProductId() {
    return productId;
  }

  public void setProductId(long productId) {
    this.productId = productId;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Date getPostedAt() {
    return postedAt;
  }

  public void setPostedAt(Date postedAt) {
    this.postedAt = postedAt;
  }
}
