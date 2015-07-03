package com.cursonjiang.litepaldemo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.cursonjiang.litepaldemo.R;
import com.cursonjiang.litepaldemo.model.Comment;
import com.cursonjiang.litepaldemo.model.News;

import org.litepal.tablemanager.Connector;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * 获取数据库对象
         */
        Connector.getDatabase();

        saveNews();
        saveComment();


    }

    /**
     * 保存评论
     */
    private void saveComment() {
        //评论1
        Comment comment1 = new Comment();
        comment1.setContent("成为更好的人!");
        comment1.setPublishDate(new Date());
        comment1.save();

        //评论2
        Comment comment2 = new Comment();
        comment2.setContent("天天向上!");
        comment2.setPublishDate(new Date());
        comment2.save();


        News news = new News();

        //把两个comment对象添加到CommentList中, 表示这两个comment对象是属于这个news对象的
        news.getCommentList().add(comment1);
        news.getCommentList().add(comment2);

        //新增加一条新闻
        news.setTitle("第二条新闻标题");
        news.setContent("第二条新闻内容");
        news.setPublishDate(new Date());

        //设置新闻的评论个数
        news.setCommentCount(news.getCommentList().size());
        news.save();
    }

    /**
     * 保存新闻
     */
    private void saveNews() {
        News news = new News();
        news.setTitle("CursonJiang");
        news.setContent("加油!!");
        news.setPublishDate(new Date());
        if (news.save()) {
            Toast.makeText(MainActivity.this, "保存成功", Toast.LENGTH_SHORT).show();
            Log.d("TAG", "news id is " + news.getId());
        }
    }

}
