package com.hanbit.user.myapp.Calc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hanbit.user.myapp.R;
import com.hanbit.user.myapp.main.MainActivity;

public class CalcActivity extends Activity implements View.OnClickListener,View.OnFocusChangeListener {
    EditText input01,input02,input03;
    TextView textResult;
    int num1,num2,result;
    CalcService service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        textResult = (TextView) findViewById(R.id.textResult);

        input01=(EditText)findViewById(R.id.input01);
        input02=(EditText)findViewById(R.id.input02);
        ((Button) findViewById(R.id.btnPlus)).setOnClickListener(this);
        ((Button) findViewById(R.id.btnMinus)).setOnClickListener(this);
        ( (Button) findViewById(R.id.btnMulti)).setOnClickListener(this);
        ( (Button) findViewById(R.id.btnDivi)).setOnClickListener(this);
        ((Button) findViewById(R.id.btnRest)).setOnClickListener(this);
        ((Button) findViewById(R.id.btnMain2)).setOnClickListener(this);
        input01.setOnFocusChangeListener(this);
        input02.setOnFocusChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast tMsg =Toast.makeText(CalcActivity.this,"토스트 연습",Toast.LENGTH_LONG);

        if(  input01.getText().toString().equals("")) input01.setText("0");

        num1=Integer.parseInt(input01.getText().toString());
        num2=Integer.parseInt(input02.getText().toString());
        //     if( Pattern.
        service = new CalcServiceImpl();

        if(v.getId()==R.id.btnMain2) {
            startActivity(new Intent(this, MainActivity.class));

        }
        else
        {
            switch (v.getId()) {
                case R.id.btnPlus :  result=service.plus(num1,num2);      break;
                case R.id.btnMinus :  result=service.minus(num1,num2); break;
                case R.id.btnMulti : result=service.multi(num1,num2);break;
                case R.id.btnDivi : result=service.divide(num1,num2);break;
                case R.id.btnRest : result =service.nmg(num1,num2);break;
            }

        }
        textResult.setText("결과값은"+result);

    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        input03=(EditText)findViewById(v.getId());
        String strMsg= input03.getText().toString();
        if(hasFocus){
        Toast tMsg =Toast.makeText(CalcActivity.this,strMsg,Toast.LENGTH_LONG);
        tMsg.show();}
    }
}
