package com.newlecture.app.prj3.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import com.newlecture.app.prj3.canvas.ActionCanvas;

public class Boy {
	
	private double vx,vy,dx,dy;
	
	private double x;
	private double y;
	int w;
	int h;
	private Image img;
	
	public Boy() {
		this(100,100);
	}
	
	public Boy(double x, double y) {
		//이미지 불러와서 초기화하기
		Toolkit tk = Toolkit.getDefaultToolkit();//알아서 현재 환경에 맞게 툴킷을 얻어줌
		//스태틱 함수. 이 함수에서 return new Toolkit();을 생성
		img = tk.getImage("res/boy.png");
		this.w = 64;
		this.h = 96;
		this.x = x;
		this.y = y;
	}
	
	public void move(double x, double y) {
		
		this.dx = x-(w/2);
		this.dy = y-h;
		
		this.vx = (this.dx-this.x)/15;
		this.vy = (this.dy-this.y)/15;
	}
	/*
	public void paint(Graphics g) {
		int x = (int)this.x;
		int y = (int)this.y;
		//x-w/2, y-h+13, x+w/2, y+h
		
		int x1 = x-w/2;
		int y1 = y-h-13;
		int x2 = x+w/2;
		int y2 = y+h;
		
		g.drawImage(img, x1, y1, x2, y2, 0, 0, w, h, ActionCanvas.instance);
	}*/

	public void paint(Graphics g) {
		int x = (int)this.x;
		int y = (int)this.y;
		
		//그리기
		g.drawImage(img, x, y, x+w, y+h, 0, 0, w, h, ActionCanvas.instance);
	}
	
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public int getW() {
		return w;
	}

	public int getH() {
		return h;
	}

	public void update() {
		//double x = this.x-(w/2);
		//double y = this.y-h+12;
		double offset = 1.0;
		double xMin = this.dx -offset;
		double xMax = this.dx +offset;
		double yMin = this.dy -offset;
		double yMax = this.dy +offset;
		
		if(this.x >= xMin && this.x <= xMax) {
			if(this.y >= yMin && this.y <= yMax) {
				this.vx=0;
				this.vy=0;
			}
		}
		
		this.x += this.vx;
		this.y += this.vy;
	}
	
	
}
