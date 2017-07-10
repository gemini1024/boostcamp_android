package com.miniproject.a2nd.a2ndminiproject;

import java.util.Date;

/**
 * Created by jh on 17. 7. 10.
 */

public class Restaurant {
    private String name;
    private String content;
    private int imageId;
    private int checked;
    private long distance;
    private int rank;
    private Date time;

    public Restaurant(String name, String content, int imageId, int checked, long distance, int rank, Date time) {
        this.name = name;
        this.content = content;
        this.imageId = imageId;
        this.checked = checked;
        this.distance = distance;
        this.rank = rank;
        this.time = time;
    }
}
