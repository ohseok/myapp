package com.hanbit.user.myapp.movie;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.ContextMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.hanbit.user.myapp.R;

/**
 * Created by user on 2016-06-18.
 */
public class MovieGridAdapter extends BaseAdapter {

    ImageView imageview;
    Context context;
    int pos;
    Integer[]  posterID= {
            R.drawable.mov01,  R.drawable.mov02, R.drawable.mov03,
            R.drawable.mov04,  R.drawable.mov05, R.drawable.mov06,
            R.drawable.mov07,  R.drawable.mov08, R.drawable.mov09,
            R.drawable.mov10,  R.drawable.mov11, R.drawable.mov12
    };
    public MovieGridAdapter(Context context) {
        this.context=context;
    }

    @Override
    public int getCount() {

        return  posterID.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        //Toast.makeText(context, "뷰"+pos, Toast.LENGTH_SHORT).show();
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        imageview = new ImageView(context);
        imageview.setLayoutParams(new GridView.LayoutParams(100, 150));
        imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageview.setPadding(5, 5, 5, 5);

        imageview.setImageResource(posterID[position]);
         final int  pos=position;
        Toast.makeText(context, "포스"+pos, Toast.LENGTH_SHORT).show();
        Toast.makeText(context, "포지션"+position, Toast.LENGTH_SHORT).show();
        imageview.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                View dialogView = (View) View.inflate(
                        context, R.layout.dialog, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(
                        context);
                ImageView ivPoster = (ImageView) dialogView.findViewById(R.id.ivPoster);
                ivPoster.setImageResource(posterID[pos]);
                dlg.setTitle("큰 포스터");
              //  dlg.setIcon(R.drawable.ic_launcher);
                dlg.setView(dialogView);
                dlg.setNegativeButton("닫기", null);
                dlg.show();
            }
        });
      //  imageview.setOnClickListener(this);


        return imageview;

    }
/*
    @Override
    public void onClick(View v) {
        View dialogView = (View) View.inflate(
                context, R.layout.dialog, null);
        AlertDialog.Builder dlg = new AlertDialog.Builder(
                context);
        ImageView ivPoster = (ImageView) dialogView
                .findViewById(R.id.ivPoster);
        ivPoster.setImageResource(posterID[pos]);
        dlg.setTitle("큰 포스터");
        Toast.makeText(context, "입력성공"+pos, Toast.LENGTH_SHORT).show();
        //  dlg.setIcon(R.drawable.ic_launcher);
        dlg.setView(dialogView);
        dlg.setNegativeButton("닫기", null);
        dlg.show();
    }
    */
}
