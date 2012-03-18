package com.mls.CarSharing;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class BaseActivity extends Activity {
	
	private String tagString;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		tagString=this.toString();
	}
	
	/*
	 * log method
	 */
	public void log(String msgString){
		Log.d(tagString, msgString);
	}
	
	/*
	 * Show toast shortcut by content
	 */
	public void showToast(String content){
		showToast(content, Toast.LENGTH_SHORT);
	}
	
	/*
	 * Show toast by content and duration
	 */
	public void showToast(String content, int duration){
		Toast.makeText(getApplicationContext(), content, duration).show();
	}
	
}
