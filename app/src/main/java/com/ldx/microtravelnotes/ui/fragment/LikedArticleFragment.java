package com.ldx.microtravelnotes.ui.fragment;

import com.cursor.common.template.fragment.recycler.SimpleListFragment;
import com.cursor.common.widget.recyclerview.IControllerImpl;
import com.ldx.microtravelnotes.bean.Article;
import com.ldx.microtravelnotes.io.net.ArticleApi;
import com.ldx.microtravelnotes.ui.controller.MainListController;

import java.util.ArrayList;

/**
 * USER: ldx
 * DATE: 2015-06-21
 * EMAIL: danxionglei@foxmail.com
 * PROJECT: MicroTravelNotes
 */
public class LikedArticleFragment extends SimpleListFragment<Article>{
    @Override
    protected IControllerImpl<Article> newAdapter() {
        return new MainListController();
    }

    @Override
    protected void onLoadData(boolean isAllFlush, int page) {
        ArticleApi.getNewArticle(page, new ListResponseListener<Article>(isAllFlush, page) {
            @Override
            public void onDataLoaded(Exception e, ArrayList<Article> result) {
                if (result != null) {
                    addItemModel(result);
                }
            }
        });
    }
}
