package com.hanbit.user.myapp.spinner;

import android.app.Activity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.hanbit.user.myapp.R;

public class spinnerActivity extends Activity implements Spinner.OnItemSelectedListener{
    Integer[]  posterID= {
            R.drawable.mov01,  R.drawable.mov02, R.drawable.mov03,
            R.drawable.mov04,  R.drawable.mov05, R.drawable.mov06,
            R.drawable.mov07,  R.drawable.mov08, R.drawable.mov09,
            R.drawable.mov10,  R.drawable.mov11, R.drawable.mov12
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        setTitle("스피너테스트");
        String[] moive={"쿵프팬더","짱구","아저씨","아바타","대부","국가대표","토이"};

        Spinner spinner=(Spinner)findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter;

        adapter=new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item,moive);
            spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener( this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        View dialogView = (View) View.inflate(
                spinnerActivity.this, R.layout.dialog, null);
        AlertDialog.Builder dlg = new AlertDialog.Builder(
                spinnerActivity.this);
        ImageView ivPoster = (ImageView) dialogView.findViewById(R.id.ivPoster);
        ivPoster.setImageResource(posterID[pos]);
        dlg.setTitle("큰 포스터");
        //  dlg.setIcon(R.drawable.ic_launcher);
        Toast.makeText(spinnerActivity.this, "포스"+pos, Toast.LENGTH_SHORT).show();
        dlg.setView(dialogView);
        dlg.setNegativeButton("닫기", null);
        dlg.show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
