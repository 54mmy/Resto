package acc.resto;

import android.app.ListActivity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MITHUN on 1/19/2015.
 */
public class SubMenu extends ListActivity {
    private List<OffersData> mItems;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mItems = new ArrayList<OffersData>();
        Resources resources = getResources();

        mItems.add(new OffersData(resources.getDrawable(R.drawable.pasta_dish), "Pasta dish", "Rs. 200 for two people"));
        mItems.add(new OffersData(resources.getDrawable(R.drawable.hara_masala), "Hara masala dish","Rs. 350 for two people"));
        mItems.add(new OffersData(resources.getDrawable(R.drawable.large_panner), "Paneer dish","Rs. 400 for four people"));

        setListAdapter(new SubMenuAdapter(this, mItems));

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        OffersData item = mItems.get(position);
        Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show();
    }
}
