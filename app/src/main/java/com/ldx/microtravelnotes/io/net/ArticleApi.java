package com.ldx.microtravelnotes.io.net;

import android.util.Log;

import com.cursor.common.AppData;
import com.cursor.common.io.net.NetResponseListener;
import com.cursor.common.template.fragment.recycler.BaseListFragment;
import com.cursor.common.utils.Logger;
import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.ldx.microtravelnotes.bean.Article;
import com.ldx.microtravelnotes.io.net.base.HttpApi;

import java.util.ArrayList;
import java.util.List;

/**
 * USER: ldx
 * DATE: 2015-06-18
 * EMAIL: danxionglei@foxmail.com
 * PROJECT: MicroTravelNotes
 */
public class ArticleApi extends HttpApi {
    private static final String ARTICAL = "articles/";

    private static final String GET_NEW = "new/:";

    public static void getNewArticle(int page,
                                     final NetResponseListener<Article> resultListener) {
        Ion.with(AppData.getContext())
                .load(GET, getRequestUrl(ARTICAL, GET_NEW, String.valueOf(page)))
                .setLogging("Http", Log.DEBUG)
                .as(new TypeToken<ArrayList<Article>>() {
                })
                .setCallback(new FutureCallback<ArrayList<Article>>() {
                    @Override
                    public void onCompleted(Exception e, ArrayList<Article> result) {
                        resultListener.onResponse(e, result);
                    }
                });
    }
}