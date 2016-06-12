package com.hanbit.user.myapp.member;

/**
 * Created by user on 2016-06-11.
 */
public interface MemberService {
    public  String signup(MemberBean member);  //C
    public MemberBean login(MemberBean member);//R
    public  MemberBean update(MemberBean member);//U
    public String delete(MemberBean member); //D


}
