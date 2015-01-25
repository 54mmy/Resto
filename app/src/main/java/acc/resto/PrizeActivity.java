package acc.resto;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Toast;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseImageView;
import com.parse.ParseObject;
import com.parse.ParseQuery;


public class PrizeActivity extends Activity {

    private SharedPreferences preferences;
    private Context mContext;
    private ParseImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prize_win);

        imageView = (ParseImageView) findViewById(R.id.prizeImg);
        mContext = this;
        preferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        int count = preferences.getInt("visit_count", 0);

        switch (count) {
            case 2:
                UserVisits.btn.setText("2");
                ParseQuery query1 = new ParseQuery("VisitOffers");
                query1.getInBackground("spS8EKSH5z", new GetCallback<ParseObject>() {
                    public void done(ParseObject object, ParseException e) {
                        if (e == null) {
                            ParseFile fileObject = object.getParseFile("image");
                            imageView.setParseFile(fileObject);
                            imageView.loadInBackground();
                        } else {
                            Toast.makeText(getApplicationContext(),"Check internet connection",Toast.LENGTH_LONG).show();
                        }
                    }
                });

                break;

            case 3:
                UserVisits.btn.setText("3");
                ParseQuery query2 = new ParseQuery("VisitOffers");
                query2.getInBackground("nxWKwumkNl", new GetCallback<ParseObject>() {
                    public void done(ParseObject object, ParseException e) {
                        if (e == null) {
                            ParseFile fileObject = object.getParseFile("image");
                            imageView.setParseFile(fileObject);
                            imageView.loadInBackground();
                           } else {
                            Toast.makeText(getApplicationContext(),"Check internet connection",Toast.LENGTH_LONG).show();
                        }
                    }
                });
                break;

            case 4:
                UserVisits.btn.setText("4");
                ParseQuery query3 = new ParseQuery("VisitOffers");
                query3.getInBackground("UYdHUxrGdW", new GetCallback<ParseObject>() {
                    public void done(ParseObject object, ParseException e) {
                        if (e == null) {
                            ParseFile fileObject = (ParseFile) object.getParseFile("image");
                            imageView.setParseFile(fileObject);
                            imageView.loadInBackground();
                        } else {
                            Toast.makeText(getApplicationContext(),"Check internet connection",Toast.LENGTH_LONG).show();
                        }
                    }
                });
                break;

            case 5:
                UserVisits.btn.setText("5");
                ParseQuery query4 = new ParseQuery("VisitOffers");
                query4.getInBackground("Zzq2kzPKDv", new GetCallback<ParseObject>() {
                    public void done(ParseObject object, ParseException e) {
                        if (e == null) {
                            ParseFile fileObject = object.getParseFile("image");
                            imageView.setParseFile(fileObject);
                            imageView.loadInBackground();
                        } else {
                            Toast.makeText(getApplicationContext(),"Check internet connection",Toast.LENGTH_LONG).show();
                        }
                    }
                });
                break;

            case 6:
                UserVisits.btn.setText("6");
                ParseQuery query5 = new ParseQuery("VisitOffers");
                query5.getInBackground("XsAYSp9JkB", new GetCallback<ParseObject>() {
                    public void done(ParseObject object, ParseException e) {
                        if (e == null) {
                            ParseFile fileObject = object.getParseFile("image");
                            imageView.setParseFile(fileObject);
                            imageView.loadInBackground();
                        } else {
                            Toast.makeText(getApplicationContext(),"Check internet connection",Toast.LENGTH_LONG).show();
                        }
                    }
                });
                break;

            case 7:
                UserVisits.btn.setText("7");
                ParseQuery query6= new ParseQuery("VisitOffers");
                query6.getInBackground("oUFK77wAtH", new GetCallback<ParseObject>() {
                    public void done(ParseObject object, ParseException e) {
                        if (e == null) {
                            ParseFile fileObject = object.getParseFile("image");
                            imageView.setParseFile(fileObject);
                            imageView.loadInBackground();
                        } else {
                            Toast.makeText(getApplicationContext(),"Check internet connection",Toast.LENGTH_LONG).show();
                        }
                    }
                });
                break;

            case 8:
                UserVisits.btn.setText("8");
                ParseQuery query7 = new ParseQuery("VisitOffers");
                query7.getInBackground("AhGZCWXdf0", new GetCallback<ParseObject>() {
                    public void done(ParseObject object, ParseException e) {
                        if (e == null) {
                            ParseFile fileObject = object.getParseFile("image");
                            imageView.setParseFile(fileObject);
                            imageView.loadInBackground();
                        } else {
                            Toast.makeText(getApplicationContext(),"Check internet connection",Toast.LENGTH_LONG).show();
                        }
                    }
                });

                break;

            case 9:
                UserVisits.btn.setText("9");
                ParseQuery query8 = new ParseQuery("VisitOffers");
                query8.getInBackground("D2sYBnaqma", new GetCallback<ParseObject>() {
                    public void done(ParseObject object, ParseException e) {
                        if (e == null) {
                            ParseFile fileObject = object.getParseFile("image");
                            imageView.setParseFile(fileObject);
                            imageView.loadInBackground();
                        } else {
                            Toast.makeText(getApplicationContext(),"Check internet connection",Toast.LENGTH_LONG).show();
                        }
                    }
                });

                break;

            case 10:
                UserVisits.btn.setText("10");
                ParseQuery query9 = new ParseQuery("VisitOffers");
                query9.getInBackground("BGYARZ5Utv", new GetCallback<ParseObject>() {
                    public void done(ParseObject object, ParseException e) {
                        if (e == null) {
                            ParseFile fileObject = object.getParseFile("image");
                            imageView.setParseFile(fileObject);
                            imageView.loadInBackground();
                        } else {
                            Toast.makeText(getApplicationContext(),"Check internet connection",Toast.LENGTH_LONG).show();
                        }
                    }
                });

                break;

            case 11:
                UserVisits.btn.setText("");
                UserVisits.btn.setBackgroundResource(R.drawable.thank_you);
                ParseQuery query10 = new ParseQuery("VisitOffers");
                query10.getInBackground("LCVAVc5LiD", new GetCallback<ParseObject>() {
                    public void done(ParseObject object, ParseException e) {
                        if (e == null) {
                            ParseFile fileObject = object.getParseFile("image");
                            imageView.setParseFile(fileObject);
                            imageView.loadInBackground();
                        } else {
                            Toast.makeText(getApplicationContext(),"Check internet connection",Toast.LENGTH_LONG).show();
                        }
                    }
                });
                break;
            default:
        }
    }
}