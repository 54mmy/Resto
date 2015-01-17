package acc.resto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by MITHUN on 1/16/2015.
 */
public class OffersAdapter extends ArrayAdapter<OffersData> {
    private final Context context;
    ArrayList<OffersData> offersArrayList;
    public OffersAdapter(Context context, ArrayList<OffersData> offersArrayList) {
        super(context, R.layout.list_item, offersArrayList);
        this.context = context;
        this.offersArrayList = offersArrayList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = layoutInflater.inflate(R.layout.list_item, parent, false);
        TextView titleView = (TextView) rowView.findViewById(R.id.title);
        TextView descView = (TextView) rowView.findViewById(R.id.desc);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.image);

        titleView.setText(offersArrayList.get(position).title);
        descView.setText(offersArrayList.get(position).desc);
        imageView.setImageResource(offersArrayList.get(position).image);

        return rowView;
    }

}
