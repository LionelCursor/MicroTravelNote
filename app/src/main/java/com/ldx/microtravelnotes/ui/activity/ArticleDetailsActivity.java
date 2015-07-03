package com.ldx.microtravelnotes.ui.activity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cursor.common.template.activity.toolbar.ToolbarActivity;
import com.cursor.common.utils.ViewUtils;
import com.ldx.microtravelnotes.R;
import com.ldx.microtravelnotes.bean.Article;
import com.ldx.microtravelnotes.ui.fragment.DetailFragment;


/**
 * When come to this Activity, please send data Article to this class
 * {@link #getArgument()}
 */
public class ArticleDetailsActivity extends ToolbarActivity implements DetailFragment.OnFragmentInteractionListener{

    TextView mBack;

    TextView mShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_details);
        View v = ViewUtils.inflate(R.layout.toolbar_activity_detail);
        mBack = (TextView) v.findViewById(R.id.activity_detail_toolbar_left);
        mShare = (TextView) v.findViewById(R.id.activity_detail_toolbar_right);
        setCustomView(v);
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public Article getArgument() {
        return getIntent().getParcelableExtra("data");
    }
}
