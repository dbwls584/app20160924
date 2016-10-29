package com.abc.my.app160924.message;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import static android.R.attr.id;
import static com.abc.my.app160924.util.Constants.DB_NAME;
import static com.abc.my.app160924.util.Constants.DB_VERSION;

/**
 * Created by 1027 on 2016-10-29.
 */

public class MessageDAO extends SQLiteOpenHelper {
    public  static final String SEQ = "_id"; //시퀀스 (어프로 게시판제작.) 아이디값이 특정하지않고. 내용이 컨텐츠상 보여질필요가없을때 이걸쓴다.
    public  static final String RECEIVER = "receiver";
    public  static final String CONTENT = "content";
    public  static final String SEND_DATE = "send_date";


    public MessageDAO(Context context) {
        super(context,DB_NAME,null,DB_VERSION);
        this.getWritableDatabase();
        Log.d("DB가 만들어지면 이 글이 보일것임.","성공 !!");
    }
    public void write(MessageDTO member) {

    }

    public ArrayList<MessageDTO> getList() {
        return null;
    }

    public ArrayList<MessageDTO> getListByID(String id) {
        return null;
    }

    public MessageDTO getMessage(int seq) {
        String sql = "SELECT receiver,content,writer,sendDate,seq\n" +
                "FROM message a\n" +
                "JOIN member b\n" +
                "ON a.id=b.id;"+
                "WHERE id =" + id;
        String sql2 = "SELECT receiver,content,writer,sendDate,seq\n" +
                "FROM member\n" +
                "WHERE id =" + id;




        return null;
    }

    public int count() {
        return 0;
    }

    public void deleteMessage(int seq) {

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
