package acc.resto.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.facebook.FacebookRequestError;
import com.facebook.HttpMethod;
import com.facebook.Request;
import com.facebook.RequestAsyncTask;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionLoginBehavior;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;
import com.facebook.model.GraphLocation;
import com.facebook.model.GraphUser;
import com.parse.ParseObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import acc.resto.ListReviews;
import acc.resto.R;
import acc.resto.Reviews;

/**
 * Created by Sagar Gopale on 1/11/2015.
 */
public class Review extends Fragment {


    private static final String TAG="Review";
    private UiLifecycleHelper uiHelper;

    private Session.StatusCallback callback = new Session.StatusCallback() {
        @Override
        public void call(Session session, SessionState state, Exception exception) {
            onSessionStateChange(session,state,exception);
        }
    };

    private AutoCompleteTextView a1;
    private EditText editText;
    private ImageButton shareButton;
    private static final List<String> PERMISSIONS = Arrays.asList("publish_actions");
    private static final String PENDING_PUBLISH_KEY = "pendingPublishReauthorization";
    private boolean pendingPublishReauthorization = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.addreview, container , false);

        ParseObject.registerSubclass(Reviews.class);
        String dishes[] = getResources().getStringArray(R.array.dishName);


        shareButton = (ImageButton) view.findViewById(R.id.imageButton2);
        a1 = (AutoCompleteTextView) view.findViewById(R.id.dish);
        a1.setAdapter(new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1 , dishes));
        a1.setThreshold(1);

        editText = (EditText) view.findViewById(R.id.review);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dish = a1.getText().toString();
                String rev = editText.getText().toString();

                if(dish.length()>0 && rev.length() > 0)
                {
                    Reviews r = new Reviews();
                    r.setDish(dish);
                    r.setReview(rev);
                    r.saveInBackground();
                    publishStory(rev, dish);
                    Toast.makeText(getActivity().getApplicationContext(), "Thank you for Submitting your review...!", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getActivity().getApplicationContext(), "Fields cannot be left blank", Toast.LENGTH_LONG).show();
                }
                a1.getText().clear();
                editText.getText().clear();

            }
        });

        if(savedInstanceState!=null) {
            pendingPublishReauthorization = savedInstanceState.getBoolean(PENDING_PUBLISH_KEY,false);
        }
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        uiHelper = new UiLifecycleHelper(getActivity() , callback);
        uiHelper.onCreate(savedInstanceState);
    }
    @Override
    public void onResume() {
        super.onResume();

        Session session = Session.getActiveSession();
        if (session != null &&
                (session.isOpened() || session.isClosed()) ) {
            onSessionStateChange(session, session.getState(), null);
        }

        uiHelper.onResume();
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        uiHelper.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onPause() {
        super.onPause();
        uiHelper.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        uiHelper.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(PENDING_PUBLISH_KEY, pendingPublishReauthorization);
        uiHelper.onSaveInstanceState(outState);
    }

    private void onSessionStateChange(Session session, SessionState state, Exception exception) {
        if (state.isOpened()) {
            shareButton.setVisibility(View.VISIBLE);
            if (pendingPublishReauthorization &&
                    state.equals(SessionState.OPENED_TOKEN_UPDATED)) {
                pendingPublishReauthorization = false;
                //publishStory();
            }
        } else if (state.isClosed()) {
            shareButton.setVisibility(View.INVISIBLE);
        }
    }

    private void publishStory(String review , String dish) {
        Session currentSession = Session.getActiveSession();

        if(currentSession != null) {
            Session session = new Session.Builder(getActivity()).build();
            Session.setActiveSession(session);
            currentSession = session;
        }

        if(currentSession != null && currentSession.isOpened()) {

            Session.OpenRequest op = new Session.OpenRequest(this);
            op.setLoginBehavior(SessionLoginBehavior.SUPPRESS_SSO);
            op.setCallback(callback);

            List<String> permissions = new ArrayList<String>();
            permissions.add("publish_stream");
            op.setPermissions(permissions);

            Session session = new Session.Builder(getActivity()).build();
            Session.setActiveSession(session);
            session.openForPublish(op);

            Bundle postParams = new Bundle();
            postParams.putString("name", dish);
            postParams.putString("message",review);
            postParams.putString("caption", "Resto");
            postParams.putString("description","New App");
            postParams.putString("link", "");
            postParams.putString("picture", "");

            Request.Callback callback = new Request.Callback() {
                public void onCompleted(Response response) {
                    JSONObject graphResponse = response
                            .getGraphObject()
                            .getInnerJSONObject();
                    String postId = null;
                    try {
                        postId = graphResponse.getString("id");
                    } catch (JSONException e) {
                        Log.i(TAG,
                                "JSON error " + e.getMessage());
                    }
                    FacebookRequestError error = response.getError();
                    if (error != null) {
                        Toast.makeText(getActivity()
                                        .getApplicationContext(),
                                error.getErrorMessage(),
                                Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getActivity()
                                        .getApplicationContext(),
                                postId,
                                Toast.LENGTH_LONG).show();
                    }
                }
            };

            Request request = new Request(currentSession, "me/feed", postParams, HttpMethod.POST, callback);

            RequestAsyncTask task = new RequestAsyncTask(request);
            task.execute();
            fireBack();
        }
        /*if (currentSession != null) {

            // Check for publish permissions
            List<String> permissions = currentSession.getPermissions();
            if (!isSubsetOf(PERMISSIONS, permissions)) {
                pendingPublishReauthorization = true;
                Session.NewPermissionsRequest newPermissionsRequest = new Session.NewPermissionsRequest(Review.this, PERMISSIONS);
                currentSession.requestNewPublishPermissions(newPermissionsRequest);
                return;
            }
        }*/
    }

    private void fireBack() {
        Intent i = new Intent(getActivity().getApplicationContext(), ListReviews.class);
        startActivity(i);
    }

    private boolean isSubsetOf(Collection<String> subset, Collection<String> superset) {
        for (String string : subset) {
            if (!superset.contains(string)) {
                return false;
            }
        }
        return true;
    }
}
