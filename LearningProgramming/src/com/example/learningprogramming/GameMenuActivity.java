package com.example.learningprogramming;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.learningprogramming.sound.SoundView;

public class GameMenuActivity extends Activity {
	final Activity activity = this;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_gamemenu);
	}

	public void doAction(View view) {
		new SoundView(this).startSE();
		Intent intent = new Intent(activity,
				com.example.learningprogramming.MainActivity.class);
		activity.startActivity(intent);
	}

	public void moveStageSelectActivity(View view) {
		new SoundView(this).startSE();
		Intent intent = new Intent(activity,
				com.example.learningprogramming.StageSelectActivity.class);
		activity.startActivity(intent);
	}

	public void moveTutorialActivity(View view) {
		new SoundView(this).startSE();
		Intent intent = new Intent(activity,
				com.example.learningprogramming.TutorialActivity.class);
		activity.startActivity(intent);
	}
}
