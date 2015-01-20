package acc.resto.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import acc.resto.MainActivity;
import acc.resto.R;
import acc.resto.adapter.ListViewAdapter;

/**
 * Created by Sagar Gopale on 1/13/2015.
 */
public class Menu extends Fragment {

    private int pageNumber;
    private String title;
    private Context mContext;
    ListView listView;
    List<ParseObject> ob;
    ProgressDialog mProgressDialog;
    ListViewAdapter adapter;
    private List<acc.resto.model.Menu> menuList = null;

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


        new RemoteDataTask().execute();

    }

    private class RemoteDataTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
        @Override
        protected Void doInBackground(Void... params) {
            menuList = new ArrayList<acc.resto.model.Menu>();
            try{
                ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Menu");
                ob = query.find();
                for(ParseObject menu : ob){
                    ParseFile image = (ParseFile) menu.get("image");
                    acc.resto.model.Menu m = new acc.resto.model.Menu();
                    m.setType((String) menu.get("type"));
                    m.setImage(image.getUrl());
                    menuList.add(m);
                }
            }catch (com.parse.ParseException e) {
                e.printStackTrace();
            }
            return  null;
        }


        @Override
        protected void onPostExecute(Void result) {
            listView= (ListView) getView().findViewById(R.id.listView2);
            adapter = new ListViewAdapter(getActivity(), menuList);
            listView.setAdapter(adapter);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.menu_list, container , false);


    }
}
