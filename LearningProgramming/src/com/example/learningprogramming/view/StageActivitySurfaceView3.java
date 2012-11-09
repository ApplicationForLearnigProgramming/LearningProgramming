package com.example.learningprogramming.view;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.example.learningprogramming.R;

import game.*;
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
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class StageActivitySurfaceView3 extends SurfaceView implements SurfaceHolder.Callback{
	private final int LENGTH = 40;
	private final int LEFT = 40;
	private final int TOP = 10;
	private final int RIGHT = LEFT + LENGTH;
	private final int BOTTOM = TOP + LENGTH;

	private GameManeger _maneger;
	private SurfaceHolder holder = null;
	private Bitmap bitmap = null;

	private int _lastX;
	private int _lastY;

	public StageActivitySurfaceView3(Context context) {
		super(context);
		initSurface(context);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public StageActivitySurfaceView3(Context context, AttributeSet attrs,
			int defStyle) {
		super(context, attrs, defStyle);
		initSurface(context);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public StageActivitySurfaceView3(Context context, AttributeSet attrs) {
		super(context, attrs);
		initSurface(context);
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

	public void initSurface(Context context){
		holder = this.getHolder();
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
		_lastX = _maneger.getMap().getCharacter().getLocation().x * LENGTH + TOP;
		_lastY = _maneger.getMap().getCharacter().getLocation().y * LENGTH + LEFT;
	}

	public void drawSurface(){

		Canvas canvas = holder.lockCanvas();
		Paint paint = new Paint();

		if(bitmap != null){
			canvas.drawBitmap(bitmap, _lastY, _lastX, paint);
		}

		holder.unlockCanvasAndPost(canvas);
	}

	public void doAnim(){
		ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
		executor.scheduleAtFixedRate(new Runnable(){
			public void run() {
				// TODO 自動生成されたメソッド・スタブ
				_lastY++;
				drawSurface();
			}

		}, 0, 20, TimeUnit.MILLISECONDS);
	}

}
