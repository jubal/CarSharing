package com.mls.CarSharing;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.mobclick.android.MobclickAgent;

public class BaseActivity extends Activity implements OnClickListener {
	
	private String mTagString;
	private Context mApplicationContext;
	
	//
	// option menu tag
	protected static final int MENU_ABOUT = 91;
	
	protected static final int MODE_DRIVER = 624;
	protected static final int MODE_PASSENGER = MODE_DRIVER + 1;
	
	protected static final int DIALOG_MODE_SELECTION = 825;
	protected static final int DIALOG_EXIT_CONFIRM = DIALOG_MODE_SELECTION + 1;
	protected static final int DIALOG_ABOUT = DIALOG_EXIT_CONFIRM + 1;
	
	public final static int REQUEST_CODE = 1;
	public final static int RESULT_CODE = REQUEST_CODE + 1;
	
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
	public boolean onCreateOptionsMenu(Menu menu){
		menu.add(0, MENU_ABOUT, 0, R.string.about);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onPrepareOptionsMenu(Menu menu){
		return super.onPrepareOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		if(item.getItemId() == MENU_ABOUT) {
			showAbout();
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	protected Dialog onCreateDialog(int id){
		switch (id) {
		case DIALOG_MODE_SELECTION:{
			final CharSequence[] itemsCharSequences = {getString(R.string.driver), 
					getString(R.string.passenger)};
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle(R.string.mode_selection_title);
			builder.setCancelable(false);
			builder.setSingleChoiceItems(itemsCharSequences, -1, new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					if (which == 0) {
						modeSelected(MODE_DRIVER);
					}
					else if (which == 1){
						modeSelected(MODE_PASSENGER);
					}
					dismissDialog(DIALOG_MODE_SELECTION);
				}
			});
			return builder.create();
		}
		case DIALOG_ABOUT:{
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle(R.string.app_name);
			builder.setMessage(R.string.statement);
			builder.setPositiveButton(R.string.close, new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					dismissDialog(DIALOG_ABOUT);
				}
			});
			return builder.create();
		}
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
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event){
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			log("Back button pressed");
			backButtonPressed();
		}
		
		//
		// shoud return false to let it continue to transfer
		return false;
	}
	
	public void backButtonPressed(){
		
	}
	
	public void modeSelected(int appMode) {
		
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
	
	public void showAbout() {
		showDialog(DIALOG_ABOUT);
	}
	
	/*
	 * Return user's phone number
	 */
	public String phoneNumber(){
		TelephonyManager tm = (TelephonyManager)mApplicationContext.getSystemService(Context.TELEPHONY_SERVICE); 
		String tel = tm.getLine1Number();
		log(tel);
		return tel;
	}
	
	/*
	 * Return user's phone IMEI
	 */
	public String phoneIMEI(){
		TelephonyManager tm = (TelephonyManager)mApplicationContext.getSystemService(Context.TELEPHONY_SERVICE); 
		String imei = tm.getDeviceId(); 
		log(imei);
		return imei;
	}
}
