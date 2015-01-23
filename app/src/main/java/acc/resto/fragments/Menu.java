package acc.resto.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;

import acc.resto.R;
import acc.resto.adapter.MenuAdapter;

/**
 * Created by Sagar Gopale on 1/13/2015.
 */
public class Menu extends Fragment {

    private int pageNumber;
    private String title;
    private Context mContext;
    private ParseQueryAdapter<ParseObject> mainAdapter;
    private MenuAdapter menuAdapter;
    private ListView listView;

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
        ParseObject.registerSubclass(acc.resto.model.Menu.class);
        pageNumber = getArguments().getInt("menuPageNumber");
        title = getArguments().getString("menuTitle");



    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.menu_list, container , false);
        mainAdapter = new ParseQueryAdapter<ParseObject>(getActivity(), "Menu");
        mainAdapter.setTextKey("type");
        mainAdapter.setImageKey("image");

        menuAdapter = new MenuAdapter(getActivity());

        listView = (ListView) view.findViewById(R.id.listView2);
        listView.setAdapter(mainAdapter);
        mainAdapter.loadObjects();

        return view;
    }
}
