package acc.resto.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import acc.resto.fragments.FragmentOne;
import acc.resto.fragments.FragmentThree;
import acc.resto.fragments.FragmentTwo;

/**
 * Created by Sagar Gopale on 1/10/2015.
 */
public class ScreenSlidePagerAdapter extends FragmentPagerAdapter {
    public ScreenSlidePagerAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int arg0) {
        switch (arg0) {
            case 0:
                return new FragmentOne();
            case 1:
                return new FragmentTwo();
            case 2:
                return new FragmentThree();
            default:
                break;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
