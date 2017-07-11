package com.miniproject.a2nd.a2ndminiproject.data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by jh on 17. 7. 10.
 */

public class Restaurant implements Parcelable {
    private String name;
    private String content;
    private int imageId;
    private boolean checked;
    private int distance;
    private int rank;
    private Date time;

    public Restaurant(String name, String content, int imageId, boolean checked, int distance, int rank, Date time) {
        this.name = name;
        this.content = content;
        this.imageId = imageId;
        this.checked = checked;
        this.distance = distance;
        this.rank = rank;
        this.time = time;
    }

    private Restaurant(Parcel in) {
        name = in.readString();
        content = in.readString();
        imageId = in.readInt();
        checked = in.readByte() != 0;
        distance = in.readInt();
        rank = in.readInt();
        time = (Date)in.readSerializable();
    }

    public static final Creator<Restaurant> CREATOR = new Creator<Restaurant>() {
        @Override
        public Restaurant createFromParcel(Parcel in) {
            return new Restaurant(in);
        }

        @Override
        public Restaurant[] newArray(int size) {
            return new Restaurant[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public int getImageId() {
        return imageId;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public int getDistance() {
        return distance;
    }

    public int getRank() {
        return rank;
    }

    public Date getTime() {
        return time;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(content);
        dest.writeInt(imageId);
        dest.writeByte((byte)(checked ? 1 : 0));
        dest.writeInt(distance);
        dest.writeInt(rank);
        dest.writeSerializable(time);
    }
}
