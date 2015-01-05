package acc.resto;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseFacebookUtils;
import com.parse.ParseUser;

import java.util.List;
import java.util.Arrays;

public class LoginActivity extends FragmentActivity {

    private EditText editText;
    private Dialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login);
        editText = (EditText) findViewById(R.id.editText);

        ParseUser currentUser = ParseUser.getCurrentUser();
        if((currentUser!=null) && ParseFacebookUtils.isLinked(currentUser)){
            showAct();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ParseFacebookUtils.finishAuthentication(requestCode, resultCode , data);
    }

    public void OnClick(View v)
    {

        String mNumber = editText.getText().toString();
        progressDialog = ProgressDialog.show(LoginActivity.this, "", "Logging IN..", true);
        List<String> permissions = Arrays.asList("public_profile","user_location","email");

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
        Intent intent = new Intent(this,UserVisits.class);
        startActivity(intent);
    }
}
