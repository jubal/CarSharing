package com.mls.CarSharing;

import com.mobclick.android.MobclickAgent;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class BaseActivity extends Activity {
	
	private String mTagString;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		mTagString=this.toString();
		MobclickAgent.onError(this);
		log("onCreate");
	}
	
	@Override
	public void onStart(){
		super.onStart();
		log("onStart");
	}
	
	@Override
	public void onResume(){
		super.onResume();
		MobclickAgent.onResume(this);
		log("onResume");
	}
	
	@Override
	public void onPause(){
		super.onPause();
		MobclickAgent.onPause(this);
		log("onPause");
	}
	
	@Override
	public void onStop(){
		super.onStop();	
		log("onStop");
	}
	
	@Override
	public void onDestroy(){
		super.onDestroy();
		log("onDestroy");
	}
	
	/*
	 * log method
	 */
	public void log(String msgString){
		Log.d(mTagString, msgString);
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
