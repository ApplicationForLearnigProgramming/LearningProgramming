package com.example.learningprogramming.view;

import com.example.learningprogramming.R;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import game.*;

public class StageActivityView extends View {

	private final int LENGTH = 40;
	private final int LEFT = 40;
	private final int TOP = 10;
	private final int RIGHT = LEFT + LENGTH;
	private final int BOTTOM = TOP + LENGTH;

	private Bitmap bitmap = null;

	public GameManeger _maneger;

	public StageActivityView(Context context) {
		super(context);
		init(context);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public StageActivityView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public StageActivityView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	private void init(Context context){
		Resources res = context.getResources();
		bitmap = BitmapFactory.decodeResource(res, R.drawable.chara);
	}


	@Override
	protected void onDraw(Canvas canvas) {
		// TODO 自動生成されたメソッド・スタブ
		int length = 40;
		int left = 40;
		int top = 10;
		int right = left + length;
		int bottom = top + length;
		_maneger = new GameManeger();
		super.onDraw(canvas);
		canvas.drawColor(Color.WHITE);
		Paint paint = new Paint();
		for(int h = 0; h < _maneger.getMap().getHeight(); h++){
			for(int w = 0; w < _maneger.getMap().getWidth(); w++){
				Point2 point = new Point2(h, w);
				if(_maneger.getMap().getTile(point).getTileType() == TileType.WALL){
					paint.setColor(Color.BLACK);
					Rect rect = new Rect(left + w * length, top + h * length, right + w * length, bottom + h * length);
					canvas.drawRect(rect, paint);
				}else if(_maneger.getMap().getTile(point).getTileType() == TileType.NORMAL){
					paint.setColor(Color.GRAY);
					Rect rect = new Rect(left + w * length, top + h * length, right + w * length, bottom + h * length);
					canvas.drawRect(rect, paint);

				}else if(_maneger.getMap().getTile(point).getTileType() == TileType.GOAL){
					paint.setColor(Color.RED);
					Rect rect = new Rect(left + w * length, top + h * length, right + w * length, bottom + h * length);
					canvas.drawRect(rect, paint);
				}
			}
		}
		canvas.drawBitmap(bitmap, 10, 40, paint);

	}
}
