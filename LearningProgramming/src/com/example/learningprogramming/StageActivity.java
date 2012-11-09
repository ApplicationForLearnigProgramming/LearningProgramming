package com.example.learningprogramming;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.learningprogramming.view.*;

public class StageActivity extends Activity{

	private GestureDetector myGestureDetector;
	private SurfaceView surfaceview;
	private StageActivitySurfaceView stageSurface;
	private StageActivityMoveSurfaceView stageMoveSurface;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage3);

        // SurfaceViewを参照
        surfaceview = (SurfaceView)findViewById(R.id.SurfaceViewMain);

        // 作成したMainSurfaceViewクラスをインスタンス化
       	stageMoveSurface = new StageActivityMoveSurfaceView(this, surfaceview);

        //stageSurface = new StageActivitySurfaceView(this, surfaceview);
    	myGestureDetector = new GestureDetector(new MyGestureListener());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Thread.interrupted();
    }

    public void move(View view){
    	stageMoveSurface.move();
    }

    public void reset(View view){
    	stageMoveSurface.reset();
    }


    @Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO 自動生成されたメソッド・スタブ
		if(myGestureDetector.onTouchEvent(event))return true;
		else return false;
	}

	private class MyGestureListener extends SimpleOnGestureListener{

		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
				float velocityY) {
			// TODO 自動生成されたメソッド・スタブ
			if(velocityX < 0){
				Intent subactivity = new Intent(StageActivity.this, com.example.learningprogramming.GambitActivity.class);
				startActivity(subactivity);
			}
			return false;
		}
	}
}
