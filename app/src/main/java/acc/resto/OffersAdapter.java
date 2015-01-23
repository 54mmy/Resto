package acc.resto;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.parse.GetDataCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseImageView;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;

public class OffersAdapter extends ParseQueryAdapter<ParseObject>{
    public OffersAdapter(Context context) {
        super(context, new QueryFactory<ParseObject>() {
            @Override
            public ParseQuery create() {
                ParseQuery query = new ParseQuery("Offer");
                return query;
            }
        });
    }

    @Override
    public View getItemView(ParseObject object, View v, ViewGroup parent) {
        if (v == null) {
            v = View.inflate(getContext(), R.layout.list_item, null);
        }
        super.getItemView(object, v, parent);

        ParseImageView offerImage = (ParseImageView) v.findViewById(R.id.l_icon);
        ParseFile photoFile = object.getParseFile("image");
        if (photoFile != null) {
            offerImage.setParseFile(photoFile);
            final View finalV = v;
            offerImage.loadInBackground(new GetDataCallback() {
                @Override
                public void done(byte[] bytes, ParseException e) {
                }
            });
        }
        TextView titleTextView = (TextView) v.findViewById(R.id.l_title);
        titleTextView.setText(object.getString("title"));

        TextView descriptionTextView = (TextView) v.findViewById(R.id.l_description);
        descriptionTextView.setText(object.getString("description"));
        return v;
    }
    /*
    public OffersAdapter(Context context, List<OffersData> item) {
        super(context, R.layout.list_item, item);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_item, parent, false);
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
*/
}
