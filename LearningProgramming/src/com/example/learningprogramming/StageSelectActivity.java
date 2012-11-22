package com.example.learningprogramming;

import game.Map;
import game.StageCreator;
import game.StageSelectAdapter;
import game.StageSelectData;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.learningprogramming.sound.SoundView;

public class StageSelectActivity extends Activity {

	private SoundView bgm = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_stageselect);

		bgm = new SoundView(this);
		bgm.startBGM_select();

		// LinearLayout linear = (LinearLayout) findViewById(R.id.LinearLayout);

		Bitmap rank1 = BitmapFactory.decodeResource(getResources(),
				R.drawable.star);
		Bitmap rank2 = BitmapFactory.decodeResource(getResources(),
				R.drawable.star_2);
		Bitmap rank3 = BitmapFactory.decodeResource(getResources(),
				R.drawable.star_3);
		Bitmap rank4 = BitmapFactory.decodeResource(getResources(),
				R.drawable.star_4);
		Bitmap rank5 = BitmapFactory.decodeResource(getResources(),
				R.drawable.star_5);

		Bitmap stage1 = BitmapFactory.decodeResource(getResources(),
				R.drawable.frame);
		Bitmap stage2 = BitmapFactory.decodeResource(getResources(),
				R.drawable.frame);
		Bitmap stage3 = BitmapFactory.decodeResource(getResources(),
				R.drawable.frame);
		Bitmap stage4 = BitmapFactory.decodeResource(getResources(),
				R.drawable.frame);
		Bitmap stage5 = BitmapFactory.decodeResource(getResources(),
				R.drawable.frame);

		ArrayList<StageSelectData> objects = new ArrayList<StageSelectData>();

		StageSelectData item1 = new StageSelectData(1, stage1, rank1);
		StageSelectData item2 = new StageSelectData(2, stage2, rank2);
		StageSelectData item3 = new StageSelectData(3, stage3, rank3);
		StageSelectData item4 = new StageSelectData(4, stage4, rank4);
		StageSelectData item5 = new StageSelectData(5, stage5, rank5);
		StageSelectData item6 = new StageSelectData(6, stage5, rank2);
		StageSelectData item7 = new StageSelectData(7, stage5, rank4);
		StageSelectData item8 = new StageSelectData(8, stage5, rank3);

		objects.add(item1);
		objects.add(item2);
		objects.add(item3);
		objects.add(item4);
		objects.add(item5);
		objects.add(item6);
		objects.add(item7);
		objects.add(item8);

		StageSelectAdapter adapter = new StageSelectAdapter(this, 0, objects);

		ListView listView = (ListView) findViewById(R.id.ListView01);
		listView.setAdapter(adapter);

		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				ListView listView = (ListView) parent;
				StageSelectData data = (StageSelectData) listView
						.getItemAtPosition(position);
				int item = data.getStageNumber();

				if (item == 1) {
					Map map = new StageCreator().createStage001();
					Map.setSelectedMap(map);
				} else if (item == 2) {
					Map map = new StageCreator().createStage002();
					Map.setSelectedMap(map);
				} else {
					Map map = new StageCreator().createStage003();
					Map.setSelectedMap(map);
				}
				doAction(view);
			}
		});
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		bgm.stopSound(bgm.getBGM());
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
