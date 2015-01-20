package acc.resto.provider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Sagar on 1/19/2015.
 */
public class GrubHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "food.db";
    private static final int DATABASE_VERSION = 1;
    private static final String COMMA_SEP = ", ";
    private static final String CREATE_CMD = "CREATE TABLE ";
    private static final String END_CMD = ");";
    public static final String DROP_TABLE_SQL = "DROP TABLE IF EXISTS";

    public static final String CREATE_MENU = CREATE_CMD + GrubContract.FoodMenu.TABLE_NAME + "(" + GrubContract.FoodMenu.FoodType + " TEXT " + COMMA_SEP + GrubContract.FoodMenu.FoodImage + " BLOB" + END_CMD;

    public GrubHelper(Context context) {
       super(context , DATABASE_NAME , null , DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_MENU);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE_SQL + GrubContract.FoodMenu.TABLE_NAME);
    }
}
