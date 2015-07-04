package com.ldx.microtravelnotes.ui.fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.cursor.common.utils.ViewUtils;
import com.ldx.microtravelnotes.R;
import com.ldx.microtravelnotes.bean.Article;
import com.ldx.microtravelnotes.ui.adapter.DetailAdapter;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class DetailFragment extends Fragment {

    ListView mListView;

    //Header
    @InjectView(R.id.fragment_detail_user_text)
    TextView mUsername;
    @InjectView(R.id.fragment_detail_circle_user)
    ImageView mUserAvater;
    @InjectView(R.id.fragment_detail_header_like)
    TextView mLiked;
    @InjectView(R.id.fragment_detail_list_image)
    ImageView mImageViewCover;
    @InjectView(R.id.fragment_detail_header_title)
    TextView mTitle;
    @InjectView(R.id.fragment_detail_list_header_subscribe)
    TextView mSubscribe;
    @InjectView(R.id.fragment_detail_header_comments)
    TextView mCommentsCount;

    Article mData;

    private OnFragmentInteractionListener mListener;

    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_detail, container, false);
        mListView = (ListView) v.findViewById(R.id.fragment_detail_list);
        initView(mListView);
        return v;
    }

    private void initView(ListView listView){
        listView.addHeaderView(generateHeaderView());
        listView.setAdapter(new DetailAdapter(mData));
    }

    private View generateHeaderView(){
        View v = ViewUtils.inflate(R.layout.fragment_details_header);
        ButterKnife.inject(this,v);
        return v;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
            mData = mListener.getArgument();
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
        Article getArgument();
    }

}
