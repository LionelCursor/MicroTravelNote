package com.ldx.microtravelnotes.ui.fragment;

import com.cursor.common.template.fragment.viewpager.FragmentPagerAdapter.Info;
import com.cursor.common.template.fragment.viewpager.ViewPagerFragment;
import com.ldx.microtravelnotes.R;

import java.util.ArrayList;
import java.util.List;

/**
 * USER: ldx
 * DATE: 2015/6/3
 * EMAIL: danxionglei@foxmail.com
 * PROJECT: MicroTravelNotes
 */
public class PagerFragment extends ViewPagerFragment {
    @Override
    public List<Info> getPages() {
        List<Info> list = new ArrayList<>(2);
        list.add(new Info(NewArticleFragment.class,getString(R.string.square)));
        list.add(new Info(LikedArticleFragment.class,getString(R.string.hot)));
        return list;
    }
}
