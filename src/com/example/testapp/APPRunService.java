package com.example.testapp;

import java.util.ArrayList;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class APPRunService extends Service {
	ArrayList<String> apps = new ArrayList<String>();
	double intervalTime = 10;
	double stopTime = 10;
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return new MyBinder();
	}

	 @Override
	    public boolean onUnbind(Intent intent) {
	        System.out.println("on  unbind");
	        return super.onUnbind(intent);
	    }
	 
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		
		
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
	
	
	 public class MyBinder extends Binder implements IService {

		@Override
		public void setIntervalTime(double time) {
			// TODO Auto-generated method stub
			APPRunService.this.intervalTime = time;
		}

		@Override
		public void setEndTime(double time) {
			// TODO Auto-generated method stub
			APPRunService.this.stopTime = time;
		}

		@Override
		public void startRunApp() {
			// TODO Auto-generated method stub
			APPRunService.this.startRunApp();
		}

		@Override
		public void stopRunApp() {
			// TODO Auto-generated method stub
			APPRunService.this.stopRunApp();
		}

		@Override
		public void setAppList(ArrayList<String> apps) {
			APPRunService.this.apps = apps;
			
		}
	       
	    }
	 
	 public void  startRunApp(){
		 
	 }
	 
	 public void stopRunApp(){
		 
	 }
}
