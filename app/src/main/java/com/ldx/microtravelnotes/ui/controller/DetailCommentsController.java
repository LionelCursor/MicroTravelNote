package com.ldx.microtravelnotes.ui.controller;

import android.support.annotation.Nullable;
import android.view.ViewGroup;

import com.cursor.common.widget.recyclerview.IControllerImpl;
import com.cursor.common.widget.recyclerview.IModel;
import com.cursor.common.widget.recyclerview.IViewImpl;
import com.ldx.microtravelnotes.bean.Article;
import com.ldx.microtravelnotes.ui.DetailCommentsModel;
import com.ldx.microtravelnotes.ui.view.DetailCommentsView;

import java.util.List;

/**
 * USER: ldx
 * DATE: 2015-06-22
 * EMAIL: danxionglei@foxmail.com
 * PROJECT: MicroTravelNotes
 */
public class DetailCommentsController extends IControllerImpl<Article.Comments> {
    @Override
    public IModel<Article.Comments> newModel(@Nullable List<Article.Comments> beans) {
        return new DetailCommentsModel();
    }

    @Override
    public IViewImpl<Article.Comments> newView(ViewGroup viewGroup, int viewType) {
        return new DetailCommentsView(this);
    }
}
