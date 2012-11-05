package com.example.learningprogramming;

import android.app.*;
import android.content.*;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doAction(View view){
    	final Activity activity = this;
		Intent intent = new Intent(activity, com.example.learningprogramming.GameMenuActivity.class);
    	activity.startActivity(intent);
    }

    public void moveOption(View view){
    	final Activity activity = this;
		Intent intent = new Intent(activity, com.example.learningprogramming.OptionActivity.class);
    	activity.startActivity(intent);
    }

}
