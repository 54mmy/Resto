package acc.resto.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.parse.ParseObject;
import com.parse.ParseQueryAdapter;

import acc.resto.OffersAdapter;
import acc.resto.R;

/**
 * Created by Sagar Gopale on 1/13/2015.
 */
public class Offers extends Fragment {
        private int pageNumber;
        private String title;
        private Context mContext;
        private OffersAdapter offersAdapter;
        private ListView offersList;
        private ParseQueryAdapter<ParseObject> mainAdapter;


    public static Offers newInstance(int pageNumber,String title)
    {
        Offers offers = new Offers();
        Bundle b = new Bundle();
        b.putInt("offersPageNumber",pageNumber);
        b.putString("offersTitle",title);
        offers.setArguments(b);
        return offers;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
//        ParseObject.registerSubclass(acc.resto.model.Offers.class);
        pageNumber = getArguments().getInt("offerPageNumber");
        title = getArguments().getString("offerTitle");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.offer_list_view, container , false);
        mainAdapter = new ParseQueryAdapter<ParseObject>(getActivity(), "Offer");
        mainAdapter.setImageKey("image");
        mainAdapter.setTextKey("title");
        mainAdapter.setTextKey("description");

        offersAdapter = new OffersAdapter(getActivity());

        offersList = (ListView) view.findViewById(R.id.offerlistview);
        offersList.setAdapter(mainAdapter);
        mainAdapter.loadObjects();

        if (offersList.getAdapter() == mainAdapter) {
            offersList.setAdapter(offersAdapter);
            mainAdapter.loadObjects();
        } else {
            offersList.setAdapter(mainAdapter);
            mainAdapter.loadObjects();
        }


        return view;
    }

/*
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mItems = new ArrayList<OffersData>();
        Resources resources = getResources();

        mItems.add(new OffersData(resources.getDrawable(R.drawable.hara_masala), "40% Off on Hara masala dish","Limited period offer"));
        mItems.add(new OffersData(resources.getDrawable(R.drawable.large_panner), "12% Off on Paneer dish","Limited period offer"));
        mItems.add(new OffersData(resources.getDrawable(R.drawable.pasta_dish), "40% Off on Pasta dish","Limited period offer"));

        setListAdapter(new OffersAdapter(getActivity(), mItems));
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
               getListView().setDivider(null);
    }
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        OffersData item = mItems.get(position);
        Toast.makeText(getActivity(), item.title, Toast.LENGTH_SHORT).show();
    }
*/
}