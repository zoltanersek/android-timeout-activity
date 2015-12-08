package com.codingperks.timeout;

import android.content.Context;
import android.content.SharedPreferences;


public class Cookie {

  public static final long INVALID_TIMESTAMP = -1;
  private static final String PREFERENCES_FILE_KEY = "cookies";
  private String id;
  private Context context;

  public Cookie(Context context, String id) {
    this.id = id;
    this.context = context.getApplicationContext();
  }

  public String getId() {
    return id;
  }

  public void write(long timestamp) {
    SharedPreferences sharedPreferences =
        context.getSharedPreferences(PREFERENCES_FILE_KEY, Context.MODE_PRIVATE);
    sharedPreferences.edit().putLong(id, timestamp).commit();
  }

  public long read() {
    SharedPreferences sharedPreferences =
        context.getSharedPreferences(PREFERENCES_FILE_KEY, Context.MODE_PRIVATE);
    long timestamp = sharedPreferences.getLong(id, INVALID_TIMESTAMP);
    return timestamp;
  }
}
