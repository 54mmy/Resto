package acc.resto;

import android.app.Activity;
import android.content.Intent;
import android.media.Rating;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseObject;

import acc.resto.model.Reviews;

/**
 * Created by Sagar Gopale on 1/9/2015.
 */
public class WriteReview extends Activity {
    EditText review;
    ImageButton imageButton;
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addreview);
        ParseObject.registerSubclass(Reviews.class);

        String dishes[] = getResources().getStringArray(R.array.dishName);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dishes);
        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.dish);
        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView.setThreshold(1);

        review = (EditText) findViewById(R.id.review);
        imageButton = (ImageButton) findViewById(R.id.imageButton2);
        addListenerOnRatingBar();
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = autoCompleteTextView.getText().toString();
                String rev = review.getText().toString();

                if(name.length()>0 && rev.length()>0) {
                    Reviews r = new Reviews();
                    r.setDish(name);
                    r.setReview(rev);
                    r.saveInBackground();
                    Toast.makeText(getApplicationContext(), "Thank you for Submitting your review...!", Toast.LENGTH_LONG).show();
                    backToReviewList();
                } else {
                    Toast.makeText(getApplicationContext(), "Fields cannot be left blank", Toast.LENGTH_LONG).show();
                }
                autoCompleteTextView.getText().clear();
                review.getText().clear();

            }
        });
    }
    public void addListenerOnRatingBar() {

       RatingBar ratingBar = (RatingBar) findViewById(R.id.rating);        //if rating value is changed,
        //display the current rating value in the result (textview) automatically
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {

                Toast.makeText(getApplicationContext(), String.valueOf(rating), Toast.LENGTH_LONG).show();

            }
        });
    }

    public void backToReviewList() {
        Intent i = new Intent(this, ListReviews.class);
        startActivity(i);
    }
}
