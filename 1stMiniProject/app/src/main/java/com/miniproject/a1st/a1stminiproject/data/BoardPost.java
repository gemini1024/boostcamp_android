package com.miniproject.a1st.a1stminiproject.data;

import java.util.ArrayList;

/**
 * Created by jh on 17. 6. 30.
 * 게시글 정보
 */

public class BoardPost {
    private String title;               // 제목
    private String time;                // 작성 시간
    private String content;             // 내용
    private String attachUrl;           // 첨부 이미지 URL
    private ArrayList<String> comments; // 댓글 리스트
    private int numFavorite;            // 좋아요 수
    private int numView;                // 조회수

    public BoardPost(String title, String time, String content, String attachUrl, ArrayList<String> comments, int numFavorite, int numView) {
        this.title = title;
        this.time = time;
        this.content = content;
        this.attachUrl = attachUrl;
        this.comments = comments;
        this.numFavorite = numFavorite;
        this.numView = numView;
    }

    // 새로운 글 추가
    public BoardPost(String title, String time, String content, String attachUrl) {
        this(title, time, content, attachUrl, null, 0, 0);
    }


    // 17.7.7
    // 사용하지 않는 메소드 제거
    public String getTitle() {
        return title;
    }

    public String getTime() {
        return time;
    }

    public String getContent() {
        return content;
    }

}
