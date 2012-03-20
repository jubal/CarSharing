package com.mls.CarSharing;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

public class CarSharingActivity extends BaseActivity{
    /** Called when the activity is first created. */
	private AdView adView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        adView=new AdView(this, AdSize.BANNER, "a14f6871d20e495");
        LinearLayout layout = (LinearLayout)findViewById(R.id.mainLayout);

        // Add the adView to it
        layout.addView(adView);

        // Initiate a generic request to load it with an ad
        adView.loadAd(new AdRequest());
    }
    
    @Override
    public void onDestroy() {
      if (adView != null) {
        adView.destroy();
      }
      super.onDestroy();
    }
    
}