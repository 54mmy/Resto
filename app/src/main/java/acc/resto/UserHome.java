package acc.resto;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import acc.resto.fragments.About;
import acc.resto.fragments.Offers;

/**
 * Created by Sagar Gopale on 1/13/2015.
 */
public class UserHome extends FragmentActivity implements ActionBar.TabListener{

    private Context mContext;
    private ViewPager mViewPager;
    private UserPagerAdapter userPagerAdapter;

    public static String TAB_OFFERS_TITLE = "Offers";

    public static String TAB_MENU_TITLE = " Menu";
    public static String TAB_ABOUT_TITLE = "About";
    public static String TAB_VISITS_TITLE = "Visits";

    private static final String TAB_NUMBER_KEY = "tab_number";

    private static final int TAB_VISITS = 0;
    private static final int TAB_MENU = 1;
    private static final int TAB_OFFERS = 2;
    private static final int TAB_ABOUT = 3;

    private Bundle b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity);
        mContext = this;

        mViewPager = (ViewPager) findViewById(R.id.user_pager);
        userPagerAdapter = new UserPagerAdapter (getSupportFragmentManager());
        b = getIntent() == null || getIntent().getExtras() == null ? null : getIntent().getExtras();

        mViewPager.setAdapter(userPagerAdapter);
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            };

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        if(b!=null){
            int tabNumber = b.getInt(TAB_NUMBER_KEY);
            if(tabNumber >= 0)
                mViewPager.setCurrentItem(tabNumber);
        }
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Really Exit?")
                .setMessage("Are you sure you want to exit?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        UserHome.super.onBackPressed();
                    }
                }).create().show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_user_home , menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.list_review:
                goList();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }


    private void goList() {
        Intent intent = new Intent(this , ListReviews.class);
        startActivity(intent);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    public static class UserPagerAdapter extends FragmentPagerAdapter {

        private static int NUM_OF_PAGES = 4;

        public UserPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return UserVisits.newInstance(0,TAB_VISITS_TITLE);
                case 1:
                    return acc.resto.fragments.Menu.newInstance(1, TAB_MENU_TITLE);
                case 2:
                    return Offers.newInstance(2, TAB_OFFERS_TITLE);
                case 3:
                    return About.newInstance(3, TAB_ABOUT_TITLE);
                default:
                    return null;
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return TAB_VISITS_TITLE;
                case 1:
                    return TAB_MENU_TITLE;
                case 2:
                    return TAB_OFFERS_TITLE;
                case 3:
                    return TAB_ABOUT_TITLE;
                default:
                    return "";
            }
        }

        @Override
        public int getCount() {
            return NUM_OF_PAGES;
        }
    }
}
