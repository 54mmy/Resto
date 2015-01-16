package acc.resto.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;

/**
 * Created by Sagar Gopale on 1/13/2015.
 */
public class Menu extends ListFragment {

    private int pageNumber;
    private String title;
    private Context mContext;

    public static Menu newInstance(int pageNumber,String title)
    {
        Menu menu = new Menu();
        Bundle b = new Bundle();
        b.putInt("menuPageNumber",pageNumber);
        b.putString("menuTitle",title);
        menu.setArguments(b);
        return menu;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();

        pageNumber = getArguments().getInt("menuPageNumber");
        title = getArguments().getString("menuTitle");

    }
}
