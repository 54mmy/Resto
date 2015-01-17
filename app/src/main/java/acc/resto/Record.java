package acc.resto;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.facebook.FacebookRequestError;
import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.model.GraphUser;
import com.parse.ParseException;
import com.parse.ParseFacebookUtils;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class Record extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Session session = ParseFacebookUtils.getSession();
        if(session != null && session.isOpened()) {
            makeMeRequest();
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser != null) {
            // Check if the user is currently logged
            // and show any cached content
            startNextActivity();
        } else {
            // If the user is not logged in, go to the
            // activity showing the login view.
            startLoginActivity();
        }
    }

    private void makeMeRequest() {
        Request request = Request.newMeRequest(ParseFacebookUtils.getSession(), new Request.GraphUserCallback() {
            @Override
            public void onCompleted(GraphUser user, Response response) {
                if(user != null) {
                   // JSONObject jsonObject = new JSONObject();
                    ParseUser parseUser = new ParseUser();
                    try {
    //                    jsonObject.put("facebook id",user.getId());
    //                    jsonObject.put("Name",user.getName());
                        parseUser.setUsername(user.getUsername());
                        parseUser.setPassword("");
                        parseUser.put("facebookId",user.getId());
                        parseUser.put("name",user.getName());
                        parseUser.put("location",user.getLocation());
                        parseUser.setEmail((String) response.getGraphObject().getProperty("email"));
                        parseUser.put("email",(String) response.getGraphObject().getProperty("email"));


/*                        if(user.getLocation().getProperty("name")!=null){
                            jsonObject.put("location",(String) user.getLocation().getProperty("name"));
                            parseUser.put("location",(String) response.getGraphObject().getProperty("location"));
                        }
                        if (user.getProperty("email") != null) {
                            jsonObject.put("email", user.getProperty("email"));
                            parseUser.put("email", (String) response.getGraphObject().getProperty("email"));
                        }*/

    //                    currentUser.put("profile",jsonObject);
    //                    currentUser.saveInBackground();
                        parseUser.signUpInBackground(new SignUpCallback() {
                            @Override
                            public void done(ParseException e) {
                                if (e == null) {
                                    startNextActivity();
                                }
                            }
                        });

                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "Error Parsing Info", Toast.LENGTH_LONG).show();
                    }

                } else if(response.getError()!=null){
                    if ((response.getError().getCategory() == FacebookRequestError.Category.AUTHENTICATION_RETRY) ||
                            (response.getError().getCategory() == FacebookRequestError.Category.AUTHENTICATION_REOPEN_SESSION)) {
                        Toast.makeText(getApplicationContext(), "The Session was Invalidated", Toast.LENGTH_LONG).show();

                    } else {
                        Toast.makeText(getApplicationContext(), "Unxpected Error", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
    private void startNextActivity() {
        Intent intent = new Intent(this,UserHome.class);
        startActivity(intent);
        finish();
    }

    private void startLoginActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
