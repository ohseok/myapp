package com.hanbit.user.myapp.movie;

import android.app.Activity;
import android.content.Context;
import android.opengl.Visibility;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import com.hanbit.user.myapp.R;

public class MovieActivity extends Activity {
    GridView gv;
    MovieGridAdapter adapter;
    ImageView imageView;
    int pos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        setTitle("그리드 뷰 영화 포스트");

       gv= (GridView) findViewById(R.id.gv);
         adapter=new MovieGridAdapter(this);
       gv.setAdapter(adapter);


      /*  adapter.getView(1,null,null).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                View dialogView = (View) View.inflate(
                        MovieActivity.this, R.layout.dialog, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(
                        MovieActivity.this);
                ImageView ivPoster = (ImageView) dialogView
                        .findViewById(R.id.ivPoster);
                ivPoster.setImageResource(posterID[pos]);
                dlg.setTitle("큰 포스터");
                dlg.setIcon(R.drawable.ic_launcher);
                dlg.setView(dialogView);
                dlg.setNegativeButton("닫기", null);
                dlg.show();

            });*/

        }

}
