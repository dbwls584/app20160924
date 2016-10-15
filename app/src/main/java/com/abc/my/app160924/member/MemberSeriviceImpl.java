package com.abc.my.app160924.member;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by 1027 on 2016-10-01.
 */

public class MemberSeriviceImpl implements MemberService {
    @Override
    public void regist(MemberDTO member) {
        dao.insert(member);
    }

    @Override
    public ArrayList<MemberDTO> getList() {
        return dao.selectList();
    }

    @Override
    public ArrayList<MemberDTO> getListByName(MemberDTO member) {
        return dao.selectListByName(member);
    }

    @Override
    public MemberDTO getOne(MemberDTO member) {
        return dao.selectOne(member);
    }

    @Override
    public int count() {
        return dao.count();
    }

    @Override
    public void update(MemberDTO member) {
        dao.update(member);
    }

    @Override
    public void unregist(MemberDTO member) {
        dao.delete(member);
    }

    MemberDAO dao;
    public MemberSeriviceImpl(Context context) {
        this.dao = new MemberDAO(context);
    }
}
