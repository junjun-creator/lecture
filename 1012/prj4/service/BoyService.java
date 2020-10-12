package com.newlecture.app.prj4.service;

import java.util.Random;

import com.newlecture.app.prj4.entity.Boy;


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
	
	public int find(double x, double y) {
		int selectedIndex = -1;
		for(int i=0;i<3;i++)
			if((x >= boys[i].getX() && x <= boys[i].getX()+boys[i].getW()) && (y >= boys[i].getY() && y <= boys[i].getY()+boys[i].getH()))
				selectedIndex = i;
		
		return selectedIndex;
	}
}
