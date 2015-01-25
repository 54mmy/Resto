package acc.resto;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.parse.ParseObject;
import com.parse.ParseQueryAdapter;

import acc.resto.adapter.SubMenuAdapter;

/**
 * Created by Sagar on 1/25/2015.
 */
public class SubMenu extends Activity {
    private ParseQueryAdapter<ParseObject> pAdapter;
    private SubMenuAdapter subMenuAdapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.smenu);

        pAdapter = new ParseQueryAdapter<ParseObject>(this, "SubMenu");
        pAdapter.setTextKey("title");
        pAdapter.setTextKey("description");

        subMenuAdapter = new SubMenuAdapter(this);

        listView= (ListView) findViewById(R.id.smenu_list);
        listView.setAdapter(pAdapter);
        pAdapter.loadObjects();

        if (listView.getAdapter() == pAdapter) {
            listView.setAdapter(subMenuAdapter);
            subMenuAdapter.loadObjects();
        } else {
            listView.setAdapter(pAdapter);
            pAdapter.loadObjects();
        }

    }
}
