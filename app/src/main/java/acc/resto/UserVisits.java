package acc.resto;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class UserVisits extends Fragment {

    //private Button one, two, three, four, five, six, seven, eight, nine, ten;
    protected static Button btn;
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

        btn = (Button) view.findViewById(R.id.btn);

        preferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        int count = preferences.getInt(VISIT_COUNT, 1);
        String cnt = String.valueOf(count);

        return view;
    }

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

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preferences = PreferenceManager.getDefaultSharedPreferences(mContext);
                int count = preferences.getInt(VISIT_COUNT, 1);

                switch (count) {

                    case 1:
                        btn.setText("1");
                        Intent intent = new Intent(getActivity().getApplicationContext(), SecurityCode.class);
                        intent.putExtra("button_number", 2);
                        startActivity(intent);
                        break;

                    case 2:
                        Intent intent2 = new Intent(getActivity().getApplicationContext(), SecurityCode.class);
                        intent2.putExtra("button_number", 3);
                        startActivity(intent2);
                        break;

                    case 3:
                        Intent intent3 = new Intent(getActivity().getApplicationContext(), SecurityCode.class);
                        intent3.putExtra("button_number", 4);
                        startActivity(intent3);
                        break;

                    case 4:
                        Intent intent4 = new Intent(getActivity().getApplicationContext(), SecurityCode.class);
                        intent4.putExtra("button_number", 5);
                        startActivity(intent4);
                        break;

                    case 5:
                        Intent intent5 = new Intent(getActivity().getApplicationContext(), SecurityCode.class);
                        intent5.putExtra("button_number", 6);
                        startActivity(intent5);
                        break;

                    case 6:
                        Intent intent6 = new Intent(getActivity().getApplicationContext(), SecurityCode.class);
                        intent6.putExtra("button_number", 7);
                        startActivity(intent6);
                        break;

                    case 7:
                        Intent intent7 = new Intent(getActivity().getApplicationContext(), SecurityCode.class);
                        intent7.putExtra("button_number", 8);
                        startActivity(intent7);

                        break;

                    case 8:
                        Intent intent8 = new Intent(getActivity().getApplicationContext(), SecurityCode.class);
                        intent8.putExtra("button_number", 9);
                        startActivity(intent8);
                        break;

                    case 9:
                        Intent intent9 = new Intent(getActivity().getApplicationContext(), SecurityCode.class);
                        intent9.putExtra("button_number", 10);
                        startActivity(intent9);
                        break;

                    case 10:
                        Intent intent10 = new Intent(getActivity().getApplicationContext(), SecurityCode.class);
                        intent10.putExtra("button_number", 11);
                        startActivity(intent10);
                        break;

                    default:
                }
            }
        });
    }
}