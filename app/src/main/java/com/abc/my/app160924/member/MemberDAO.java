package com.abc.my.app160924.member;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by 1027 on 2016-10-01.
 */

public class MemberDAO extends SQLiteOpenHelper{ //상속을받게해서 접근할수있게.
    //public static final String DB_NAME = "hanbit.db";
    //public static final String DB_VERSION = 1;
     /*public MemberDAO(Context context) {
        super(context,"hanbitdb2",null,1);
        //위치값,만드려는 db의 이름 , 팩토리 , 버전
        this.getWritableDatabase(); //입력가능한 DB로 만들어라. 이미만들어져있으면 작동하지않는다.
        Log.d("DB가 만들어지면 이 글이 보일것임.","성공 !!");
    }//이 public으로 인해 database를 만들어줌.
    */

    public static final String DB_NAME = "hanbit.db";
    public static final int DB_VERSION = 1;
    public static final String ID = "id";
    public static final String PW = "pw";
    public static final String NAME = "name";
    public static final String EMAIL = "email";
    public static final String ADDR = "addr";
    public static final String PHONE = "phone";
    public static final String PHOTO = "profileImg";
    public static final String TABLE_NAME = "member";

    public MemberDAO(Context context) {
        super(context,DB_NAME,null,DB_VERSION);
        this.getWritableDatabase();
        Log.d("DB가 만들어지면 이 글이 보일것임.","성공 !!");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /* String sql =
        "create table if not exists member( "
                +"        id text primary key,"
                +"        pw text,"
                +"        name text,"
                +"        email text,"
                +"        addr text,"
                +"        phone text,"
                +"        profileImg text)";
        db.execSQL(sql);
        */
        db.execSQL("create table if not exists member( "
                    +"        id text primary key,"
                    +"        pw text,"
                    +"        name text,"
                    +"        email text,"
                    +"        addr text,"
                    +"        phone text,"
                    +"        profileImg text)"
                );
        db.execSQL( "insert into member(id,pw,name,email,addr,phone,profileImg)values"
                   +"('hong1', '1', '홍일동', 'hong1@co.kr','seoul','010-1234-5678','default.jpg')"
                );
        db.execSQL( "insert into member(id,pw,name,email,addr,phone,profileImg)values"
                +"('hong2', '1', '홍이동', 'hong2@co.kr','busan','010-2234-5678','default.jpg')"
        );
        db.execSQL( "insert into member(id,pw,name,email,addr,phone,profileImg)values"
                +"('hong3', '1', '홍삼동', 'hong3@co.kr','seoul','010-3234-5678','default.jpg')"
        );
        db.execSQL( "insert into member(id,pw,name,email,addr,phone,profileImg)values"
                +"('hong4', '1', '홍사동', 'hong4@co.kr','busan','010-4234-5678','default.jpg')"
        );
        db.execSQL( "insert into member(id,pw,name,email,addr,phone,profileImg)values"
                +"('hong5', '1', '홍오동', 'hong5@co.kr','seoul','010-5234-5678','default.jpg')"
        );
        db.execSQL( "insert into member(id,pw,name,email,addr,phone,profileImg)values"
                +"('ha584', '1', '사유진', 'ha584@co.kr','37.5597680,126.9423080','010-9509-8467','default.jpg')"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("insert into Android values(null,'android_6.0.0',1);");
        db.execSQL("insert into Android values(null,'android_6.0.1',2);");
        this.onCreate(db);
    }
    //DML(CREATE)
    public void insert(MemberDTO param){
        //MemberDTO member = new MemberDTO();
        Log.i("*** DAO 전체조회 ***","insert 진입");
        String sql = "insert into " + TABLE_NAME
                +String.format(" (%s,%s,%s,%s,%s,%s,%s)",ID,PW,NAME,EMAIL,ADDR,PHONE,PHOTO)
                +String.format(" values('%s','%s','%s','%s','%s','%s','%s')"
                ,param.getId(),param.getPw(),param.getName(),param.getEmail(),param.getAddr(),param.getPhone(),param.getProfileImg());
        SQLiteDatabase db = this.getWritableDatabase(); //이 db에 쓰는권한을 부여해라.
        db.execSQL(sql);
        db.close();
    }
    //DML(READ)
    //검색조건없이 전체 목록 조회
    public ArrayList<MemberDTO> selectList(){
        Log.i("*** DAO 전체조회 : ","selectlist() 진입");
        String sql = "select"+
                String.format("%s,%s,%s,%s,%s,%s,%s",ID,PW,NAME,EMAIL,ADDR,PHONE,PHOTO)
                +" from member;";
        SQLiteDatabase db = this.getReadableDatabase(); //이 db에 쓰는권한을 부여해라.
        Cursor cursor = db.rawQuery(sql,null);
        ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
        if(cursor != null){ //data 값을 갖고있다면
            Log.i("*** DAO LIST 조회결과 : ","SUCCESS");
            cursor.moveToFirst();
        }
        do{
            MemberDTO temp = new MemberDTO(); //do문 안에서 선언했다.
            temp.setId(cursor.getString(0));
            temp.setPw(cursor.getString(1));
            temp.setName(cursor.getString(2));
            temp.setEmail(cursor.getString(3));
            temp.setAddr(cursor.getString(4));
            temp.setPhone(cursor.getString(5));
            temp.setProfileImg(cursor.getString(6)); //여기까지 한 row값이다.. 한줄이당.
            //위에서 끝나게되면 값이 초기화되어서 저장되는게없으므로. 상위 스코프에게 데이터를넘긴다 저장한다.
            list.add(temp);  //데이터저장. 후 다시 초기화!(new MemberDTO())
        }while(cursor.moveToNext());
        db.execSQL(sql);
        MemberDTO member = new MemberDTO();
        member.setId("hong"); //set을주면 null이 되지않는다.
        member.setPw("1");
        member.setName("홍길동");
        return list;
    }

    //검색조건이 있는 상황에서 목록 조회
    public ArrayList<MemberDTO> selectListByName(MemberDTO param){
        Log.i("*** DAO 전체조회 : ","selectListByName() 진입");
        String sql = "select"+
                String.format("%s,%s,%s,%s,%s,%s,%s",ID,PW,NAME,EMAIL,ADDR,PHONE,PHOTO)
                +String.format(" from %s where %s = '%s';",TABLE_NAME,NAME,param.getName());
        SQLiteDatabase db = this.getReadableDatabase(); //이 db에 쓰는권한을 부여해라.
        Cursor cursor = db.rawQuery(sql,null);
        ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
        if(cursor != null){ //data 값을 갖고있다면
            Log.i("DAO LIST ByNAME 조회결과 : ","SUCCESS");
            cursor.moveToFirst();
        }
        do{
            MemberDTO temp = new MemberDTO(); //do문 안에서 선언했다.
            temp.setId(cursor.getString(0));
            temp.setPw(cursor.getString(1));
            temp.setName(cursor.getString(2));
            temp.setEmail(cursor.getString(3));
            temp.setAddr(cursor.getString(4));
            temp.setPhone(cursor.getString(5));
            temp.setProfileImg(cursor.getString(6)); //여기까지 한 row값이다.. 한줄이당.
            //위에서 끝나게되면 값이 초기화되어서 저장되는게없으므로. 상위 스코프에게 데이터를넘긴다 저장한다.
            list.add(temp);  //데이터저장. 후 다시 초기화!(new MemberDTO())
        }while(cursor.moveToNext());
        db.execSQL(sql);
        MemberDTO member = new MemberDTO();
        member.setId("hong"); //set을주면 null이 되지않는다.
        member.setPw("1");
        member.setName("홍길동");
        return list;
    }
    //
    public MemberDTO selectOne(MemberDTO param){
        Log.i("*** DAO ID 조회 : ","selectOne() 진입");
        String sql = "select "+
                String.format("%s,%s,%s,%s,%s,%s,%s",ID,PW,NAME,EMAIL,ADDR,PHONE,PHOTO)
                +String.format(" from %s where %s = '%s';",TABLE_NAME,ID,param.getId());
        SQLiteDatabase db = this.getReadableDatabase(); //이 db에 쓰는권한을 부여해라.
        Cursor cursor = db.rawQuery(sql,null);
        // ArrayList<MemberDTO> list = new ArrayList<MemberDTO>(); //하나이므로굳이은필요 ㅂㅂ
        MemberDTO temp = null;
        if(cursor.moveToNext()){ //data 값을 갖고있다면
            Log.i("DAO ID 조회결과 : ","ID 존재함");
            temp = new MemberDTO(); //do문 안에서 선언했다.
            temp.setId(cursor.getString(0));
            temp.setPw(cursor.getString(1));
            temp.setName(cursor.getString(2));
            temp.setEmail(cursor.getString(3));
            temp.setAddr(cursor.getString(4));
            temp.setPhone(cursor.getString(5));
            temp.setProfileImg(cursor.getString(6)); //여기까지 한 row값이다.. 한줄이당.
            //위에서 끝나게되면 값이 초기화되어서 저장되는게없으므로. 상위 스코프에게 데이터를넘긴다 저장한다.
            //list.add(temp);  //데이터저장. 후 다시 초기화!(new MemberDTO())
        }
        return temp;
    }
    public int count(){
        Log.i("*** DAO count :","진입");
        String sql ="select count(*) as count from member;";
        SQLiteDatabase db = this.getReadableDatabase();
        int count = 0;
        Cursor cursor = db.rawQuery(sql,null); //시스템에서 주는파라미터(args)는 null처리한다.
        if(cursor.moveToNext()){ //data 값을 갖고있다면
            Log.i("DAO ID 조회결과 : ","ID 존재함");
            count = cursor.getInt(cursor.getColumnIndex("count")); //cursor.getColumnIndex("count") 컬럼명을 줘서 동적으로 가져온다.
        }
        return count;
    }

    //DML(UPDATE)
    public void update(MemberDTO param){ //void로 변환....
        Log.i("*** DAO update :","update 진입");
        String sql = String.format("update %s set",TABLE_NAME)
                +String.format("%s = '%s'",PW,param.getPw())
                +String.format("%s = '%s'",EMAIL,param.getEmail())
                +String.format("%s = '%s'",ADDR,param.getAddr())
                +String.format("%s = '%s'",PHOTO,param.getProfileImg())
                +String.format("where %s = '%s';",ID,param.getId());
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
        db.close(); //write의 경우는 반드시 보안상의 이유로 db를 닫아준다.
    }

    //DML(DELETE)
    public void delete(MemberDTO param){
        Log.i("*** DAO delete :","delete 진입");
        String sql = String.format("delete from %s ",TABLE_NAME)
                +String.format("where %s = '%s';",ID,param.getId());
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
        db.close();
    }

}
