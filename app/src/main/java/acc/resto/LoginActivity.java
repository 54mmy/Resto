package acc.resto;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseFacebookUtils;
import com.parse.ParseUser;
import com.viewpagerindicator.CirclePageIndicator;

import org.apache.http.client.CircularRedirectException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import acc.resto.adapter.ScreenSlidePagerAdapter;

public class LoginActivity extends FragmentActivity {

    private EditText editText;
    private Dialog progressDialog;
    private static  final int PAGES  = 3;
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;
    int position = 0;
    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        public void run() {
            if( position >= 4){
                position = 0;
            } else {
                position = position+1;
            }
            mPager.setCurrentItem(position, true);
            handler.postDelayed(runnable, 10000);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login);

//        Parse.enableLocalDatastore(this);
 //       Parse.initialize(this, "G9RoZuVR9RNmNcw5Mppcnao6TrvF5QaAVUqrf5OI", "WYjiqHNRZtSo7xifBr0HmljpWJdytXePCsfCfTBM");

       // editText = (EditText) findViewById(R.id.editText);

        ParseUser currentUser = ParseUser.getCurrentUser();
        if((currentUser!=null) && ParseFacebookUtils.isLinked(currentUser)){
            showAct();
        }

        mPager =  (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        CirclePageIndicator circlePageIndicator = (CirclePageIndicator) findViewById(R.id.indicator);
        mPager.setAdapter(mPagerAdapter);
        circlePageIndicator.setViewPager(mPager);

    }


    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ParseFacebookUtils.finishAuthentication(requestCode, resultCode , data);
    }

    public void OnClick(View v) {
        progressDialog = ProgressDialog.show(LoginActivity.this, "", "Logging IN..", true);
        List<String> permissions = new ArrayList<String>();
        permissions.add("public_profile");
        permissions.add("user_location");
        permissions.add("email");

        ParseFacebookUtils.logIn(permissions, this, new LogInCallback() {
            @Override
            public void done(ParseUser parseUser, ParseException e) {
                progressDialog.dismiss();
                if(parseUser == null) {
                    Toast.makeText(getApplicationContext(), "User Login Unsuccessful", Toast.LENGTH_LONG).show();
                } else if (parseUser.isNew()) {
                    Toast.makeText(getApplicationContext(), "Logged IN", Toast.LENGTH_LONG).show();
                    getData();
                } else {
                    Toast.makeText(getApplicationContext(), "Logged IN", Toast.LENGTH_LONG).show();
                    showAct();
                }
            }
        });
    }

    public void getData() {
        Intent intent = new Intent(this, Record.class);
        startActivity(intent);
        finish();
    }

    public void showAct() {
        Intent intent = new Intent(this,UserHome.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(runnable, 10000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (handler!= null) {
            handler.removeCallbacks(runnable);
        }
    }
}
