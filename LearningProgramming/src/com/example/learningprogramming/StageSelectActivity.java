package com.example.learningprogramming;

import game.Map;
import game.StageCreator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

public class StageSelectActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_stageselect);

		ImageButton stage001 = (ImageButton) findViewById(R.id.stage001);
		stage001.setOnClickListener(stage001_OnClickListener);

		ImageButton stage002 = (ImageButton) findViewById(R.id.stage002);
		stage002.setOnClickListener(stage002_OnClickListener);

		ImageButton stage003 = (ImageButton) findViewById(R.id.stage003);
		stage003.setOnClickListener(stage003_OnClickListener);

		// Button stage004 = (Button) findViewById(R.id.stage004);
		// Button stage005 = (Button) findViewById(R.id.stage005);
		// Button stage006 = (Button) findViewById(R.id.stage006);

	}

	private OnClickListener stage001_OnClickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			Map map = new StageCreator().createStage001();
			Map.setSelectedMap(map);
			doAction(v);
		}
	};

	private OnClickListener stage002_OnClickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			Map map = new StageCreator().createStage002();
			Map.setSelectedMap(map);
			doAction(v);
		}
	};

	private OnClickListener stage003_OnClickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			Map map = new StageCreator().createStage003();
			Map.setSelectedMap(map);
			doAction(v);
		}
	};
	public void doAction(View view) {
		final Activity activity = this;
		Intent intent = new Intent(activity,
				com.example.learningprogramming.StageActivity.class);
		activity.startActivity(intent);
	}

}
