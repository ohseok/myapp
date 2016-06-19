package com.hanbit.user.myapp.Group;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hanbit.user.myapp.R;

public class GroupActivity extends Activity implements View.OnClickListener{
    EditText etInwon,  etGName, etGResult,etFindID;
    GroupDBHelper groupHelper=new GroupDBHelper(GroupActivity.this);
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
        Toast.makeText(GroupActivity.this, "생성", Toast.LENGTH_SHORT).show();
         etInwon=(EditText)findViewById(R.id.etInwon);
         etGName=(EditText)findViewById(R.id.etGName);
         etGResult=(EditText)findViewById(R.id.etGResult);
        etFindID= (EditText) findViewById(R.id.etFind);
        ((Button)findViewById(R.id.btGReset)).setOnClickListener(this);
        ((Button)findViewById(R.id.btGInput)).setOnClickListener(this);
        ((Button)findViewById(R.id.btGUpdate)).setOnClickListener(this);
        ((Button)findViewById(R.id.btGDel)).setOnClickListener(this);
        ((Button)findViewById(R.id.btGSearch)).setOnClickListener(this);

        ((Button)findViewById(R.id.btList)).setOnClickListener(this);
        ((Button)findViewById(R.id.btCount)).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Cursor cursor=null;
        String id=null,name=null,num=null,result=null;
        switch ( v.getId()) {
            case R.id.btGReset :                   //초기화
                db=groupHelper.getWritableDatabase();
                groupHelper.onUpgrade(db,1,2);
                db.close();

                break ;

            case R.id.btGInput :                //삽입
                db=groupHelper.getWritableDatabase();
                db.execSQL("INSERT INTO girl_Group('name','num') values ('"+etGName.getText()+"',"+ etInwon.getText() +");");
                db.close();
                Toast.makeText(GroupActivity.this, "입력성공", Toast.LENGTH_SHORT).show();
                // getApplicationContext가 GroupActivity.this를 받음
                etGName.setText("");
                etInwon.setText("");
                break;
            case R.id.btGUpdate:             //수정
                db=groupHelper.getReadableDatabase();
                db.execSQL("UPDATE girl_Group SET num="+etInwon.getText() +" where name='"+etGName.getText()+"';");
                db.close();
                etGResult.setText("수정완료");
                break;
            case R.id.btGDel:               //삭제
                db=groupHelper.getReadableDatabase();
                db.execSQL("delete from girl_Group where _id="+etFindID.getText()+";");
                db.close();
                etGResult.setText("삭제완료");
                etFindID.setText("");
                break;
            case R.id.btGSearch:            //조회
                db=groupHelper.getReadableDatabase();
                cursor=db.rawQuery("select * from girl_Group where _id="+etFindID.getText()+";",null)  ;
                while (cursor.moveToNext()) {
                    id = String.valueOf(cursor.getInt(0));
                    name = cursor.getString(1);
                    num = String.valueOf(cursor.getInt(2));

                }
                etGResult.setText("No : "+id+"\n그룹명 : "+name+"\n맴버수 : "+num);

                cursor.close();
                db.close();
                break;

            case R.id.btList:           //리스트
                db=groupHelper.getReadableDatabase() ;
                cursor=db.rawQuery("SELECT * FROM girl_Group;",null);
                id="NO" +"\n\n"+"_______________"+"\n\n" ;
                name="그룹이름" +"\n\n"+"_______________"+"\n\n" ;
                num="멤버수" +"\n\n"+"_______________"+"\n\n" ;
                while(cursor.moveToNext()) {
                   result+= id+ cursor.getInt(0)+"\n\n";
                    result+=name+ cursor.getString(1)+"\n\n";
                    result+=num+ cursor.getInt(2)+"\n\n";
                }
                cursor.close();
                db.close();


                etGResult.setText(result);
             // etGResult.setText(id);
           //  etGResult.setText(name);
           //   etGResult.setText(num);
                break;

            case R.id.btCount:           //카운트
                db=groupHelper.getReadableDatabase() ;
                cursor=db.rawQuery("SELECT * FROM girl_Group;",null);
                int count=cursor.getCount();
                cursor.close();
                etGResult.setText("DB에 저장된 갯수는 ? "+count);
                cursor.close();
                db.close();
                break;
        }

    }
}
