package com.example.learningprogramming;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class StartView extends View {

	private Bitmap bitmap = null;

	public StartView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO 自動生成されたコンストラクター・スタブ
		init(context);
	}

	public StartView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO 自動生成されたコンストラクター・スタブ
		init(context);
	}

	public StartView(Context context) {
		super(context);
		// TODO 自動生成されたコンストラクター・スタブ
		init(context);
	}

	private void init(Context context) {
		Resources res = context.getResources();
		bitmap = BitmapFactory.decodeResource(res, R.drawable.title);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO 自動生成されたメソッド・スタブ
		super.onDraw(canvas);
		canvas.drawColor(Color.WHITE);
		if (bitmap != null) {
			Paint paint = new Paint();
			canvas.drawBitmap(bitmap, 50, 100, paint);
		}
	}

}
