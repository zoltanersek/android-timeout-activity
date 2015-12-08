package com.codingperks.timeout;

import android.util.Log;


public class TLog {
  private static final String TAG = "Timeout Events";

  private TLog() {
    // no instances
  }

  public static void log(String message) {
    Log.d(TAG, message);
  }
}
