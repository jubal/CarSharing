package com.mls.CarSharing;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class DriverMainActivity extends BaseActivity {
	
	private final int MENU_ADD = MENU_ABOUT + 1;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.drivermain);
	}
	
	@Override
	public void backButtonPressed(){
		showToast("Back button pressed in driver");
		Intent intent=new Intent();
		intent.putExtra("back", "Back Data");
		setResult(RESULT_CODE, intent);
		finish();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		menu.add(0, MENU_ADD, 0, R.string.add_passenger);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onPrepareOptionsMenu(Menu menu){
		log("Menu button pressed");
		return super.onPrepareOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		log("Options item selected " + item.getItemId());
		if (item.getItemId() == MENU_ADD) {
			
		}
		return super.onOptionsItemSelected(item);
	}

}
