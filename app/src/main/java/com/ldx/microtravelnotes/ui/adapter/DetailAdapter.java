package com.ldx.microtravelnotes.ui.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cursor.common.utils.ViewUtils;
import com.koushikdutta.async.future.FutureCallback;
import com.ldx.microtravelnotes.R;
import com.ldx.microtravelnotes.bean.Article;
import com.ldx.microtravelnotes.bean.User;
import com.ldx.microtravelnotes.io.net.UserApi;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * USER: ldx
 * DATE: 2015-06-22
 * EMAIL: danxionglei@foxmail.com
 * PROJECT: MicroTravelNotes
 */
public class DetailAdapter extends BaseAdapter {

    List<Article.Comments> mData;

    public DetailAdapter(Article article){
        mData = article.getComments();
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            convertView = newView();
            holder = new ViewHolder();
            holder.userAvatar = (ImageView) convertView.findViewById(R.id.fragment_detail_item_user_avatar);
            holder.userName = (TextView) convertView.findViewById(R.id.fragment_detail_item_user_name);
            holder.Content = (TextView) convertView.findViewById(R.id.fragment_detail_item_user_contents);
            holder.Time = (TextView) convertView.findViewById(R.id.fragment_detail_item_comments_time);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Article.Comments comments = mData.get(position);
        holder.Time.setText(comments.getCommentTime());
        holder.Content.setText(comments.getContent());
        holder.userName.setText(comments.getUserId());
        UserApi.getUserFromId(comments.getUserId(), new FutureCallback<User>() {
            @Override
            public void onCompleted(Exception e, User result) {
                ImageLoader.getInstance().displayImage(result.getHeadimgurl(),holder.userAvatar);
            }
        },holder);
        return convertView;
    }

    public class ViewHolder{
        ImageView userAvatar;
        TextView userName;
        TextView Content;
        TextView Time;
    }

    public View newView(){
        return ViewUtils.inflate(R.layout.fragment_detail_list_comments);
    }
}
