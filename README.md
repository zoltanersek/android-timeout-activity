# android-timeout-activity
An activity that implements user inactivity timeout. 
Used for example when you want to logout the user after a specific timeout

Uses greenrobot's EventBus

# Usage

Inherit from TimeoutActivity

    public class TestActivity extends TimeoutActivity {
      
      @Override protected void onTimeout() {
        // do stuff  
      }

      @Override protected long getTimeoutInSeconds() {
        return 15 * 60; // 15 minutes
      }
      
    }
