package acc.resto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.parse.ParseObject;

import acc.resto.model.Reviews;

/**
 * Created by Sagar Gopale on 1/9/2015.
 */
public class WriteReview extends Activity {
    EditText review;
    ImageButton imageButton;
    AutoCompleteTextView a1;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addreview);
        ParseObject.registerSubclass(Reviews.class);

        String dishes[] = getResources().getStringArray(R.array.dishName);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dishes);
        a1 = (AutoCompleteTextView) findViewById(R.id.dish);
        a1.setAdapter(adapter);
        a1.setThreshold(1);

        review = (EditText) findViewById(R.id.review);
        imageButton = (ImageButton) findViewById(R.id.imageButton2);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = a1.getText().toString();
                String rev = review.getText().toString();

                if(name.length()>0 && rev.length()>0)
                {
                    Reviews r = new Reviews();
                    r.setDish(name);
                    r.setReview(rev);
                    r.saveInBackground();
                    Toast.makeText(getApplicationContext(), "Thank you for Submitting your review...!", Toast.LENGTH_LONG).show();
                    fireBack();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Fields cannot be left blank", Toast.LENGTH_LONG).show();
                }
                a1.getText().clear();
                review.getText().clear();

            }
        });
    }
    public void fireBack()
    {
        Intent i = new Intent(this, ListReviews.class);
        startActivity(i);

    }
}
