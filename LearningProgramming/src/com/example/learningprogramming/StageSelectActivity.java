package com.example.learningprogramming;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StageSelectActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stageselect);
	}

	public void doAction(View view) {
		final Activity activity = this;
		Intent intent = new Intent(activity,
				com.example.learningprogramming.StageActivity.class);
		activity.startActivity(intent);
	}

}
