package com.abc.my.app160924.member;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.abc.my.app160924.util.Retval;

/**
 * Created by 1027 on 2016-10-01.
 */

public class MemberDAO extends SQLiteOpenHelper{ //상속을받게해서 접근할수있게.
    public MemberDAO(Context context) {
        super(context,"hanbitdb",null,1);
        //위치값,만드려는 db의 이름 , 팩토리 , 버전
        this.getWritableDatabase(); //입력가능한 DB로 만들어라.
        Log.d("DB가 만들어지면 이 글이 보일것임.","성공 !!");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public MemberDTO select(MemberDTO param){
        Log.i("*** DAO 에서 받은 ID값 :",param.getId());
        Log.i("*** DAO 에서 받은 PW값 :",param.getPw());
        MemberDTO member = new MemberDTO();
        member.setId("hong"); //set을주면 null이 되지않는다.
        member.setPw("1");
        member.setName("홍길동");
        return member;
    }
    public Retval insert(MemberDTO param){
        //MemberDTO member = new MemberDTO();
        Retval val = new Retval();
        if(true){
            val.setMessage("SUCCESS");
        }else{
            val.setMessage("FAIL");
        }
        //return member;
        //retval 이라는 클래스를 하나더 추가했기때문에 이름을 변경해줬다.
        return val;
    }
    public MemberDTO update(MemberDTO param){
        MemberDTO member = new MemberDTO();
        return member;
    }
    public MemberDTO delete(MemberDTO param){
        MemberDTO member = new MemberDTO();
        return member;
    }

}
