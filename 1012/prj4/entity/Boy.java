package com.newlecture.app.prj4.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import com.newlecture.app.prj4.canvas.ActionCanvas;

public class Boy extends Item{
	
	
	public Boy() {
		this(100,100);
	}
	
	public Boy(double x, double y) {
		/*
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
		this.sxIndex = 0;*/
		
		super(x,y,64,96,"res/boy.png");
	}
	
	public void paint(Graphics g) {
		
		
		int x = (int)this.getX();
		int y = (int)this.getY();
		int walkTemp = this.getWalkTemp();
		int sxIndex = this.getSxIndex();
		
		int sx = this.getSx();
		
		
		if(this.getVx() != 0 || this.getVy() != 0) {//이동 단위벡터 값이 있다 == 이동중인 상태이다
			if(walkTemp == 0) {
				sxIndex++;
				sxIndex %= 4;
				//this.setSx(this.getW()*sxIndex);
				sx = this.getW()*sxIndex;
				
				walkTemp = 6;
			}
			else
				walkTemp--;
			
		}
		else//이동 단위벡터 값이 없다 == 정지한 상태이다.
			sx = 0;
		
		//그리기
		g.drawImage(this.getImg(), x, y, x+this.getW(), y+this.getH(), this.getSx(), 0, this.getW()+this.getSx(), this.getH(), ActionCanvas.instance);
		this.setWalkTemp(walkTemp);
		this.setSxIndex(sxIndex);
		this.setSx(sx);
	}
	/*
	public double getVx() { // 추상화 하면서 Item 클래스에 선언 되어있는걸 여기서 또 선언하면
							// stackoverflow 에러가 뜬다. 주의하자.
		return this.getVx();
	}

	public double getX() {
		return this.getX();
	}

	public double getY() {
		return this.getY();
	}

	public int getW() {
		return this.getW();
	}

	public int getH() {
		return this.getH();
	}*/

	public void update() {
		//double x = this.x-(w/2);
		//double y = this.y-h+12;
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
		}
		x += this.getVx();
		y += this.getVy();
		
		this.setX(x);
		this.setY(y);
	}
	
}
