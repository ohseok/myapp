package com.hanbit.user.myapp.member;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by user on 2016-06-11.
 */
public class MemberDAO extends SQLiteOpenHelper{

    public MemberDAO(Context context) {
        super(context,"hanbitDB",null,1);
      //  super(context, DBname, factory, DBversion);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //db.create();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public String signup(MemberBean member) {
        String name=member.getName();
        String id=member.getId();
        String email=member.getEmail();
        String pwd=member.getPwd();
        SQLiteDatabase db=this.getReadableDatabase();
        MemberBean mem=new MemberBean();
        String strSQL="insert into member( id, pwd, name, email) values ("
                +"'"+ id +"',"
                +"'"+ pwd +"',"
                +"'"+ name +"',"
                +"'"+ email +"');";
        Log.i("name",name);
        Log.i("ID",id);
        Log.i("pwd",pwd);
        Log.i("email",email);
        Log.i("SQL",strSQL);

        db.execSQL  (strSQL);

        db.close();
        Log.i("name",name);
        Log.i("ID",id);
        Log.i("pwd",pwd);
        Log.i("email",email);

        return "회원가입성공";
    }

    public MemberBean  login(MemberBean member) {
      //  ArrayList<MemberBean> list =new ArrayList<MemberBean>();
        SQLiteDatabase db=this.getReadableDatabase();
        MemberBean mem=new MemberBean();
     //   if (db.isOpen()  ) {
            Log.i("DB패스는",db.getPath());
            Cursor cursor =
                    db.rawQuery("select id, pwd, name, email from member where id='" + member.getId() +
                            "' and pwd='" + member.getPwd() + "';", null);

            String cid = "";
            String cpw = "";
            String cName = "";
            String email = "";

            while (cursor.moveToNext()) {
                cid = cursor.getString(0);
                cpw = cursor.getString(1);
                cName = cursor.getString(2);
                email = cursor.getString(3);

            }

            mem.setId(cid);
            mem.setPwd(cpw);
            mem.setName(cName);
            mem.setEmail(email);
            Log.i("name", mem.getName());
            Log.i("ID", mem.getId());
            Log.i("pwd", mem.getPwd());
            Log.i("email", mem.getEmail());
            cursor.close();
  //      }
        db.close();
        return  mem;
    }

    public MemberBean update(MemberBean member) {
        MemberBean mem=new MemberBean();
        mem.setId(member.getId());
        mem.setPwd(member.getPwd());

        Log.i("name",mem.getName());
        Log.i("ID",mem.getId());


        return mem;
    }

    public String delete(MemberBean member) {


        return member.getName()+ "님 삭제완료";

    }
}
