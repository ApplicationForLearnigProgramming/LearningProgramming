package com.example.learningprogramming;

import android.app.*;
import android.content.*;
import android.os.Bundle;
import android.view.View;

public class GameMenuActivity extends Activity {
	final Activity activity = this;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamemenu);
    }

    public void doAction(View view){

		Intent intent = new Intent(activity, com.example.learningprogramming.MainActivity.class);
    	activity.startActivity(intent);
    }

    public void moveStageSelectActivity(View view){
    	Intent intent = new Intent(activity, com.example.learningprogramming.StageSelectActivity.class);
    	activity.startActivity(intent);
    }

    public void moveTutorialActivity(View view){
    	Intent intent = new Intent(activity, com.example.learningprogramming.TutorialActivity.class);
    	activity.startActivity(intent);
    }
}
