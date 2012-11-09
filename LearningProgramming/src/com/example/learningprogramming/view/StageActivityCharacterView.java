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

public class StageActivityCharacterView extends View {

	private Bitmap bitmap = null;

	public StageActivityCharacterView(Context context) {
		super(context);
		init(context);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public StageActivityCharacterView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public StageActivityCharacterView(Context context, AttributeSet attrs) {
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
		super.onDraw(canvas);
		if(bitmap != null){
			Paint paint = new Paint();
			canvas.drawBitmap(bitmap, 10, 40, paint);
		}
	}

}
