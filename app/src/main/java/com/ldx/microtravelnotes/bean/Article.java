package com.ldx.microtravelnotes.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * USER: ldx
 * DATE: 2015-06-17
 * EMAIL: danxionglei@foxmail.com
 * PROJECT: MicroTravelNotes
 */
public class Article implements Parcelable {


    private String _id;
    private String title;
    private String coverKey;
    private List<Content> content;
    private String publishTime;
    private String userId;
    private String userImg;
    private boolean isLiked; //boolean the current user isLiked the article
    private int liked;// the liked count
    private List<String> likedUsers;
    private List<Comments> comments;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCoverKey() {
        return coverKey;
    }

    public void setCoverKey(String coverKey) {
        this.coverKey = coverKey;
    }

    public List<Content> getContent() {
        return content;
    }

    public void setContent(List<Content> content) {
        this.content = content;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public boolean isLiked() {
        return isLiked;
    }

    public void setIsLiked(boolean isLiked) {
        this.isLiked = isLiked;
    }

    public int getLiked() {
        return liked;
    }

    public void setLiked(int liked) {
        this.liked = liked;
    }

    public List<String> getLikedUsers() {
        return likedUsers;
    }

    public void setLikedUsers(List<String> likedUsers) {
        this.likedUsers = likedUsers;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }

    public static class Content implements Parcelable {
        private String pickKey;
        private String intro;

        public String getPickKey() {
            return pickKey;
        }

        public void setPickKey(String pickKey) {
            this.pickKey = pickKey;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.pickKey);
            dest.writeString(this.intro);
        }

        public Content() {
        }

        protected Content(Parcel in) {
            this.pickKey = in.readString();
            this.intro = in.readString();
        }

        public static final Parcelable.Creator<Content> CREATOR = new Parcelable.Creator<Content>() {
            public Content createFromParcel(Parcel source) {
                return new Content(source);
            }

            public Content[] newArray(int size) {
                return new Content[size];
            }
        };
    }

    public static class Comments implements Parcelable {
        private String userId;
        private String commentTime;
        private String content;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCommentTime() {
            return commentTime;
        }

        public void setCommentTime(String commentTime) {
            this.commentTime = commentTime;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.userId);
            dest.writeString(this.commentTime);
            dest.writeString(this.content);
        }

        public Comments() {
        }

        protected Comments(Parcel in) {
            this.userId = in.readString();
            this.commentTime = in.readString();
            this.content = in.readString();
        }

        public static final Parcelable.Creator<Comments> CREATOR = new Parcelable.Creator<Comments>() {
            public Comments createFromParcel(Parcel source) {
                return new Comments(source);
            }

            public Comments[] newArray(int size) {
                return new Comments[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this._id);
        dest.writeString(this.title);
        dest.writeString(this.coverKey);
        dest.writeTypedList(content);
        dest.writeString(this.publishTime);
        dest.writeString(this.userId);
        dest.writeString(this.userImg);
        dest.writeByte(isLiked ? (byte) 1 : (byte) 0);
        dest.writeInt(this.liked);
        dest.writeStringList(this.likedUsers);
        dest.writeTypedList(comments);
    }

    public Article() {
    }

    protected Article(Parcel in) {
        this._id = in.readString();
        this.title = in.readString();
        this.coverKey = in.readString();
        this.content = in.createTypedArrayList(Content.CREATOR);
        this.publishTime = in.readString();
        this.userId = in.readString();
        this.userImg = in.readString();
        this.isLiked = in.readByte() != 0;
        this.liked = in.readInt();
        this.likedUsers = in.createStringArrayList();
        this.comments = in.createTypedArrayList(Comments.CREATOR);
    }

    public static final Parcelable.Creator<Article> CREATOR = new Parcelable.Creator<Article>() {
        public Article createFromParcel(Parcel source) {
            return new Article(source);
        }

        public Article[] newArray(int size) {
            return new Article[size];
        }
    };
}
