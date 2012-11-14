package com.example.learningprogramming;

import game.Map;
import game.StageCreator;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		Button button = (Button) this.findViewById(R.id.button3);
		button.setOnClickListener(createButton_OnClickListener);
	}

	private OnClickListener createButton_OnClickListener = new OnClickListener() {
		public void onClick(View v) {
			stageCreate(v);
		}
	};

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

	private void stageCreate(View v) {
		StageCreator creator = new StageCreator();
		createStageFile(creator.createStage001());
		createStageFile(creator.createStage002());
	}

	private void createStageFile(Map stage) {
		String filename = stage.getFilename();
		String stageSize = stage.getStageSize();
		String charaInfo = stage.getCharaInfo();
		String stageData = stage.getStageData();

		OutputStream os = null;
		BufferedWriter bw = null;
		try {
			try {
				os = this.openFileOutput(filename, MODE_PRIVATE);
				bw = new BufferedWriter(new OutputStreamWriter(os));

				bw.append(stageSize + "\n");
				bw.append(charaInfo + "\n");
				bw.append(stageData + "\n");

				bw.flush();
			} finally {
				if (bw != null) {
					bw.close();
				}
			}
		} catch (IOException e) {
			Toast.makeText(this, "ファイル書き込み失敗", Toast.LENGTH_SHORT).show();
		}
	}
}
