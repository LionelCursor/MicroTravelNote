package com.ldx.microtravelnotes.ui.view;

import android.view.View;

import com.cursor.common.utils.ViewUtils;
import com.cursor.common.widget.recyclerview.IController;
import com.cursor.common.widget.recyclerview.IViewImpl;
import com.ldx.microtravelnotes.R;
import com.ldx.microtravelnotes.bean.Article;

/**
 * USER: ldx
 * DATE: 2015-06-22
 * EMAIL: danxionglei@foxmail.com
 * PROJECT: MicroTravelNotes
 */
public class DetailCommentsView extends IViewImpl<Article.Comments>{

    public DetailCommentsView(IController<Article.Comments> controller) {
        super(controller, ViewUtils.inflate(R.layout.fragment_detail_list_comments));
    }

    @Override
    public void bindData(Article.Comments data) {

    }

    @Override
    public void onViewCreated(View v) {

    }
}
