package com.mls.CarSharing;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class DriverMainActivity extends BaseActivity {
	
	private final int MENU_ADD = 91;
	private final int MENU_ABOUT = MENU_ADD + 1;
	
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
		showToast("Menu button pressed");
		menu.add(0, MENU_ADD, 0, R.string.add_passenger);
		menu.add(0, MENU_ABOUT, 0, R.string.about);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		if (item.getItemId() == MENU_ADD) {
			
		}
		else if(item.getItemId() == MENU_ABOUT) {
			
		}
		return true;
	}

}
