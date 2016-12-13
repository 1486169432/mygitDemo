package com.example.testapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity implements OnClickListener{

    private AlertDialog mIntervalDialog,mEndDialog;
	private Button startbutton,interval_button,end_button;
	private MyConn conn;
	public IService iService;


	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitView();
        InitintervalDialog();
        InitendDialog();
        Intent intent = new Intent(this, APPRunService.class);
        conn = new MyConn();
        startService(intent);
        bindService(intent, conn, Context.BIND_AUTO_CREATE);
    }
    
   

	private void InitView() {
    	startbutton = (Button)findViewById(R.id.start_button);
    	interval_button = (Button)findViewById(R.id.interval_button);
    	end_button = (Button)findViewById(R.id.end_button);
    	startbutton.setOnClickListener(this);
    	interval_button.setOnClickListener(this);
    	end_button.setOnClickListener(this);
	}

	 private class MyConn implements ServiceConnection{

		@Override
		public void onServiceConnected(ComponentName arg0, IBinder service) {
			iService = (IService) service;
			
		}

		@Override
		public void onServiceDisconnected(ComponentName arg0) {
			// TODO Auto-generated method stub
			
		}
		 
	 };

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.start_button:
			iService.setAppList(null);
			iService.setIntervalTime(0);
			iService.setEndTime(0);
			iService.startRunApp();
		     
			break;
			
		case R.id.interval_button:
			mIntervalDialog.show();
			break;
					
		case R.id.end_button:
			mEndDialog.show();
			break;

		}
		
	}
	
	//列表对话框
	private void InitintervalDialog() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		// 设置对话框的图标
		// builder.setIcon(R.drawable.radio_icon);
		// 设置对话框的标题
		builder.setTitle("选择执行的时间间隔");

		builder.setItems(R.array.interval_time, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				// String
				String hoddy = getResources().getStringArray(R.array.interval_time)[which];
				// Log.d(TAG, "InitPtyDialog which = " + which);
				interval_button.setText("间隔:" + hoddy);
			}
		});
		// 创建一个列表对话框
		mIntervalDialog = builder.create();
	}
	
	 private void InitendDialog() {
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			// 设置对话框的图标
			// builder.setIcon(R.drawable.radio_icon);
			// 设置对话框的标题
			builder.setTitle("选择结束时间");

			builder.setItems(R.array.end_time, new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					// String
					String hoddy = getResources().getStringArray(R.array.end_time)[which];
					// Log.d(TAG, "InitPtyDialog which = " + which);
					end_button.setText("结束:" + hoddy);
				}
			});
			// 创建一个列表对话框
			mEndDialog = builder.create();
		 
		}
}
