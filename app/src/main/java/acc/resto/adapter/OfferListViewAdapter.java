package acc.resto.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import acc.resto.CustomParse.ImageLoader;
import acc.resto.R;
import acc.resto.model.Offers;

/**
 * Created by MITHUN on 1/23/2015.
 */
public class OfferListViewAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    ImageLoader imageLoader;
    private List<Offers> offersList = null;
    private ArrayList<Offers> arrayList;
    Resources resources = Resources.getSystem();
    public OfferListViewAdapter(Context context , List<Offers> offersList){
        this.context = context;
        this.offersList = offersList;
        inflater = LayoutInflater.from(context);
        this.arrayList = new ArrayList<Offers>();
        this.arrayList.addAll(offersList);
        imageLoader = new ImageLoader(context);
    }

    public class ViewHolder{
        ImageView image;
        TextView title;
        TextView description;
    }

    @Override
    public int getCount() {
        return offersList.size();
    }

    @Override
    public Object getItem(int position) {
        return offersList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.list_item, null);
            viewHolder.image = (ImageView) convertView.findViewById(R.id.l_icon);
            viewHolder.title = (TextView) convertView.findViewById(R.id.l_title);
            viewHolder.title = (TextView) convertView.findViewById(R.id.l_description);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        imageLoader.DisplayImage(offersList.get(position).getImage(),viewHolder.image);
        viewHolder.title.setText(offersList.get(position).getTitle());
        viewHolder.description.setText(offersList.get(position).getDescription());
        return convertView;
    }
}
