package com.example.learningprogramming.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import game.*;

public class StageActivityView extends View {

	public StageActivityView(Context context) {
		super(context);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public StageActivityView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public StageActivityView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO 自動生成されたメソッド・スタブ
		GameManeger maneger = new GameManeger();
		super.onDraw(canvas);
		canvas.drawColor(Color.WHITE);
		Paint paint = new Paint();
		for(int h = 0; h < maneger.getMap().getHeight(); h++){
			for(int w = 0; w < maneger.getMap().getWidth(); w++){
				Point2 point = new Point2(h, w);
				if(maneger.getMap().getTile(point).getTileType() == TileType.NORMAL){
					paint.setColor(Color.GRAY);
					Rect rect = new Rect(10, 100, 20, 110);
					canvas.drawRect(rect, paint);
				}
			}
		}
		/*
		paint.setColor(Color.GRAY);
		Rect rect = new Rect(10, 100, 20, 110);
		canvas.drawRect(rect, paint);
*/
	}

}
