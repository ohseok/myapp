package com.hanbit.user.myapp.signup;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hanbit.user.myapp.R;
import com.hanbit.user.myapp.member.MemberBean;
import com.hanbit.user.myapp.member.MemberDAO;

public class SignupActivity extends Activity implements View.OnClickListener {
    EditText etID,etPwd, etName,etEmail;
    Button btSignUp;
    TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        etName=(EditText)findViewById(R.id.etName);
        etPwd=(EditText)findViewById(R.id.etPwd);
        etID=(EditText)findViewById(R.id.etID);
        etEmail=(EditText)findViewById(R.id.etEmail);
        ((Button)findViewById(R.id.btSignuUp)).setOnClickListener(this);
        tvResult=(TextView)findViewById(R.id.tvResult);

    }


    @Override
    public void onClick(View v) {

        String name=etName.getText().toString();
        String id=etID.getText().toString();
        String pwd=etPwd.getText().toString();
        String email=etEmail.getText().toString();
        MemberBean member=new MemberBean();
        // MemberService service=new MemberServiceImpl();
        MemberDAO dao = new MemberDAO(this.getApplicationContext());

        member.setId(id);
        member.setPwd(pwd);
        member.setEmail(email);
        member.setName(name);

        String msg=dao.signup(member);
        tvResult.setText("회원가입결과 : "+ msg);
    }
}
