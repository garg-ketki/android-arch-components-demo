package com.example.android_arch_components_demo.db.typeconverter;


import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * Created by ketkigarg on 23/01/18.
 */
public class DateConverter {
  @TypeConverter
  public Long toLong(Date date) {
    return date == null ? null : date.getTime();
  }

  @TypeConverter
  public Date toDate(Long time) {
    return time == null ? null : new Date(time);
  }
}
