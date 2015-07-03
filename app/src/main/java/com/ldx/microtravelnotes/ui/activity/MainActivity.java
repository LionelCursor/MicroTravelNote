package com.ldx.microtravelnotes.ui.activity;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cursor.common.template.activity.TabsActivity;
import com.cursor.common.template.activity.toolbar.OnToolbarAttachListener;
import com.cursor.common.template.fragment.viewpager.ViewPagerFragment;
import com.cursor.common.widget.recyclerview.IViewImpl;
import com.ldx.microtravelnotes.R;
import com.ldx.microtravelnotes.ui.fragment.BlankFragment;
import com.ldx.microtravelnotes.ui.fragment.PagerFragment;
import com.ldx.microtravelnotes.ui.fragment.PlusOneFragment;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends TabsActivity implements ViewPagerFragment.OnViewPagerFinishedListener, OnToolbarAttachListener {

    private float mAlpha = 0.6f;

    @InjectView(R.id.relative_main_page)
    LinearLayout mMainPage;

    @InjectView(R.id.relative_topic)
    LinearLayout mTopic;

    @InjectView(R.id.relative_user)
    LinearLayout mUser;

    @InjectView(R.id.relative_message)
    LinearLayout mMessage;

    @InjectView(R.id.tab_camera)
    LinearLayout mCamera;

    TextView mTabSquare;

    TextView mTabLiked;

    ViewPager mViewPager;

    @Override
    protected void onPreDataInit() {
        super.onPreDataInit();
        setmTabsCount(5);
        List<String> fragmentNames = getmFragmentNames();
        fragmentNames.add(PagerFragment.class.getName());
        for (int i = 0; i < 3; i++) {
            fragmentNames.add(BlankFragment.class.getName());
        }

        fragmentNames.add(PlusOneFragment.class.getName());

        setTabsView(generateTabs());
    }

    private ViewGroup generateTabs() {
        RelativeLayout root = new RelativeLayout(this);
        View view = LayoutInflater.from(this).inflate(R.layout.layout_tab, root, false);
        ButterKnife.inject(this, view);
        return (ViewGroup) view;
    }

    private void replaceToolbar(int stringTag){
        View v;
        if ((v = getStoredCustomView(getString(stringTag))) ==null){
            setCustomViewStore(generateToolbarView(stringTag),getString(stringTag));
        } else {
            setCustomView(v);
        }
    }

    private View generateToolbarView(int stringTag){
        View v = null;
        switch (stringTag){
            case R.string.toolbar_main_page:
                v =  generateMainPageToolbarView();
                break;
//            case R.string.toolbar_message:
//                break;
//            case R.string.toolbar_topic:
//                break;
//            case R.string.toolbar_user:
//                break;
//            default:
        }
        return v;
    }

    @Override
    protected void postDeploy() {
        super.postDeploy();
        setExitWhenDblClick(true);
        //Toolbar color
        getToolbar().setBackgroundColor(getResources().getColor(R.color.default_main_color));

        setCustomViewStore(generateMainPageToolbarView(),getString(R.string.toolbar_main_page));
    }

    private View generateMainPageToolbarView(){
        //Custom view: tabs
        View v = IViewImpl.inflate(getCustomViewGroup(), R.layout.layout_toolbar_tab);
        mTabSquare = (TextView) v.findViewById(R.id.layout_toolbar_text_square);
        mTabLiked = (TextView) v.findViewById(R.id.layout_toolbar_text_liked);
        mTabSquare.setOnClickListener(new ToolbarClickListener());
        mTabLiked.setOnClickListener(new ToolbarClickListener());
        mTabLiked.setAlpha(mAlpha);

        return v;
    }

    @Override
    protected void onDeployTabs() {
        FragmentClickListener listener = new FragmentClickListener();
        mCamera.setOnClickListener(listener);
        mMainPage.setOnClickListener(listener);
        mTopic.setOnClickListener(listener);
        mUser.setOnClickListener(listener);
        mMessage.setOnClickListener(listener);
        cleanSelectedTabs();
        mMainPage.setAlpha(1);
    }

    @Override
    public void onViewPagerFinished(ViewPager viewPager) {
        mViewPager = viewPager;
        viewPager.addOnPageChangeListener(new PagerListener());
    }

    class PagerListener extends ViewPager.SimpleOnPageChangeListener {
        @Override
        public void onPageSelected(int position) {
            if (position == 0) {
                mTabLiked.setAlpha(mAlpha);
                mTabSquare.setAlpha(1f);
            } else {
                mTabLiked.setAlpha(1f);
                mTabSquare.setAlpha(mAlpha);
            }
        }
    }

    class ToolbarClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if (v.getId() == mTabSquare.getId()) {
                mViewPager.setCurrentItem(0);
            } else {
                mViewPager.setCurrentItem(1);
            }
        }
    }

    @Override
    protected void cleanSelectedTabs() {
        mMessage.setAlpha(mAlpha);
        mTopic.setAlpha(mAlpha);
        mUser.setAlpha(mAlpha);
        mMainPage.setAlpha(mAlpha);
    }

    class FragmentClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            cleanSelectedTabs();
            Fragment f = null;
            switch (v.getId()) {
                case R.id.tab_camera:
                    return;
                case R.id.relative_main_page:
                    setDisplayMode(DISPLAY_SHOW_VIEW);
                    replaceToolbar(R.string.toolbar_main_page);
                    mMainPage.setAlpha(1f);
                    f = getFragment(0);
                    break;
                case R.id.relative_topic:
                    setDisplayMode(DISPLAY_SHOW_TITLE);
                    setTitle(R.string.topic);
                    mTopic.setAlpha(1);
                    f = getFragment(1);
                    break;
                case R.id.relative_message:
                    setDisplayMode(DISPLAY_SHOW_TITLE);
                    setTitle(R.string.message);
                    mMessage.setAlpha(1);
                    f = getFragment(2);
                    break;
                case R.id.relative_user:
                    setDisplayMode(DISPLAY_SHOW_TITLE);
                    setTitle(R.string.user);
                    mUser.setAlpha(1);
                    f = getFragment(3);
                    break;
            }
            fillWithFragment(f);
        }
    }
}
