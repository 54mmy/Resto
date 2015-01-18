package acc.resto.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import acc.resto.R;

/**
 * Created by Sagar Gopale on 1/13/2015.
 */
public class About extends Fragment {

    private int pageNumber;
    private String title;
    private Context mContext;
    ImageView imageView;
    TextView textView;
    ListView listView;
    Button btn1, btn2;

    public static About newInstance(int pageNumber , String title)
    {
        About about = new About();
        Bundle b =new Bundle();
        b.putInt("aboutPageNumber",pageNumber);
        b.putString("aboutTitle",title);
        about.setArguments(b);
        return about;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();

        pageNumber = getArguments().getInt("aboutPageNumber");
        title = getArguments().getString("aboutTitle");

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.about_us, container , false);
        imageView = (ImageView) view.findViewById(R.id.abt_img);
        textView = (TextView) view.findViewById(R.id.textView);
        btn1 = (Button) view.findViewById(R.id.btn1);
        btn2 = (Button) view.findViewById(R.id.button2);

        imageView.setImageResource(R.drawable.splash_screen_logo);
        textView.setText("GrubEat app is basically help to attract customers by giving offers on visit.");

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        return view;
    }

}
