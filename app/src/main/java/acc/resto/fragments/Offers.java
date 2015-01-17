package acc.resto.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ListView;

/**
 * Created by Sagar Gopale on 1/13/2015.
 */
public class Offers extends Fragment {

    private int pageNumber;
    private String title;
    private Context mContext;
    private ListView offersList;
    View view;

    public static Offers newInstance(int pageNumber , String title)
    {
        Offers offers = new Offers();
        Bundle b =new Bundle();
        b.putInt("offersPageNumber",pageNumber);
        b.putString("offersTitle",title);
        offers.setArguments(b);
        return offers;
    }
/*
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity().getApplicationContext();
        offersList = (ListView) view.findViewById(R.id.listview);
        OffersAdapter adapter = new OffersAdapter(mContext, generateData());
        offersList.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.offers, container , false);
    }

    private ArrayList<OffersData> generateData(){
        ArrayList<OffersData> items = new ArrayList<OffersData>();
        items.add(new OffersData("20% Off on Chinese food","Limited period offer",R.drawable.chinese_food));
        items.add(new OffersData("10% Off on Cocktail drinks","Limited period offer", R.drawable.cocktail_drinks));
        items.add(new OffersData("30% Off on Girly drinks","Limited period offer", R.drawable.girly_drinks));
        items.add(new OffersData("5% Off on Hard drinks","Limited period offer", R.drawable.hard_drinks));
        items.add(new OffersData("25% Off on Pasta dish", "Limited period offer", R.drawable.pasta_dish));
        items.add(new OffersData("15% Off on Red wine","Limited period offer",R.drawable.red_wine));
        items.add(new OffersData("30% Off on Soft drinks","Limited period offer", R.drawable.soft_drinks));
        items.add(new OffersData("40% Off on Hara masala dish","Limited period offer", R.drawable.hara_masala));
        items.add(new OffersData("12% Off on Paneer dish","Limited period offer", R.drawable.large_panner));
        items.add(new OffersData("10% Off on Non-veg dish", "Limited period offer", R.drawable.nonveg_dish));
        items.add(new OffersData("50% Off on Roll","Limited period offer",R.drawable.roll));
        items.add(new OffersData("25% Off on Veg-thali","Limited period offer", R.drawable.veg_thali));
        items.add(new OffersData("5% Off on Workout meal","Limited period offer", R.drawable.workout_meal));
        items.add(new OffersData("15% Off on Chinese","Limited period offer", R.drawable.chinese));
        items.add(new OffersData("20% Off on Fried rise", "Limited period offer", R.drawable.fried_rise));

        return items;
    }
    */
}
