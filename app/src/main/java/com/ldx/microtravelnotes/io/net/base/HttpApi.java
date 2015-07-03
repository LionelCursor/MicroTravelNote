package com.ldx.microtravelnotes.io.net.base;

/**
 * USER: ldx
 * DATE: 2015-06-18
 * EMAIL: danxionglei@foxmail.com
 * PROJECT: MicroTravelNotes
 */
public abstract class HttpApi {
    private static final String HTTP_HOST = "http://120.26.129.111/";

    private static final String API = "api/";

    protected static final String GET = "GET";
    protected static final String POST = "POST";
    protected static final String PUT = "PUT";
    protected static final String DELETE = "DELETE";

    protected static String getRequestUrl(String... details){
        StringBuilder builder = new StringBuilder(HTTP_HOST);
        builder.append(API);
        for (String s :details) {
            builder.append(s);
        }
        return builder.toString();
    }
}
