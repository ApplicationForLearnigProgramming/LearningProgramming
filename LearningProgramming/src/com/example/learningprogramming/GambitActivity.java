package com.example.learningprogramming;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.Window;
import android.view.WindowManager;

public class GambitActivity extends Activity{


	private GestureDetector myGestureDetector;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_second);
        myGestureDetector = new GestureDetector(new MyGestureListener());
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
			if(velocityX > 0){
				Intent subactivity = new Intent(GambitActivity.this, com.example.learningprogramming.StageActivity.class);
				startActivity(subactivity);
			}
			return false;
		}

	}

}
