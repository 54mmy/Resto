package acc.resto.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import acc.resto.model.Menu;
import acc.resto.R;


/**
 * Created by Sagar Gopale on 1/16/2015.
 */
public class MenuItemAdapter extends ArrayAdapter<Menu> {

    Context context;
    List<Menu> menuList;
    public MenuItemAdapter(Context context, List<Menu> m) {
        super(context,0,m);
        this.context=context;
        this.menuList=m;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.menu_data,parent,false);
        }


        TextView dishName = (TextView) convertView.findViewById(R.id.dish_name);
        TextView dishType = (TextView) convertView.findViewById(R.id.dish_type);
        TextView distance = (TextView) convertView.findViewById(R.id.distance);
        ImageView bg_image = (ImageView) convertView.findViewById(R.id.imageView);

   //     dishName.setText();
   //     dishType.setText();
        distance.setText("1.0 mi");


        return convertView;

    }
}
