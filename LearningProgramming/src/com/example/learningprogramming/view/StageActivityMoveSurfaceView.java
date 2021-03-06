package com.example.learningprogramming.view;

import game.Direction4;
import game.Gambit;
import game.GambitCondition;
import game.GambitMotion;
import game.GameManeger;
import game.Map;
import game.Point2;
import game.TileType;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.learningprogramming.R;

public class StageActivityMoveSurfaceView extends SurfaceView
		implements
			SurfaceHolder.Callback {
	private final int LENGTH = 40;
	private final int LEFT = 40;
	private final int TOP = 10;
	private final int RIGHT = LEFT + LENGTH;
	private final int BOTTOM = TOP + LENGTH;
	private int _speed = 100;

	private boolean _flag = false;
	private GameManeger _maneger;
	private SurfaceHolder holder = null;
	private Bitmap bitmap = null;
	private Bitmap _charaUP = null;
	private Bitmap _charaRIGHT = null;
	private Bitmap _charaDOWN = null;
	private Bitmap _charaLEFT = null;
	private int _lastX;
	private int _lastY;
	private int _nextX;
	private int _nextY;

	private boolean _isGoal = false;

	public StageActivityMoveSurfaceView(Context context) {
		super(context);
		// initSurface(context);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public StageActivityMoveSurfaceView(Context context, AttributeSet attrs,
			int defStyle) {
		super(context, attrs, defStyle);
		// initSurface(context);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public StageActivityMoveSurfaceView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// initSurface(context);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public StageActivityMoveSurfaceView(Context context, SurfaceView attrs,
			GameManeger maneger) {
		super(context);
		initSurface(context, attrs, maneger);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO 自動生成されたメソッド・スタブ

	}

	public void surfaceCreated(SurfaceHolder holder) {
		// TODO 自動生成されたメソッド・スタブ
		drawSurface();
		doAnim();
	}

	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO 自動生成されたメソッド・スタブ

	}

	public void initSurface(Context context, SurfaceView sv, GameManeger maneger) {
		holder = sv.getHolder();
		holder.addCallback(this);
		Resources res = context.getResources();
		bitmap = BitmapFactory.decodeResource(res, R.drawable.chara);
		_charaDOWN = BitmapFactory.decodeResource(res, R.drawable.chara_down);
		_charaUP = BitmapFactory.decodeResource(res, R.drawable.chara_up);
		_charaLEFT = BitmapFactory.decodeResource(res, R.drawable.chara_left);
		_charaRIGHT = BitmapFactory.decodeResource(res, R.drawable.chara_right);
		int width = bitmap.getWidth();
		int height = bitmap.getHeight();
		int newWidth = 40;
		int newHeight = 40;
		float scaleWidth = ((float) newWidth) / width;
		float scaleHeight = ((float) newHeight) / height;
		Matrix matrix = new Matrix();
		matrix.postScale(scaleWidth, scaleHeight);

		bitmap = bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);

		_maneger = maneger;

		_lastX = _maneger.getMap().getCharacter().getLocation().x * LENGTH
				+ TOP;
		_lastY = _maneger.getMap().getCharacter().getLocation().y * LENGTH
				+ LEFT;

	}

	public void drawSurface() {

		Canvas canvas = holder.lockCanvas();
		canvas.drawColor(Color.WHITE);
		Paint paint = new Paint();

		for (int h = 0; h < _maneger.getMap().getHeight(); h++) {
			for (int w = 0; w < _maneger.getMap().getWidth(); w++) {
				Point2 point = new Point2(h, w);
				if (_maneger.getMap().getTile(point).getTileType() == TileType.WALL) {
					paint.setColor(Color.BLACK);
					Rect rect = new Rect(LEFT + w * LENGTH, TOP + h * LENGTH,
							RIGHT + w * LENGTH, BOTTOM + h * LENGTH);
					canvas.drawRect(rect, paint);
				} else if (_maneger.getMap().getTile(point).getTileType() == TileType.NORMAL) {
					paint.setColor(Color.GRAY);
					Rect rect = new Rect(LEFT + w * LENGTH, TOP + h * LENGTH,
							RIGHT + w * LENGTH, BOTTOM + h * LENGTH);
					canvas.drawRect(rect, paint);

				} else if (_maneger.getMap().getTile(point).getTileType() == TileType.GOAL) {
					paint.setColor(Color.RED);
					Rect rect = new Rect(LEFT + w * LENGTH, TOP + h * LENGTH,
							RIGHT + w * LENGTH, BOTTOM + h * LENGTH);
					canvas.drawRect(rect, paint);
				}
			}
		}

		if(_maneger.getMap().getCharacter().getDirection() == Direction4.DOWN){
			if (_charaDOWN != null) {
				canvas.drawBitmap(_charaDOWN, _lastY, _lastX, paint);
			}
		}else if(_maneger.getMap().getCharacter().getDirection() == Direction4.UP){
			if (_charaUP != null) {
				canvas.drawBitmap(_charaUP, _lastY, _lastX, paint);
			}
		}else if(_maneger.getMap().getCharacter().getDirection() == Direction4.LEFT){
			if (_charaLEFT != null) {
				canvas.drawBitmap(_charaLEFT, _lastY, _lastX, paint);
			}
		}else if(_maneger.getMap().getCharacter().getDirection() == Direction4.RIGHT){
			if (_charaRIGHT != null) {
				canvas.drawBitmap(_charaRIGHT, _lastY, _lastX, paint);
			}
		}

		holder.unlockCanvasAndPost(canvas);
	}

	public void doAnim() {
		ScheduledExecutorService executor = Executors
				.newSingleThreadScheduledExecutor();

		executor.scheduleAtFixedRate(new Runnable() {
			public void run() {
				// TODO 自動生成されたメソッド・スタブ
				if (_flag) {
					if (!_isGoal) {
						_isGoal = _maneger.advanceTurn();
						_nextX = _maneger.getMap().getCharacter().getLocation().x
								* LENGTH + TOP;
						_nextY = _maneger.getMap().getCharacter().getLocation().y
								* LENGTH + LEFT;
						if(_maneger.isWarp()){
							while (_lastY != _nextY && _flag) {
									_lastY -= 4 * ((_lastY - _nextY) / Math
											.abs(_lastY - _nextY));
									drawSurface();
							}
							while (_lastX != _nextX && _flag) {
									_lastX -= 4 * ((_lastX - _nextX) / Math
											.abs(_lastX - _nextX));
									drawSurface();
							}
						}else{
							try{
								Thread.sleep(500);
								_lastX = _nextX;
								_lastY = _nextY;
								drawSurface();
								Thread.sleep(500);
							} catch (InterruptedException e) {
								System.out.println(e);
							}
						}
					}
				}
			}
		}, 0, _speed, TimeUnit.MILLISECONDS);

	}

	public void move(ArrayList<Gambit> gambits) {
		for(int i = 0 ; i < gambits.size(); i++){
			_maneger.addGambit(gambits.get(i).goStraight(), gambits.get(i).getGambitCondition(), gambits.get(i).getGambitMotion());
			Log.v("GAMBIT ", ":" + gambits.get(0));
		}
		_flag = true;
	}

	public void reset() {
		Log.d("FLAG", "OK");
		_flag = false;
		_maneger.reset();
		_lastX = _maneger.getMap().getCharacter().getLocation().x * LENGTH
				+ TOP;
		_lastY = _maneger.getMap().getCharacter().getLocation().y * LENGTH
				+ LEFT;

		drawSurface();
	}

}
