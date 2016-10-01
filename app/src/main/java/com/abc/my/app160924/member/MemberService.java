package com.abc.my.app160924.member;

import com.abc.my.app160924.util.Retval;

/**
 * Created by 1027 on 2016-10-01.
 */

public interface MemberService {
    public MemberDTO login(MemberDTO member);
    public Retval Join(MemberDTO member);
}
