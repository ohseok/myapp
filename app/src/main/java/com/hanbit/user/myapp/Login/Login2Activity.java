package com.hanbit.user.myapp.Login;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hanbit.user.myapp.R;
import com.hanbit.user.myapp.member.MemberBean;
import com.hanbit.user.myapp.member.MemberDAO;
import com.hanbit.user.myapp.member.MemberService;
import com.hanbit.user.myapp.member.MemberServiceImpl;

public class Login2Activity extends Activity implements View.OnClickListener {
    EditText etID,etPwd, etName,etEmail;
    Button btSignUp;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        // Set up the login form.

        etPwd=(EditText)findViewById(R.id.etPwd2);
        etID=(EditText)findViewById(R.id.etID2);

        ((Button)findViewById(R.id.btSignUp2)).setOnClickListener(this);
        tvResult=(TextView)findViewById(R.id.tvResult2);
    }

    @Override
    public void onClick(View v) {

        String id=etID.getText().toString();
        String pwd=etPwd.getText().toString();

        MemberBean member=new MemberBean();
        // MemberService service=new MemberServiceImpl();
        MemberDAO dao = new MemberDAO(this.getApplicationContext());

        member.setId(id);
        member.setPwd(pwd);
        Log.i("아이디는",member.getId());
        member= dao.login(member);
        Log.i("DB다녀온 결과 ID",member.getId());
        if(member.getId() == "") {
            tvResult.setText("아이디가 없거나 비밀번호가 다릅니다.");
        }
        else{
            tvResult.setText("로그인 결과 : " + member.getName() + "님성공");
        }
    }
}
