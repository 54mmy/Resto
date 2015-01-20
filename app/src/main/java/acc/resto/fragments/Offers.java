package acc.resto.fragments;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import acc.resto.OffersAdapter;
import acc.resto.OffersData;
import acc.resto.R;

/**
 * Created by Sagar Gopale on 1/13/2015.
 */
public class Offers extends ListFragment {

    private int pageNumber;
    private String title;
    private Context mContext;
    private ListView offersList;
    private List<OffersData> mItems;

    public static Offers newInstance(int pageNumber, String title) {
        Offers offers = new Offers();
        Bundle b = new Bundle();
        b.putInt("offersPageNumber", pageNumber);
        b.putString("offersTitle", title);
        offers.setArguments(b);
        return offers;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mItems = new ArrayList<OffersData>();
        Resources resources = getResources();

        mItems.add(new OffersData(resources.getDrawable(R.drawable.chinese_food), "20% Off on Chinese food", "Limited period offer"));
        mItems.add(new OffersData(resources.getDrawable(R.drawable.cocktail_drinks), "10% Off on Cocktail drinks","Limited period offer"));
        mItems.add(new OffersData(resources.getDrawable(R.drawable.girly_drinks), "30% Off on Girly drinks","Limited period offer"));
        mItems.add(new OffersData(resources.getDrawable(R.drawable.hard_drinks), "5% Off on Hard drinks","Limited period offer"));
        mItems.add(new OffersData(resources.getDrawable(R.drawable.pasta_dish), "25% Off on Pasta dish", "Limited period offer"));
//        mItems.add(new OffersData(resources.getDrawable(R.drawable.soft_drinks), "30% Off on Soft drinks","Limited period offer"));
        mItems.add(new OffersData(resources.getDrawable(R.drawable.hara_masala), "40% Off on Hara masala dish","Limited period offer"));
        mItems.add(new OffersData(resources.getDrawable(R.drawable.large_panner), "12% Off on Paneer dish","Limited period offer"));

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
    }
