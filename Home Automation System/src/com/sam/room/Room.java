package com.sam.room;

import com.sam.devices.DeviceBasicFunctions;

public interface Room {
	public DeviceBasicFunctions addDevice(int ch);
	public void controlDeviceR();
	public String getName();
	public void getList(int i);
}
