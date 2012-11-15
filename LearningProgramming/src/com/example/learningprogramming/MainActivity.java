package com.example.learningprogramming;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		// 要らなくなったマップファイルを消去（いずれ消す）
		String[] fileList = this.fileList();
		for (String file : fileList) {
			this.deleteFile(file);
		}

	}

	public void doAction(View view) {
		final Activity activity = this;
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

	// private void stageCreate(View v) {
	// StageCreator creator = new StageCreator();
	// createStageFile(creator.createStage001());
	// createStageFile(creator.createStage002());
	// }
	//
	// private void createStageFile(Map stage) {
	// String filename = stage.getFilename();
	// String stageSize = stage.getStageSize();
	// String charaInfo = stage.getCharaInfo();
	// String stageData = stage.getStageData();
	//
	// OutputStream os = null;
	// BufferedWriter bw = null;
	// try {
	// try {
	// os = this.openFileOutput(filename, MODE_PRIVATE);
	// bw = new BufferedWriter(new OutputStreamWriter(os));
	//
	// bw.append(stageSize + "\n");
	// bw.append(charaInfo + "\n");
	// bw.append(stageData + "\n");
	//
	// bw.flush();
	// } finally {
	// if (bw != null) {
	// bw.close();
	// }
	// }
	// } catch (IOException e) {
	// Toast.makeText(this, "ファイル書き込み失敗", Toast.LENGTH_SHORT).show();
	// }
	// }
}
