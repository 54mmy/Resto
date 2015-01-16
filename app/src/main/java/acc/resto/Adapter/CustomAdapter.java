package acc.resto.Adapter;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import acc.resto.R;
import acc.resto.Model.Reviews;

/**
 * Created by Sagar Gopale on 1/9/2015.
 */
public class CustomAdapter extends ArrayAdapter<Reviews> {

    ProgressDialog mProgress;
    Context context;
    List<Reviews> reviews;
    public CustomAdapter(Context context, List<Reviews> rs) {
        super(context,0, rs);
        this.context = context;
        this.reviews = rs;
    }

    private int colors[] = new int[] {Color.parseColor("#FFA633"),Color.parseColor("#FFFFFF")};

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Reviews listReview = reviews.get(position);
        int colorPos = position%colors.length;

        if(convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.data,parent,false);
/*
        if(position % 2 == 0)
        {
            convertView.setBackgroundColor(colors[colorPos]);
        }
        else {
            convertView.setBackgroundColor(colors[colorPos]);
        }
*/
       // ImageView imageView = (ImageView) convertView.findViewById(R.id.img);
        TextView dish = (TextView) convertView.findViewById(R.id.dish);
        TextView review = (TextView) convertView.findViewById(R.id.review);
        ImageButton imageButton = (ImageButton) convertView.findViewById(R.id.share);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
       //         postToFacebook(context);
            }
        });

        dish.setText(listReview.getDish());
        review.setText(listReview.getReview());

        return convertView;
    }

/*    private void postToFacebook(Context mContext) {
        mProgress = new ProgressDialog(mContext);
        mProgress.setMessage("Posting...");
        mProgress.show();

        RequestAsyncTask mRequest = new RequestAsyncTask();

        Bundle params = new Bundle();

        params.putString("message","review");
        params.putString("name","Resto");
        params.putString("caption","Test App");

    }*/
}
