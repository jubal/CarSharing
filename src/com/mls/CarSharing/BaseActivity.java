package com.mls.CarSharing;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.mobclick.android.MobclickAgent;

public class BaseActivity extends Activity implements OnClickListener {
	
	private String mTagString;
	private Context mApplicationContext;
	
	protected static final int DIALOG_MODE_SELECTION = 929;
	protected static final int DIALOG_EXIT_CONFIRM = DIALOG_MODE_SELECTION + 1;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		mTagString=this.toString();
		mApplicationContext=getApplicationContext();
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
	
	@Override
	protected Dialog onCreateDialog(int id){
		switch (id) {
		case DIALOG_MODE_SELECTION:
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			return builder.create();

		default:
			break;
		}
		return super.onCreateDialog(id);
	}
	
	@Override
	public void onClick(View view){
		int id = view.getId();
		if (id == 1) {
			
		}
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
