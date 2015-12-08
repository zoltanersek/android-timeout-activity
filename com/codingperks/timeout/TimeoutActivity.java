package com.codingperks.timeout;

import android.app.Activity;
import de.greenrobot.event.EventBus;


public abstract class TimeoutActivity extends Activity {

  protected abstract void onTimeout();

  protected abstract long getTimeoutInSeconds();

  @Override protected void onResume() {
    super.onResume();
    EventBus.getDefault().register(this);
    Timeout timeout = Timeout.getInstance(this, getTimeoutInSeconds());
    boolean isTimeout = timeout.interact();
    if (isTimeout) {
      timeout.resetTimeout();
      onTimeout();
    }
  }

  public void onEventMainThread(OnTimeoutEvent event) {
    Timeout.getInstance(this, getTimeoutInSeconds()).resetTimeout();
    onTimeout();
  }

  @Override protected void onPause() {
    super.onPause();
    EventBus.getDefault().unregister(this);
  }

  @Override public void onUserInteraction() {
    super.onUserInteraction();
    Timeout.getInstance(this, getTimeoutInSeconds()).interact();
  }
}
