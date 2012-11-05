package com.example.learningprogramming;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.GestureDetector.SimpleOnGestureListener;

public class StageActivity extends Activity{


	private GestureDetector myGestureDetector;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage2);
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
			if(velocityX < 0){
				Intent subactivity = new Intent(StageActivity.this, com.example.learningprogramming.GambitActivity.class);
				startActivity(subactivity);
			}
			return false;
		}
	}
}
