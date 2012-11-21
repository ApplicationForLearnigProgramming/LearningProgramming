package com.example.learningprogramming;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.learningprogramming.sound.SoundView;

public class MainActivity extends Activity {

	private SoundView bgm = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		bgm = new SoundView(this);
		bgm.startBGM_menu();

		// // 要らなくなったマップファイルを消去（いずれ消す）
		// String[] fileList = this.fileList();
		// for (String file : fileList) {
		// this.deleteFile(file);
		// }

	}

	public void doAction(View view) {
		final Activity activity = this;
		new SoundView(this).startSE();
		Intent intent = new Intent(activity,
				com.example.learningprogramming.GameMenuActivity.class);
		activity.startActivity(intent);
	}

	public void moveOption(View view) {
		final Activity activity = this;
		Intent intent = new Intent(activity,
				com.example.learningprogramming.OptionActivity.class);
		activity.startActivity(intent);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		bgm.stopSound(bgm.getBGM());
	}
}
