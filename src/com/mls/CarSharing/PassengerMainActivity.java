package com.mls.CarSharing;

import android.content.Intent;
import android.os.Bundle;

public class PassengerMainActivity extends BaseActivity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public void backButtonPressed(){
		showToast("Back button pressed");
		Intent intent=new Intent();
		intent.putExtra("back", "Back Data");
		setResult(RESULT_CODE, intent);
		finish();
	}
}
