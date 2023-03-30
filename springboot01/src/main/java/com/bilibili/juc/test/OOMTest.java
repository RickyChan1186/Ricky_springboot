package com.bilibili.juc.test;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author ricky
 * @create 2022-12-30 9:56
 */
public class OOMTest {
	public static void main(String[] args) {
		ArrayList<Picture> list = new ArrayList<>();
		while(true){
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			list.add(new Picture(new Random().nextInt(100 * 50)));
		}
	}
}

class Picture{
	private byte[] pixels;

	public Picture(int length) {
		this.pixels = new byte[length];
	}

	public byte[] getPixels() {
		return pixels;
	}

	public void setPixels(byte[] pixels) {
		this.pixels = pixels;
	}
}