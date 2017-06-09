/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.TurinTour;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


/**
 * Provides the appropriate {@link Fragment} for a view pager.
 */
public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    private String tabTitles[];


    public SimpleFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);

        String BARS = context.getString(R.string.bars);
        String FOOD = context.getString(R.string.food);
        String MUSEUMS = context.getString(R.string.museums);
        String SIGHTS = context.getString(R.string.sights);
        tabTitles = new String[]{SIGHTS, MUSEUMS, FOOD, BARS};
    }


    @Override
    public Fragment getItem(int position) {

        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = new SightsFragment();
                break;
            case 1:
                fragment = new MuseumsFragment();
                break;
            case 2:
                fragment = new FoodFragment();
                break;
            case 3:
                fragment = new BarsFragment();
                break;
            default:
                break;
        }
        return fragment;
    }


    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }

    }


