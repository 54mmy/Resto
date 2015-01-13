package acc.resto.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by Sagar Gopale on 1/13/2015.
 */
public class About extends Fragment {

    private int pageNumber;
    private String title;
    private Context mContext;

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
}
