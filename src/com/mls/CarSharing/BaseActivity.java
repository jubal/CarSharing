package com.mls.CarSharing;

import android.app.Activity;
import android.widget.Toast;

public class BaseActivity extends Activity {

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
