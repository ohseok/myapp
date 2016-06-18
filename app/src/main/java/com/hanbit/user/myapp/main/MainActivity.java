package com.hanbit.user.myapp.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hanbit.user.myapp.Calc.CalcActivity;
import com.hanbit.user.myapp.Group.GroupActivity;
import com.hanbit.user.myapp.Login.Login2Activity;
import com.hanbit.user.myapp.R;
import com.hanbit.user.myapp.kaup.KaupActivity;
import com.hanbit.user.myapp.signup.SignupActivity;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //    button4 = (Button) findViewById(R.id.button4);
        //   button5 = (Button) findViewById(R.id.button5);

        ((Button) findViewById(R.id.btnKaup)).setOnClickListener(this);
        ((Button) findViewById(R.id.btnLogin)).setOnClickListener(this);
        ((Button) findViewById(R.id.btnCalc)).setOnClickListener(this);
        ((Button) findViewById(R.id.btSignUp)).setOnClickListener(this);
        ((Button) findViewById(R.id.btGroup)).setOnClickListener(this);
   /*             button4.setOnClickListener(this);
                button5.setOnClickListener(this);*/
    }


    @Override
    public void onClick(View v) {
        String Rs;
        switch (v.getId()) {
            case R.id.btnKaup:
                startActivity(new Intent(this, KaupActivity.class));
                break;
            case R.id.btnCalc:
                startActivity(new Intent(this, CalcActivity.class));
                break;
            case R.id.btnLogin:;
                startActivity(new Intent(this, Login2Activity.class));

                break;

            case R.id.btSignUp:;
                startActivity(new Intent(this, SignupActivity.class));
            case R.id.btGroup:;
                startActivity(new Intent(this, GroupActivity.class));
                break;

        }
    }
}
