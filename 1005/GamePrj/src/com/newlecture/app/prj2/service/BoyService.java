package com.newlecture.app.prj2.service;

import java.util.Random;

import com.newlecture.app.prj2.entity.Boy;

public class BoyService {
	private Boy[] boys;
	
	
	public BoyService() {
		boys = new Boy[3];
		
		Random random = new Random();
		
		for(int i=0;i<3;i++) {
			int x = random.nextInt(300);
			int y = random.nextInt(300);
			boys[i] = new Boy(x,y);
		}
	}
	
	public Boy get(int i) {
		return boys[i];
	}
	
	/*
	public void move(Boy boy,int x, int y) {
		boy.move(x,y);
	}*/
}
