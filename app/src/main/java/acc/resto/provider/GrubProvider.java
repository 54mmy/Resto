package acc.resto.provider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

/**
 * Created by Sagar on 1/19/2015.
 */
public class GrubProvider extends ContentProvider {
    private static final int food = 1;
    GrubHelper grubHelper;

    public static final UriMatcher URI_MATCHER;
    static {
        URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);
        URI_MATCHER.addURI(GrubContract.AUTHORITY, "Foodmenu", food);
    }
    @Override
    public boolean onCreate() {
        grubHelper = new GrubHelper(getContext());
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder sqLiteQueryBuilder = new SQLiteQueryBuilder();

        switch (URI_MATCHER.match(uri)){
            case food:
                sqLiteQueryBuilder.setTables(GrubContract.FoodMenu.TABLE_NAME);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI :" + uri);
        }
        SQLiteDatabase _db = grubHelper.getReadableDatabase();
        Cursor c = sqLiteQueryBuilder.query(_db , projection, selection , selectionArgs, null , null , sortOrder);
        c.setNotificationUri(getContext().getContentResolver(), uri);
        return c;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        Uri _uri = null;
        long _id = 0;
        final SQLiteDatabase _db = grubHelper.getWritableDatabase();

        switch (URI_MATCHER.match(uri)){
            case food:

                _id = _db.insert(GrubContract.FoodMenu.TABLE_NAME , null , values);

                if(_id > 0){
                    _uri = ContentUris.withAppendedId(GrubContract.FoodMenu.CONTENT_URI, _id);
                    getContext().getContentResolver().notifyChange(_uri , null);
                }
                break;
        }
        return uri;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
