package com.example.testapp;

import java.util.ArrayList;

public interface IService {
	public void setAppList(ArrayList<String> apps);
	public void setIntervalTime(double time);
	public void setEndTime(double time);
	public void startRunApp();
	public void stopRunApp();
}
