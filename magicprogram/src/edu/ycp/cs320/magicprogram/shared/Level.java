package edu.ycp.cs320.magicprogram.shared;

import java.io.Serializable;

public class Level implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int levelNumber;
	private int size_of_wave;
	private int data1;

	private int data2;

	private int data3;
	
	
	public Level() {
		
	}
	
	public void setsize_of_wave(int size) {
		this.size_of_wave = size;
	}
	
	public int getsize_of_wave() {
		return size_of_wave;
	}

	public int getData1() {
		return data1;
	}

	public void setData1(int data1) {
		this.data1 = data1;
	}

	public int getData2() {
		return data2;
	}

	public void setData2(int data2) {
		this.data2 = data2;
	}

	public int getData3() {
		return data3;
	}

	public void setData3(int data3) {
		this.data3 = data3;
	}
	
}
