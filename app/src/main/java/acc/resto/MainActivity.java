package acc.resto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;

import com.facebook.AppEventsLogger;

import net.hockeyapp.android.FeedbackManager;
import net.hockeyapp.android.Tracking;

public class MainActivity extends Activity {

    private static int SPLASH_TIME_OUT = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            /*
             * Showing splash screen with a timer and displaying website name.
             */
            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app next activity
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(i);
                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
    @Override
    protected void onResume() {
        super.onResume();
        Tracking.startUsage(this);
        // Logs 'install' and 'app activate' App Events.
        AppEventsLogger.activateApp(this);
    }
    @Override
    protected void onPause() {
        Tracking.stopUsage(this);
        super.onPause();

        // Logs 'app deactivate' App Event.
        AppEventsLogger.deactivateApp(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void checkForCrashes() {
       // CrashManager.register(this, APP_ID);
    }

    private void checkForUpdates() {
        // Remove this for store / production builds!
       // UpdateManager.register(this, APP_ID);
    }

    public void showFeedbackActivity() {
       // FeedbackManager.register(this, HOCKEYAPP_ID, null);
        FeedbackManager.showFeedbackActivity(this);
    }

}
