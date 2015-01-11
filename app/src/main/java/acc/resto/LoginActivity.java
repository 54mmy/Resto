package acc.resto;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseFacebookUtils;
import com.parse.ParseUser;

import java.util.List;
import java.util.Arrays;
import java.util.Vector;

import acc.resto.Adapter.ScreenSlidePagerAdapter;

public class LoginActivity extends FragmentActivity {

    private EditText editText;
    private Dialog progressDialog;
    private static  final int PAGES  = 3;
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login);

        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "G9RoZuVR9RNmNcw5Mppcnao6TrvF5QaAVUqrf5OI", "WYjiqHNRZtSo7xifBr0HmljpWJdytXePCsfCfTBM");

       // editText = (EditText) findViewById(R.id.editText);

        ParseUser currentUser = ParseUser.getCurrentUser();
        if((currentUser!=null) && ParseFacebookUtils.isLinked(currentUser)){
            showAct();
        }

        mPager =  (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

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

    public void OnClick(View v)
    {

        progressDialog = ProgressDialog.show(LoginActivity.this, "", "Logging IN..", true);
        List<String> permissions = Arrays.asList("public_profile","user_about_me","user_relationships","user_location","email");

        ParseFacebookUtils.logIn(permissions, this, new LogInCallback() {
            @Override
            public void done(ParseUser parseUser, ParseException e) {
                progressDialog.dismiss();
                if(parseUser == null)
                {
                    Toast.makeText(getApplicationContext(), "User Login Unsuccessful", Toast.LENGTH_LONG).show();
                }
                else if (parseUser.isNew())
                {
                    Toast.makeText(getApplicationContext(), "Logged IN", Toast.LENGTH_LONG).show();
                    getData();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Logged IN", Toast.LENGTH_LONG).show();
                    showAct();
                }
            }
        });

    }

    public void getData()
    {
        Intent intent = new Intent(this,Record.class);
        startActivity(intent);
    }
    public void showAct()
    {
        Intent intent = new Intent(this,ListReviews.class);
        startActivity(intent);
    }
}

