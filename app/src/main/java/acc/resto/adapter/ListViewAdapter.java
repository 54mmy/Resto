package acc.resto.adapter;

import android.content.Context;
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
import acc.resto.model.Menu;

/**
 * Created by Sagar on 1/19/2015.
 */
public class ListViewAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    ImageLoader imageLoader;
    private List<Menu> menuList = null;
    private ArrayList<Menu> arrayList;

    public ListViewAdapter(Context context , List<Menu> menuList){
        this.context = context;
        this.menuList = menuList;
        inflater = LayoutInflater.from(context);
        this.arrayList = new ArrayList<Menu>();
        this.arrayList.addAll(menuList);
        imageLoader = new ImageLoader(context);
    }

    public class ViewHolder{
        TextView type;
        ImageView image;
    }

    @Override
    public int getCount() {
        return menuList.size();
    }

    @Override
    public Object getItem(int position) {
        return menuList.get(position);
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
            convertView = inflater.inflate(R.layout.menu_data, null);
            viewHolder.type = (TextView) convertView.findViewById(R.id.dish_name);
            viewHolder.image = (ImageView) convertView.findViewById(R.id.imageView);
            convertView.setTag(viewHolder);
        }
        else{
             viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.type.setText(menuList.get(position).getDishType());
        imageLoader.DisplayImage(menuList.get(position).getImage(),viewHolder.image);   //set image to imageview
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return convertView;
    }
}
