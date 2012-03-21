package com.mls.CarSharing;


import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.text.format.Time;
import android.util.Log;

public class CarSharingService extends Service {
	private static final String TAG = "CarSharingService";
	private CarBinder mBinder = new CarBinder();
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		log("onBind");
		return mBinder;
	}
	
	@Override
	public void onCreate(){
		log("onCreate");
		super.onCreate();
	}
	
	@Override
	public void onStart(Intent intent, int startId){
		log("onStart");
		super.onStart(intent, startId);
	}
	
	@Override
	public void onDestroy(){
		log("onDestroy");
		super.onDestroy();
	}
	
	@Override  
    public boolean onUnbind(Intent intent) {  
        log("onUnbind");
        return super.onUnbind(intent);  
    }  

	public String getSystemDate() {
		Time time = new Time();
		time.setToNow();
		return "" + time.year + "-" + time.month + "-" + time.weekDay;
	}
	
	private void log(String content){
		Log.v(TAG, content);
	}
	
	public class CarBinder extends Binder{
		CarSharingService getService()
		{
			return CarSharingService.this;
		}
	}
}
