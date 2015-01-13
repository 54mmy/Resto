package acc.resto.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by Sagar Gopale on 1/13/2015.
 */
public class Offers extends Fragment {

    private int pageNumber;
    private String title;
    private Context mContext;

    public static Offers newInstance(int pageNumber , String title)
    {
        Offers offers = new Offers();
        Bundle b =new Bundle();
        b.putInt("offersPageNumber",pageNumber);
        b.putString("offersTitle",title);
        offers.setArguments(b);
        return offers;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();

        pageNumber = getArguments().getInt("offersPageNumber");
        title = getArguments().getString("offersTitle");

    }
}
