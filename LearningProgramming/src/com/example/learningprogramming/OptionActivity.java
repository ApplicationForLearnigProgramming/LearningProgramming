package com.example.learningprogramming;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class OptionActivity extends Activity implements OnTouchListener, OnClickListener{

    private FrameLayout frameLayout01;
    private ImageView target;

    private int targetLocalX;
    private int targetLocalY;

    private int screenX;
    private int screenY;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test02);
        frameLayout01 = (FrameLayout)findViewById(R.id.FrameLayout01);
        target = (ImageView)findViewById(R.id.ImageView01);
        target.setOnTouchListener(this);
    }

	public boolean onTouch(View v, MotionEvent event) {

        int x = (int)event.getRawX();
        int y = (int)event.getRawY();

        switch(event.getAction()) {
        case MotionEvent.ACTION_DOWN:

        	targetLocalX = target.getLeft();
            targetLocalY = target.getTop();

            screenX = x;
            screenY = y;

            break;

        case MotionEvent.ACTION_MOVE:

            int diffX = screenX - x;
            int diffY = screenY - y;

            targetLocalX -= 0;
            targetLocalY -= diffY;

            target.layout(targetLocalX,
                          targetLocalY,
                          targetLocalX + target.getWidth(),
                          targetLocalY + target.getHeight());

            Log.v("Location", "left=" + targetLocalX + " top=" + targetLocalY);

            screenX = x;
            screenY = y;

            break;

        case MotionEvent.ACTION_UP:

            break;
        }
        return true;
    }

    public void onClick(View v) {
        int childCount = frameLayout01.getChildCount();
        if(childCount == 1) {
            frameLayout01.addView(target);
        }
    }

}
