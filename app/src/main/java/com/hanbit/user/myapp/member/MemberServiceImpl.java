package com.hanbit.user.myapp.member;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by user on 2016-06-11.
 */

public class MemberServiceImpl extends Activity implements MemberService {

    MemberDAO dao=null;
    //MemberDAO dao=new MemberDAO(this.getApplication());;

    @Override
    public String signup(MemberBean member) {
        return dao.signup(member);
    }

    @Override
    public MemberBean login(MemberBean member) {
        return dao.login(member);
    }

    @Override
    public MemberBean update(MemberBean member) {
        return dao.update(member);
    }

    @Override
    public String delete(MemberBean member) {
        return dao.delete(member);
    }
}
