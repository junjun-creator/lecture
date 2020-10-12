package com.newlecture.app.prj4.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public abstract class Item {
	private double dx,dy,vx,vy;
	
	private double x;
	private double y;
	
	private Image img;
	private int w;
	private int h;
	
	private int sx = 0;
	private int sxIndex = 0;
	private int speed = 2;
	private int walkTemp = 6;
	
	public Item() {
		this(0,0,0,0,null);
	}
	
	public Item(double x, double y, String imgSrc) {
		this(x,y,0,0,imgSrc);
	}
	
	public Item(double x, double y, int w, int h, String imgSrc) {
		Toolkit tk = Toolkit.getDefaultToolkit();//알아서 현재 환경에 맞게 툴킷을 얻어줌
		//스태틱 함수. 이 함수에서 return new Toolkit();을 생성
		img = tk.getImage(imgSrc);
		this.x = x;
		this.y = y;
		this.vx = 0;
		this.vy = 0;
		
		this.w = w;
		this.h = h;
	}

	public abstract void update();
	
	public abstract void paint(Graphics g);//추상메서드의 강요
	
	public void move(double x, double y) {
		/*//동일한 시간내에 이동하는 단위벡터
		this.dx = x-(w/2);
		this.dy = y-h;
		
		this.vx = (this.dx-this.x)/15;
		this.vy = (this.dy-this.y)/15;*/
		
		this.dx = x-(w/2);
		this.dy = y-h;
		
		double w = this.dx - this.x;
		double h = this.dy - this.y;
		double d = Math.sqrt(w*w + h*h);
		
		this.vx = (w/d)*speed;
		this.vy = (h/d)*speed;
	}

	public double getDx() {
		return dx;
	}

	public void setDx(double dx) {
		this.dx = dx;
	}

	public double getDy() {
		return dy;
	}

	public void setDy(double dy) {
		this.dy = dy;
	}

	public double getVx() {
		return vx;
	}

	public void setVx(double vx) {
		this.vx = vx;
	}

	public double getVy() {
		return vy;
	}

	public void setVy(double vy) {
		this.vy = vy;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int getSxIndex() {
		return sxIndex;
	}

	public void setSxIndex(int sxIndex) {
		this.sxIndex = sxIndex;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getWalkTemp() {
		return walkTemp;
	}

	public void setWalkTemp(int walkTemp) {
		this.walkTemp = walkTemp;
	}
	public int getSx() {
		return sx;
	}

	public void setSx(int sx) {
		this.sx = sx;
	}
}
