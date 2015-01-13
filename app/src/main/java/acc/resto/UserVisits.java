package acc.resto;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class UserVisits extends Fragment {

    private Button one, two, three, four, five, six, seven, eight, nine, ten;
    private SharedPreferences preferences;
    private Context mContext;
    private int pageNumber;
    private String title;


    private static final String VISIT_COUNT = "visit_count";

    public static UserVisits newInstance(int pageNumber, String title)
    {
        UserVisits userVisits = new UserVisits();
        Bundle b =new Bundle();
        b.putInt("offersPageNumber",pageNumber);
        b.putString("offersTitle",title);
        userVisits.setArguments(b);
        return userVisits;

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_user_visits, container , false);

        one = (Button) view.findViewById(R.id.one);
        two = (Button) view.findViewById(R.id.two);
        three = (Button) view.findViewById(R.id.three);
        four = (Button) view.findViewById(R.id.four);
        five = (Button) view.findViewById(R.id.five);
        six = (Button) view.findViewById(R.id.six);
        seven = (Button) view.findViewById(R.id.seven);
        eight = (Button) view.findViewById(R.id.eight);
        nine = (Button) view.findViewById(R.id.nine);
        ten = (Button) view.findViewById(R.id.ten);

        return view;
    }
/*
    @Override
    private void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_visits);

        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        ten = (Button) findViewById(R.id.ten);

    }
*/

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();

        pageNumber = getArguments().getInt("offersPageNumber");
        title = getArguments().getString("offersTitle");

    }
    @Override
    public void onResume() {
        super.onResume();

        mContext = getActivity().getApplicationContext();
        preferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        int count = preferences.getInt(VISIT_COUNT, 0);

        switch (count) {
            case 1:
                one.setEnabled(true);
                //one.setBackgroundColor(Color.WHITE);
                break;
            case 2:
                one.setEnabled(false);
                one.setBackgroundColor(Color.GRAY);
                two.setEnabled(true);
                break;

            case 3:
                two.setEnabled(false);
                two.setBackgroundColor(Color.GRAY);
                three.setEnabled(true);
                break;

            case 4:
                three.setEnabled(false);
                three.setBackgroundColor(Color.GRAY);
                four.setEnabled(true);
                break;

            case 5:
                four.setEnabled(false);
                four.setBackgroundColor(Color.GRAY);
                five.setEnabled(true);
                break;

            case 6:
                five.setEnabled(false);
                five.setBackgroundColor(Color.GRAY);
                six.setEnabled(true);
                break;

            case 7:
                six.setEnabled(false);
                six.setBackgroundColor(Color.GRAY);
                seven.setEnabled(true);
                break;

            case 8:
                seven.setEnabled(false);
                seven.setBackgroundColor(Color.GRAY);
                eight.setEnabled(true);
                break;

            case 9:
                eight.setEnabled(false);
                eight.setBackgroundColor(Color.GRAY);
                nine.setEnabled(true);
                break;

            case 10:
                nine.setEnabled(false);
                ten.setEnabled(true);
                break;

            default:
                ten.setEnabled(false);
                Toast.makeText(getActivity().getApplicationContext(), "You have completed your offers",Toast.LENGTH_LONG).show();
        }


        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, SecurityCode.class);
                intent.putExtra("button_number", 2);
                startActivity(intent);
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, SecurityCode.class);
                intent.putExtra("button_number", 3);
                startActivity(intent);
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), SecurityCode.class);
                intent.putExtra("button_number", 4);
                startActivity(intent);
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), SecurityCode.class);
                intent.putExtra("button_number", 5);
                startActivity(intent);
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), SecurityCode.class);
                intent.putExtra("button_number", 6);
                startActivity(intent);
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), SecurityCode.class);
                intent.putExtra("button_number", 7);
                startActivity(intent);
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), SecurityCode.class);
                intent.putExtra("button_number", 8);
                startActivity(intent);
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), SecurityCode.class);
                intent.putExtra("button_number", 9);
                startActivity(intent);
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), SecurityCode.class);
                intent.putExtra("button_number", 10);
                startActivity(intent);
            }
        });

        ten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), SecurityCode.class);
                intent.putExtra("button_number", 11);
                startActivity(intent);
            }
        });
    }
}
