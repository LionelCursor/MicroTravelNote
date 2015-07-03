package com.ldx.microtravelnotes.ui.activity;

import android.os.Bundle;

import com.cursor.common.template.activity.toolbar.ToolbarActivity;
import com.ldx.microtravelnotes.R;

public class NewArticleActivity extends ToolbarActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_article);
    }
}
