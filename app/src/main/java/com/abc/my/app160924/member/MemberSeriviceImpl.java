package com.abc.my.app160924.member;

import android.content.Context;
import android.util.Log;

import com.abc.my.app160924.util.Retval;

/**
 * Created by 1027 on 2016-10-01.
 */

public class MemberSeriviceImpl implements MemberService {

    //MemberDAO dao = new MemberDAO();
    MemberDAO dao;
    public MemberSeriviceImpl(Context context) {
        this.dao = new MemberDAO(context);
    }

    @Override
    public MemberDTO login(MemberDTO param) {
        MemberDTO member = new MemberDTO();
        member = dao.select(param);
        if(member == null){
            member.setId("NONE");
            return member;
        }else if(member.getPw().equals(param.getPw())){
            return member;
        }else{
            member.setId("NO_MATCH");
            return member;
        }
    }

    @Override
    public Retval Join(MemberDTO param) {
        Log.i("*** DAO 에서 받은 ID :",param.getId());
        Log.i("*** DAO 에서 받은 PW :",param.getPw());
        Log.i("*** DAO 에서 받은 NAME :",param.getName());
        Log.i("*** DAO 에서 받은 EMAIL :",param.getEmail());
        Log.i("*** DAO 에서 받은 ADDR :",param.getAddr());
        Log.i("*** DAO 에서 받은 PHONE :",param.getPhone());
        return dao.insert(param);
    }
}
