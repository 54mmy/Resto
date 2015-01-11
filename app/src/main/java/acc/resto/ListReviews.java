package acc.resto;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

import acc.resto.Adapter.CustomAdapter;

/**
 * Created by Sagar Gopale on 1/9/2015.
 */
public class ListReviews extends Activity {
    public static final String NO_RESULT = "No Reviews Yet";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listreview);

        ParseObject.registerSubclass(Reviews.class);

        final CustomAdapter customAdapter = new CustomAdapter(this, new ArrayList<Reviews>());
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(customAdapter);

        ParseQuery<Reviews> query = ParseQuery.getQuery(Reviews.class);
        query.findInBackground(new FindCallback<Reviews>() {

            @Override
            public void done(List<Reviews> reviewses, ParseException e) {
                if (reviewses != null) {
                    customAdapter.clear();
                    customAdapter.addAll(reviewses);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.list, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_review:
                addReview();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    public void addReview()
    {
        Intent i = new Intent(this, WriteReview.class);
        startActivity(i);
    }
}

