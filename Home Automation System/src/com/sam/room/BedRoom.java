package com.sam.room;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sam.devices.AirConditioner;
import com.sam.devices.Device;
import com.sam.devices.DeviceBasicFunctions;
import com.sam.devices.Fan;
import com.sam.devices.Light;
import com.sam.devices.MusicPlayer;
import com.sam.devices.Television;
import com.sam.devices.markerIF.BedRoomIF;

public class BedRoom implements Room{
	
	String name;
	List<BedRoomIF> brDL;

	public BedRoom() {
		this.brDL=new ArrayList<BedRoomIF>();
		name = "BedRoom";
	}
	
	public String getName() {
		return name;
	}


	Scanner sc=new Scanner(System.in);
	@Override
	public DeviceBasicFunctions addDevice(int ch) {
		switch(ch) {
			case 1:{
				Fan obj = new Fan();
				this.brDL.add(obj);
				return obj;
			}
			case 2:{
				Light obj = new Light();
				this.brDL.add(obj);
				return obj;
			}
			case 3:{
				Television obj = new Television();
				this.brDL.add(obj);
				return obj;
			}
			case 4:{
				AirConditioner obj = new AirConditioner();
				this.brDL.add(obj);
				return obj;
			}
			case 5:{
				MusicPlayer obj = new MusicPlayer();
				this.brDL.add(obj);
				return obj;
			}
			default:{
				System.out.println("Invalid entry!!!");
				return null;
			}
		}
		
	}

	@Override
	public void controlDeviceR() {
		if(brDL.size()==0) {
			System.out.println("You have no devices in this room!");
		}
		else {
			for(int i=0;i<brDL.size();i++) {
				Device obj = (Device) brDL.get(i);
				System.out.println((i+1)+"."+obj.getdName());
			}
			System.out.println("Select Device:");
			int n=sc.nextInt();
			brDL.get(n-1).controlDevice();
			
		}
		
	}

	@Override
	public void getList(int flag) {
		if(flag==1) {
			for(int i=0;i<brDL.size();i++) {
				brDL.get(i).getStatus();	
			}			
		}
		else {
			for(int i=0;i<brDL.size();i++) {
				Device obj = (Device)brDL.get(i);
				System.out.println("\t"+(i+1)+"."+obj.getdName());
			}
		}
		
	}
	
}
