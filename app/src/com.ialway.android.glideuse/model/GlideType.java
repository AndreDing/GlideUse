package com.ialway.android.glideuse.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by dingchao on 2017/3/1.
 */
public class GlideType implements Parcelable {

    public static final String INTENT_EXTRA_GLIDETYPE = "GlideType";

    public static final int TYPE_SIMPLE = 0;
    public static final int TYPE_CACHE_INVAL = 1;

    public int mType;
    public String mName;

    public GlideType(int type, String name) {
        this.mType = type;
        this.mName = name;
    }

    protected GlideType(Parcel in) {
        mType = in.readInt();
        mName = in.readString();
    }

    public void setType(int type) {
        this.mType = type;
    }

    public int getType() {
        return mType;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getName() {
        return mName;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mType);
        dest.writeString(mName);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<GlideType> CREATOR = new Creator<GlideType>() {
        @Override
        public GlideType createFromParcel(Parcel in) {
            return new GlideType(in);
        }

        @Override
        public GlideType[] newArray(int size) {
            return new GlideType[size];
        }
    };
}
