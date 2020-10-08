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
	int sxIndex;
	private int sx = 0;
	private int speed=2;
	private int walkTemp = 15;//6배 느리게 걷기
	
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
		this.vx = 0;
		this.vy = 0;
		this.sxIndex = 0;
	}
	
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
	
	public void paint(Graphics g) {
		
		
		int x = (int)this.x;
		int y = (int)this.y;
		
		if(vx != 0 || vy != 0) {//이동 단위벡터 값이 있다 == 이동중인 상태이다
			if(walkTemp == 0) {
				this.sxIndex++;
				this.sxIndex %= 4;
				sx = this.w*this.sxIndex;
				
				walkTemp = 15;
			}
			else
				walkTemp--;
		}
		else//이동 단위벡터 값이 없다 == 정지한 상태이다.
			sx = 0;
		System.out.println(sx);
		//그리기
		g.drawImage(img, x, y, x+w, y+h, sx, 0, w+sx, h, ActionCanvas.instance);
	}
	
	public double getVx() {
		return vx;
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
		double offset = 1.0;//오차범위를 둬야함
		double xMin = this.dx -offset;
		double xMax = this.dx +offset;
		double yMin = this.dy -offset;
		double yMax = this.dy +offset;
		
		if((this.x >= xMin && this.x <= xMax) && (this.y >= yMin && this.y <= yMax)) {
			this.vx=0;
			this.vy=0;
		}
		this.x += this.vx;
		this.y += this.vy;
	}
	
}
