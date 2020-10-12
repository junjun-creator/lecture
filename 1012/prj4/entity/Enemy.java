package com.newlecture.app.prj4.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;

import com.newlecture.app.prj4.canvas.ActionCanvas;

public class Enemy extends Item{
	

	private int timeoutForMoving = 120;
	private Random rand;
	
	public Enemy() {
		this(100, 100);
	}
	
	public Enemy(double x, double y) {
		
		super(x,y,58,35,"res/spaceship.gif");
		
		rand = new Random();
	}

	public void paint(Graphics g) {
		int sx = this.getSx();
		
		int x = (int)this.getX();
		int y = (int)this.getY();
		int walkTemp = this.getWalkTemp();
		int sxIndex = this.getSxIndex();
		
		if(walkTemp == 0) {
			sxIndex++;
			sxIndex %= 12;
			sx = this.getW()*sxIndex;
			
			walkTemp = 6;
		}
		else
			walkTemp--;
		
		g.drawImage(this.getImg(), x, y, x+this.getW(), y+this.getH(), sx, 0, this.getW()+sx, this.getH(), ActionCanvas.instance);
		this.setWalkTemp(walkTemp);
		this.setSxIndex(sxIndex);
		this.setSx(sx);
	}
	
	public void update() {
		
		timeoutForMoving--;
		if(timeoutForMoving ==0) {
			int canvasW = ActionCanvas.instance.getWidth();
			int canvasH = ActionCanvas.instance.getHeight();
			
			int x = rand.nextInt(canvasW-this.getW());
			int y = rand.nextInt(canvasH-this.getH());
			
			this.move(x,y);
			timeoutForMoving = rand.nextInt(60)+60;
		}
		
		double offset = 1.0;//오차범위를 둬야함
		double xMin = this.getDx() -offset;
		double xMax = this.getDx() +offset;
		double yMin = this.getDy() -offset;
		double yMax = this.getDy() +offset;
		
		double x = this.getX();
		double y = this.getY();
		
		if((x >= xMin && x <= xMax) && (y >= yMin && y <= yMax)) {
			this.setVx(0);
			this.setVy(0);
			this.setSxIndex(0);
			timeoutForMoving = 1;// 도착하면 바로 움직이게 하기위해
		}
		x += this.getVx();
		y += this.getVy();
		
		this.setX(x);
		this.setY(y);
	}
}
