package com.miniproject.a1st.a1stminiproject;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.miniproject.a1st.a1stminiproject.data.BoardPost;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 글 목록 화면
 * A simple {@link Fragment} subclass.
 */
public class BoardFragment extends Fragment {

    @BindView(R.id.board_list)
    RecyclerView mBoardList;

    private BoardListAdapter mBoardListAdapter;
    private ArrayList<BoardPost> dummyBoards;

    public BoardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_board, container, false);
        ButterKnife.bind(this, view);

        // 글 추가 (DUMMY_DATA)
        // new BoardPost(제목, 작성시간, 내용, 첨부이미지)
        dummyBoards = new ArrayList<>();
        dummyBoards.add(new BoardPost("<b><font color=black>"+ getString(R.string.dummy_board_item_title_author)+"1</font></b>" +
                getString(R.string.dummy_board_item_title_footer), 2+getString(R.string.dummy_board_item_time),
                getString(R.string.dummy_board_item_content), null));
        dummyBoards.add(new BoardPost("<b><font color=black>"+ getString(R.string.dummy_board_item_title_author)+"2</font></b>" +
                getString(R.string.dummy_board_item_title_footer), 3+getString(R.string.dummy_board_item_time),
                getString(R.string.dummy_board_item_content), null));
        dummyBoards.add(new BoardPost("<b><font color=black>"+ getString(R.string.dummy_board_item_title_author)+"3</font></b>" +
                getString(R.string.dummy_board_item_title_footer), 4+getString(R.string.dummy_board_item_time),
                getString(R.string.dummy_board_item_content), null));
        Collections.sort(dummyBoards, new Comparator<BoardPost>() {
            @Override
            public int compare(BoardPost o1, BoardPost o2) {
                return o1.getTime().compareTo(o2.getTime());
            }
        });
        mBoardListAdapter = new BoardListAdapter(dummyBoards);

        // RecyclerView 설정
        mBoardList.setHasFixedSize(true);
        mBoardList.setLayoutManager(new LinearLayoutManager(getContext()));
        mBoardList.setAdapter(mBoardListAdapter);
        return view;
    }


    // 게시글 RecyclerView Adapter
    protected class BoardListAdapter extends RecyclerView.Adapter<BoardListAdapter.BoardViewHolder> {
        private ArrayList<BoardPost> boardPosts;

        public BoardListAdapter(ArrayList<BoardPost> boardPosts) {
            this.boardPosts = boardPosts;
        }

        @Override
        public BoardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.board_item, parent, false);
            return new BoardViewHolder(view);
        }

        // View 설정
        @Override
        public void onBindViewHolder(BoardViewHolder holder, int position) {
            BoardPost item = boardPosts.get(position);

            // TITLE 에는 HTML TAG (굵은 글씨, 색상) 적용
            if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                holder.titleView.setText(Html.fromHtml(item.getTitle(), Html.FROM_HTML_MODE_LEGACY));
            } else {
                holder.titleView.setText(Html.fromHtml(item.getTitle()));
            }
            holder.timeView.setText(item.getTime());
            holder.contentView.setText(item.getContent());
        }

        @Override
        public int getItemCount() {
            return boardPosts.size();
        }



        // 게시글 뷰 홀더
        class BoardViewHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.board_item_title) TextView titleView;
            @BindView(R.id.board_item_time) TextView timeView;
            @BindView(R.id.board_item_content) TextView contentView;
            @BindView(R.id.board_item_image) ImageView imageView;
            // OnClick Methods
            @OnClick({R.id.board_item_bt_favorite_mini, R.id.board_item_bt_favorite})
            void OnFavoriteClick(View view) {
                Toast.makeText(getContext(), getString(R.string.board_item_favorite)+getString(R.string.clicked_footer)
                        , Toast.LENGTH_SHORT).show();
            }
            @OnClick({R.id.board_item_bt_comment, R.id.board_item_bt_share})
            void OnItemButtonClick(Button button) {
                Toast.makeText(getContext(), button.getText()+getString(R.string.clicked_footer), Toast.LENGTH_SHORT).show();
            }

            public BoardViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
            }
        }
    }
}
