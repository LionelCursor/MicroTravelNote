package com.ldx.microtravelnotes.ui.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ldx.microtravelnotes.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class NewArticleActivityFragment extends Fragment {

    public NewArticleActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_new_article, container, false);
    }
}
