package com.ldx.microtravelnotes.io.net;

import com.cursor.common.AppData;
import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.ldx.microtravelnotes.bean.User;
import com.ldx.microtravelnotes.io.net.base.HttpApi;

/**
 * USER: ldx
 * DATE: 2015-06-18
 * EMAIL: danxionglei@foxmail.com
 * PROJECT: MicroTravelNotes
 */
public class UserApi extends HttpApi {
    private static final String USER = "user/:";

    public static void getUserFromId(String id, FutureCallback<User> callback, Object tag) {
        Ion.getDefault(AppData.getContext()).cancelAll(tag);
        Ion.with(AppData.getContext())
                .load(GET, getRequestUrl(USER, id))
                .group(tag)
                .as(new TypeToken<User>() {
                })
                .setCallback(callback);

    }
}
