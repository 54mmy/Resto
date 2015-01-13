package acc.resto;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;


public class PrizeWin extends ActionBarActivity {

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private Context mContext;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prize_win);

        imageView = (ImageView) findViewById(R.id.prizeImg);
        mContext = this;
        preferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        int count = preferences.getInt("visit_count", 0);

        switch (count) {
            case 2:
                imageView.setImageResource(R.drawable.coke);
                break;

            case 3:
                imageView.setImageResource(R.drawable.pepsi);
                break;

            case 4:
                imageView.setImageResource(R.drawable.icedcoffee);
                break;

            case 5:
                imageView.setImageResource(R.drawable.sandwitch);
                break;

            case 6:
                imageView.setImageResource(R.drawable.manchurien);
                break;

            case 7:
                imageView.setImageResource(R.drawable.sandwitch);
                break;

            case 8:
                imageView.setImageResource(R.drawable.meal);
                break;

            case 9:
                imageView.setImageResource(R.drawable.pancake);
                break;

            case 10:
                imageView.setImageResource(R.drawable.mexican_food);
                break;

            default:
                imageView.setImageResource(R.drawable.thankyou);
                break;

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_prize_win, menu);
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
}