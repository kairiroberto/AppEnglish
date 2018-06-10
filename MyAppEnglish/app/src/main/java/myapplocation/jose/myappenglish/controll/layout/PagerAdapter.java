package myapplocation.jose.myappenglish.controll.layout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import myapplocation.jose.myappenglish.view.TabFragment1;
import myapplocation.jose.myappenglish.view.TabFragment2;
import myapplocation.jose.myappenglish.view.TabFragment3;

/**
 * Created by JOSE on 28-5-18.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    static int cena;

    public PagerAdapter(FragmentManager fm, int NumOfTabs, int cena) {
        super(fm);
        this.cena = cena;
        this.mNumOfTabs = NumOfTabs;
    }

    public static int getCena() {
        return cena;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                TabFragment1 tab1 = new TabFragment1();
                return tab1;
            case 1:
                TabFragment2 tab2 = new TabFragment2();
                return tab2;
            case 2:
                TabFragment3 tab3 = new TabFragment3();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}