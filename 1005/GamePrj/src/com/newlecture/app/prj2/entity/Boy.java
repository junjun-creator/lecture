package com.newlecture.app.prj2.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import com.newlecture.app.prj2.canvas.ActionCanvas;

public class Boy {
	
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
		
		this.x = x-(w/2);
		this.y = y-h;
	}
	
	public boolean isSelected(double x, double y) {
		boolean isSel = false;
		
		for(int i=0;i<3;i++) {
			if((x>=this.x && x<=this.x+this.w) && (y >= this.y && y<=this.y+this.h)) {
				isSel = true;
			}
		}
		
		return isSel;
	}
	
	public void paint(Graphics g) {
		int x = (int)this.x;
		int y = (int)this.y;
		
		//그리기
		g.drawImage(img, x, y, x+w, y+h, 0, 0, w, h, ActionCanvas.instance);
	}
}
