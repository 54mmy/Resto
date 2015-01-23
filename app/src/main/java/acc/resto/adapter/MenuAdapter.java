package acc.resto.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.parse.GetDataCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseImageView;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;

import acc.resto.R;
import acc.resto.model.Menu;

/**
 * Created by Sagar on 1/20/2015.
 */
public class MenuAdapter extends ParseQueryAdapter<ParseObject> {
    public MenuAdapter(Context context) {
        super(context, new QueryFactory<ParseObject>() {
            @Override
            public ParseQuery create() {
                ParseQuery query = new ParseQuery("Menu");
                return query;
            }
        });
    }

    @Override
    public View getItemView(ParseObject object, View v, ViewGroup parent) {
        if(v==null){
            v= View.inflate(getContext(), R.layout.menu_data, null);
        }
        super.getItemView(object,v,parent);

        ParseImageView menuImage = (ParseImageView) v.findViewById(R.id.imageView);
        ParseFile photoFile = object.getParseFile("image");
        if(photoFile != null){
            menuImage.setParseFile(photoFile);
            final View finalV = v;
            menuImage.loadInBackground(new GetDataCallback() {
                @Override
                public void done(byte[] bytes, ParseException e) {


                    }

            });
        }
   //     TextView dishName = (TextView) v.findViewById(R.id.dish_name);
   //     dishName.setText(object.getString("type"));
        return  v;
    }
}
