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
    EditText etInwon,  etGName, etGResult;
    GroupDBHelper groupHelper;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
        etInwon=(EditText)findViewById(R.id.etInwon);
        etGName=(EditText)findViewById(R.id.etGName);
        etGResult=(EditText)findViewById(R.id.etGResult);

        ((Button)findViewById(R.id.btGReset)).setOnClickListener(this);
        ((Button)findViewById(R.id.btGInput)).setOnClickListener(this);
        ((Button)findViewById(R.id.btGUpdate)).setOnClickListener(this);
        ((Button)findViewById(R.id.btGDel)).setOnClickListener(this);
        ((Button)findViewById(R.id.btGSearch)).setOnClickListener(this);
        ((Button)findViewById(R.id.btGroup)).setOnClickListener(this);
        ((Button)findViewById(R.id.btList)).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch ( v.getId()) {
            case R.id.btGReset :                   //초기화
                 db=groupHelper.getWritableDatabase();
                 groupHelper.onUpgrade(db,1,2);
                db.close();
                etGName.setText("");
                etInwon.setText("");
            break ;

            case R.id.btGInput :                //삽입
                db=groupHelper.getWritableDatabase();
                db.execSQL("INSERT INTO GROUP('name','num') values ('iwa',20);");
                db.close();
                Toast.makeText(GroupActivity.this, "입력성공", Toast.LENGTH_SHORT).show();
                // getApplicationContext가 GroupActivity.this를 받음
                etGName.setText("");
                etInwon.setText("");
            break;
            case R.id.btGUpdate:             //수정

                // ;
                break;
            case R.id.btGDel:               //삭제
                ;
                break;
            case R.id.btGSearch:            //조회
                ;
                break;
            case R.id.btGroup:          //그룹
                ;
                break;
            case R.id.btList:           //삭제
               db=groupHelper.getReadableDatabase() ;
                Cursor cursor=db.rawQuery("SELECT * FROM group;",null);
                String name="그룹이름" +"\n\n"+"_______________"+"\"\n" ;
                String num="멤버수" +"\n\n"+"_______________"+"\"\n" ;
                break;
        }

    }
}
