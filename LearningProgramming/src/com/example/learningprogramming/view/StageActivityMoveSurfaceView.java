package com.example.learningprogramming.view;

import game.GambitCondition;
import game.GambitMotion;
import game.GameManeger;
import game.Map;
import game.Point2;
import game.TileType;

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
			Map map) {
		super(context);
		initSurface(context, attrs, map);
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

	public void initSurface(Context context, SurfaceView sv, Map map) {
		holder = sv.getHolder();
		holder.addCallback(this);
		Resources res = context.getResources();
		bitmap = BitmapFactory.decodeResource(res, R.drawable.chara);
		int width = bitmap.getWidth();
		int height = bitmap.getHeight();
		int newWidth = 40;
		int newHeight = 40;
		float scaleWidth = ((float) newWidth) / width;
		float scaleHeight = ((float) newHeight) / height;
		Matrix matrix = new Matrix();
		matrix.postScale(scaleWidth, scaleHeight);

		bitmap = bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);

		_maneger = new GameManeger();
		_maneger.setMap(map);
		_maneger.addGambit(true, GambitCondition.CanRightAndLeft,
				GambitMotion.Right);
		_maneger.addGambit(false, GambitCondition.CanRight, GambitMotion.Right);
		_maneger.addGambit(true, GambitCondition.CanLeft, GambitMotion.Left);
		_maneger.addGambit(false, GambitCondition.CanForward,
				GambitMotion.Forward);

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

		if (bitmap != null) {
			canvas.drawBitmap(bitmap, _lastY, _lastX, paint);
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
						while (_lastY != _nextY && _flag) {
							try {
								_lastY -= 4 * ((_lastY - _nextY) / Math
										.abs(_lastY - _nextY));
								Thread.sleep(_speed);
								drawSurface();
							} catch (InterruptedException e) {
								// TODO 自動生成された catch ブロック
								e.printStackTrace();
							}

						}
						while (_lastX != _nextX && _flag) {
							try {
								_lastX -= 4 * ((_lastX - _nextX) / Math
										.abs(_lastX - _nextX));
								Thread.sleep(_speed);
								drawSurface();
							} catch (InterruptedException e) {
								// TODO 自動生成された catch ブロック
								e.printStackTrace();
							}

						}
					}
				}
			}
		}, 0, _speed, TimeUnit.MILLISECONDS);

	}

	public void move() {
		_flag = true;
	}

	public void reset() {
		Log.d("FLAG", "OK");
		_flag = false;
		_maneger.reset();
		_maneger.addGambit(true, GambitCondition.CanRightAndLeft,
				GambitMotion.Right);
		_maneger.addGambit(false, GambitCondition.CanRight, GambitMotion.Right);
		_maneger.addGambit(true, GambitCondition.CanLeft, GambitMotion.Left);
		_maneger.addGambit(false, GambitCondition.CanForward,
				GambitMotion.Forward);
		_lastX = _maneger.getMap().getCharacter().getLocation().x * LENGTH
				+ TOP;
		_lastY = _maneger.getMap().getCharacter().getLocation().y * LENGTH
				+ LEFT;

		drawSurface();
	}

}
