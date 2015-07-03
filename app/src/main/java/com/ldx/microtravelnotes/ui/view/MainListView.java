package com.ldx.microtravelnotes.ui.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cursor.common.widget.recyclerview.IController;
import com.cursor.common.widget.recyclerview.IViewImpl;
import com.ldx.microtravelnotes.R;
import com.ldx.microtravelnotes.bean.Article;
import com.nostra13.universalimageloader.core.ImageLoader;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * USER: ldx
 * DATE: 2015-06-17
 * EMAIL: danxionglei@foxmail.com
 * PROJECT: MicroTravelNotes
 */
public class MainListView extends IViewImpl<Article> {

    @InjectView(R.id.main_list_item_title)
    TextView mTitle;

    @InjectView(R.id.main_list_item_subtitle)
    TextView mSubtitle;

    @InjectView(R.id.main_list_item_imageView)
    ImageView mBackground;

    @InjectView(R.id.main_list_item_user_avatar)
    ImageView mUserAvatar;

    @InjectView(R.id.main_list_item_liked)
    ImageView mLiked;

    public MainListView(IController<Article> controller, ViewGroup parent, int viewType) {
        super(controller, IViewImpl.inflate(parent, R.layout.item_main_list));
    }

    @Override
    public void bindData(Article data) {
        mTitle.setText(data.getTitle());
        ImageLoader.getInstance().displayImage(data.getCoverKey(), mBackground);
        ImageLoader.getInstance().displayImage(data.getUserImg(), mUserAvatar);
        mLiked.setImageResource(data.getLiked()==0?R.mipmap.heart_1:R.mipmap.heart_2);
        mLiked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public void onViewCreated(View v) {
        ButterKnife.inject(this, v);
    }
}
