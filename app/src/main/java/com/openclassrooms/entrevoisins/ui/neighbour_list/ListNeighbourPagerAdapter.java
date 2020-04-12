package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class ListNeighbourPagerAdapter extends FragmentPagerAdapter {

    public ListNeighbourPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    /**
     * getItem is called to instantiate the fragment for the given page.
     *
     * @param position
     * @return
     */

    @Override
    public Fragment getItem(int position) {
                return ListNeighboursFragment.newInstance(position);
    }

    /**
     * get the number of pages
     *
     * @return
     */
    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0: //Page number 1
                return "Mes voisins";
            case 1: //Page number 2
                return "Mes favoris";
            default:
                return null;
        }
    }
}