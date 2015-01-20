package acc.resto.provider;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Sagar on 1/19/2015.
 */
public final class GrubContract {
    public GrubContract(){}
        public static final String AUTHORITY = "acc.resto.provider";
        public static final Uri CONTENT_URI = Uri.parse("content://"+ AUTHORITY);

    public static abstract class FoodMenu implements BaseColumns{
        public static final String TABLE_NAME = "Foodmenu";
        public static final Uri CONTENT_URI = Uri.withAppendedPath(GrubContract.CONTENT_URI, TABLE_NAME);
        public static final String FoodType = "Food_Type";
        public static final String FoodImage = "Food_image";

    }

}
