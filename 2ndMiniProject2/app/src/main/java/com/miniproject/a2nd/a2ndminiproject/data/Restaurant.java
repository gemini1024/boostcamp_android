package com.miniproject.a2nd.a2ndminiproject.data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by jh on 17. 7. 10.
 */

public class Restaurant implements Serializable {
    private String name;
    private String content;
    private int imageId;
    private boolean checked;
    private long distance;
    private int rank;
    private Date time;

    public Restaurant(String name, String content, int imageId, boolean checked, long distance, int rank, Date time) {
        this.name = name;
        this.content = content;
        this.imageId = imageId;
        this.checked = checked;
        this.distance = distance;
        this.rank = rank;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public long getDistance() {
        return distance;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
