package com.ldx.microtravelnotes.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * USER: ldx
 * DATE: 2015-06-22
 * EMAIL: danxionglei@foxmail.com
 * PROJECT: MicroTravelNotes
 */
public class User implements Parcelable {
    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public int getCurrTemp() {
        return currTemp;
    }

    public void setCurrTemp(int currTemp) {
        this.currTemp = currTemp;
    }

    public List<String> getFollowed() {
        return followed;
    }

    public void setFollowed(List<String> followed) {
        this.followed = followed;
    }

    public int getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(int articleCount) {
        this.articleCount = articleCount;
    }

    public int getHeartCount() {
        return heartCount;
    }

    public void setHeartCount(int heartCount) {
        this.heartCount = heartCount;
    }

    public int getFansCount() {
        return fansCount;
    }

    public void setFansCount(int fansCount) {
        this.fansCount = fansCount;
    }

    public int getFollowedCount() {
        return followedCount;
    }

    public void setFollowedCount(int followedCount) {
        this.followedCount = followedCount;
    }

    public boolean isCurrUser() {
        return isCurrUser;
    }

    public void setIsCurrUser(boolean isCurrUser) {
        this.isCurrUser = isCurrUser;
    }

    private String openid;
    private String nickname;
    private int sex; //1 for male, 0 for female
    private String province;
    private String city;
    private String country;
    private String headimgurl;
    private int currTemp; // the current template id
    private List<String> followed;
    private int articleCount;
    private int heartCount;
    private int fansCount;
    private int followedCount;
    private boolean isCurrUser;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.openid);
        dest.writeString(this.nickname);
        dest.writeInt(this.sex);
        dest.writeString(this.province);
        dest.writeString(this.city);
        dest.writeString(this.country);
        dest.writeString(this.headimgurl);
        dest.writeInt(this.currTemp);
        dest.writeStringList(this.followed);
        dest.writeInt(this.articleCount);
        dest.writeInt(this.heartCount);
        dest.writeInt(this.fansCount);
        dest.writeInt(this.followedCount);
        dest.writeByte(isCurrUser ? (byte) 1 : (byte) 0);
    }

    public User() {
    }

    protected User(Parcel in) {
        this.openid = in.readString();
        this.nickname = in.readString();
        this.sex = in.readInt();
        this.province = in.readString();
        this.city = in.readString();
        this.country = in.readString();
        this.headimgurl = in.readString();
        this.currTemp = in.readInt();
        this.followed = in.createStringArrayList();
        this.articleCount = in.readInt();
        this.heartCount = in.readInt();
        this.fansCount = in.readInt();
        this.followedCount = in.readInt();
        this.isCurrUser = in.readByte() != 0;
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
