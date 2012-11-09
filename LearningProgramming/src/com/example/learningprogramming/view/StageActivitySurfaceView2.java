package com.example.learningprogramming.view;

import game.*;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class StageActivitySurfaceView2 extends SurfaceView implements SurfaceHolder.Callback{
	private final int LENGTH = 40;
	private final int LEFT = 40;
	private final int TOP = 10;
	private final int RIGHT = LEFT + LENGTH;
	private final int BOTTOM = TOP + LENGTH;

	private GameManeger _maneger;
	private SurfaceHolder holder = null;

	public StageActivitySurfaceView2(Context context) {
		super(context);
		initSurface(context);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public StageActivitySurfaceView2(Context context, AttributeSet attrs,
			int defStyle) {
		super(context, attrs, defStyle);
		initSurface(context);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public StageActivitySurfaceView2(Context context, AttributeSet attrs) {
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
	}

	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO 自動生成されたメソッド・スタブ

	}

	public void initSurface(Context context){
		holder = this.getHolder();
		holder.addCallback(this);
		_maneger = new GameManeger();
		_maneger.addGambit(true, GambitCondition.CanRightAndLeft, GambitMotion.Right);
		_maneger.addGambit(false, GambitCondition.CanRight, GambitMotion.Right);
		_maneger.addGambit(true, GambitCondition.CanLeft, GambitMotion.Left);
	}

	public void drawSurface(){

		Canvas canvas = holder.lockCanvas();
		canvas.drawColor(Color.WHITE);
		Paint paint = new Paint();
		for(int h = 0; h < _maneger.getMap().getHeight(); h++){
			for(int w = 0; w < _maneger.getMap().getWidth(); w++){
				Point2 point = new Point2(h, w);
				if(_maneger.getMap().getTile(point).getTileType() == TileType.WALL){
					paint.setColor(Color.BLACK);
					Rect rect = new Rect(LEFT + w * LENGTH, TOP + h * LENGTH, RIGHT + w * LENGTH, BOTTOM + h * LENGTH);
					canvas.drawRect(rect, paint);
				}else if(_maneger.getMap().getTile(point).getTileType() == TileType.NORMAL){
					paint.setColor(Color.GRAY);
					Rect rect = new Rect(LEFT + w * LENGTH, TOP + h * LENGTH, RIGHT + w * LENGTH, BOTTOM + h * LENGTH);
					canvas.drawRect(rect, paint);

				}else if(_maneger.getMap().getTile(point).getTileType() == TileType.GOAL){
					paint.setColor(Color.RED);
					Rect rect = new Rect(LEFT + w * LENGTH, TOP + h * LENGTH, RIGHT + w * LENGTH, BOTTOM + h * LENGTH);
					canvas.drawRect(rect, paint);
				}
			}
		}
		holder.unlockCanvasAndPost(canvas);
	}
}
