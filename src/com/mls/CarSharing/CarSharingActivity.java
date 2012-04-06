package com.mls.CarSharing;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.widget.LinearLayout;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

public class CarSharingActivity extends BaseActivity{
    /** Called when the activity is first created. */
	private AdView adView;
	private String modeKeyString;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            
//        adView=new AdView(this, AdSize.BANNER, "a14f6871d20e495");
//        LinearLayout layout = (LinearLayout)findViewById(R.id.mainLayout);
//
//        // Add the adView to it
//        layout.addView(adView);
//
//        // Initiate a generic request to load it with an ad
//        adView.loadAd(new AdRequest());
        
        modeKeyString = getString(R.string.key_app_mode);
        // check if valid mode exists  
        SharedPreferences sharedPreferences = getSharedPreferences("data", 0);
        int app_mode = sharedPreferences.getInt(modeKeyString, 0);
        if (app_mode == MODE_DRIVER) {
			showToast(getString(R.string.driver));
			startDriverMode();
		}
        else if (app_mode == MODE_PASSENGER) {
			showToast(getString(R.string.passenger));
			startPassengerMode();
		}
        else {
        	showDialog(DIALOG_MODE_SELECTION);
		}
        
        log("Phone Info:" + phoneNumber() + "  " + phoneIMEI());
    }
    
    @Override
    public void onDestroy() {
      if (adView != null) {
        adView.destroy();
      }
      super.onDestroy();
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	super.onActivityResult(requestCode, resultCode, data);
    	if (requestCode == REQUEST_CODE && resultCode == RESULT_CODE) {
    		log("Terminate app");
    		finish();
		}
    }
    
    /*
     * mode selected with value
     * @see com.mls.CarSharing.BaseActivity#selectMode(int)
     */
    @Override
    public void modeSelected(int mode){
    	// record user's mode
    	Editor sharedEditor = getSharedPreferences("data", 0).edit();
    	sharedEditor.putInt(modeKeyString, mode);
    	sharedEditor.commit();
    	
    	if (mode == MODE_DRIVER) {
			showToast(getString(R.string.driver));
			startDriverMode();
		}
    	else if (mode == MODE_PASSENGER) {
			showToast(getString(R.string.passenger));
			startPassengerMode();
		}
    }
    
    private void startDriverMode() {
		Intent intent = new Intent(this, DriverMainActivity.class);
		startActivityForResult(intent, REQUEST_CODE);
	}
    
    private void startPassengerMode() {
		Intent intent = new Intent(this, PassengerMainActivity.class);
		startActivityForResult(intent, REQUEST_CODE);
	}
}