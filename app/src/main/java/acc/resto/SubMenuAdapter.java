package acc.resto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by MITHUN on 1/19/2015.
 */
public class SubMenuAdapter extends ArrayAdapter<OffersData> {
    public SubMenuAdapter(Context context, List<OffersData> item) {
        super(context, R.layout.sub_menu, item);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.sub_menu, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.list_icon = (ImageView) convertView.findViewById(R.id.l_icon);
            viewHolder.list_title = (TextView) convertView.findViewById(R.id.l_title);
            viewHolder.list_Description = (TextView) convertView.findViewById(R.id.l_description);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        OffersData item = getItem(position);
        viewHolder.list_icon.setImageDrawable(item.icon);
        viewHolder.list_title.setText(item.title);
        viewHolder.list_Description.setText(item.description);

        return convertView;
    }

    private static class ViewHolder {
        ImageView list_icon;
        TextView list_title;
        TextView list_Description;
    }
}
