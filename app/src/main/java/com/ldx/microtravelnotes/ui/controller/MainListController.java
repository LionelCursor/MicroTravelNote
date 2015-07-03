package com.ldx.microtravelnotes.ui.controller;

import android.support.annotation.Nullable;
import android.view.ViewGroup;

import com.cursor.common.widget.recyclerview.IControllerImpl;
import com.cursor.common.widget.recyclerview.IModel;
import com.cursor.common.widget.recyclerview.IModelImpl;
import com.cursor.common.widget.recyclerview.IViewImpl;
import com.ldx.microtravelnotes.bean.Article;
import com.ldx.microtravelnotes.ui.view.MainListView;

import java.util.List;

/**
 * USER: ldx
 * DATE: 2015-06-17
 * EMAIL: danxionglei@foxmail.com
 * PROJECT: MicroTravelNotes
 */
public class MainListController extends IControllerImpl<Article>{

    @Override
    public IModel<Article> newModel(@Nullable List<Article> beans) {
        return new IModelImpl<>(this,beans);
    }

    @Override
    public IViewImpl<Article> newView(ViewGroup viewGroup, int viewType) {
        IViewImpl<Article> v = new MainListView(this, viewGroup, viewType);
        v.onViewCreated(v.itemView);
        return v;
    }
}
