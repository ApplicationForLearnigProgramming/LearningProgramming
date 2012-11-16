package com.example.learningprogramming;

import java.util.ArrayList;

import game.Gambit;
import game.GambitCondition;
import game.GambitMotion;
import game.GameManeger;
import game.Map;
import game.StageCreator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.learningprogramming.view.StageActivityMoveSurfaceView;
import com.example.learningprogramming.view.StageActivitySurfaceView;

public class StageActivity extends Activity {

	private GestureDetector myGestureDetector;
	private SurfaceView surfaceview;
	private StageActivitySurfaceView stageSurface;
	private StageActivityMoveSurfaceView stageMoveSurface;
	private GameManeger _maneger;
	private ArrayList<Gambit> _gambits = new ArrayList<Gambit>();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.activity_stage3);
		Spinner spinner;
		spinner = (Spinner) findViewById(R.id.Action1);
		System.out.println("spinnnnnnnnnnnnnner");

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item);
		String[] spinnerItemArray = {"ガンビット１", "ガンビット２", "ガンビット３"};
		for (String string : spinnerItemArray) {
			adapter.add(string);
		}
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		Map map = new StageCreator().createStage002();

		_maneger = new GameManeger();
		_maneger.setMap(map);

		// SurfaceViewを参照
		surfaceview = (SurfaceView) findViewById(R.id.SurfaceViewMain);

		// 作成したMainSurfaceViewクラスをインスタンス化
		stageMoveSurface = new StageActivityMoveSurfaceView(this, surfaceview,
				_maneger);

		// stageSurface = new StageActivitySurfaceView(this, surfaceview);
		myGestureDetector = new GestureDetector(new MyGestureListener());
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Thread.interrupted();
	}

	// private BufferedReader loadStageFile(String filename) throws IOException
	// {
	// InputStream is = null;
	// BufferedReader br = null;
	//
	// try {
	// is = this.openFileInput(filename);
	// if (is != null) {
	// br = new BufferedReader(new InputStreamReader(is));
	// }
	// } catch (FileNotFoundException e) {
	// Toast.makeText(this, "ファイルが存在しません", Toast.LENGTH_SHORT).show();
	// } catch (NullPointerException e) {
	// Toast.makeText(this, "ぬるぽ", Toast.LENGTH_SHORT).show();
	// }
	// return br;
	// }

	public void move(View view) {
		_gambits.add(new Gambit(false, GambitCondition.CanRightAndLeft, GambitMotion.Left));
		_gambits.add(new Gambit(true, GambitCondition.CanLeft, GambitMotion.Left));
		_gambits.add(new Gambit(false, GambitCondition.CanForward,GambitMotion.Forward));
		_gambits.add(new Gambit(false, GambitCondition.CanBack,GambitMotion.Back));

		stageMoveSurface.move(_gambits);
	}

	public void reset(View view) {
		stageMoveSurface.reset();
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO 自動生成されたメソッド・スタブ
		if (myGestureDetector.onTouchEvent(event))
			return true;
		else
			return false;
	}

	private class MyGestureListener extends SimpleOnGestureListener {

		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
				float velocityY) {
			// TODO 自動生成されたメソッド・スタブ
			if (velocityX < 0) {
				Intent subactivity = new Intent(StageActivity.this,
						com.example.learningprogramming.GambitActivity.class);
				startActivity(subactivity);
			}
			return false;
		}
	}
}
