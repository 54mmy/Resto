package acc.resto.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.parse.ParseFile;
import com.parse.ParseImageView;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;

import acc.resto.R;

/**
 * Created by Sagar on 1/25/2015.
 */
public class SubMenuAdapter extends ParseQueryAdapter<ParseObject> {

    public SubMenuAdapter(Context context) {
        super(context, new QueryFactory<ParseObject>() {
            @Override
            public ParseQuery<ParseObject> create() {
 //               ParseObject menu = ParseObject.createWithoutData("menu", id);
                ParseQuery query = new ParseQuery("Submenu");
                query.include("Menu");
//                query.whereEqualTo("menu", menu);
                return query;
            }
        });
    }

    @Override
    public View getItemView(ParseObject object, View v, ViewGroup parent) {
        if(v==null){
            v=View.inflate(getContext(), R.layout.smenu_data, null);
        }
        super.getItemView(object,v,parent);

        TextView dishTitle = (TextView) v.findViewById(R.id.dishtitle);
        dishTitle.setText(object.getString("title"));
        TextView dishDescription = (TextView) v.findViewById(R.id.dishdescription);
        dishDescription.setText(object.getString("Description"));

        return v;
    }

}

