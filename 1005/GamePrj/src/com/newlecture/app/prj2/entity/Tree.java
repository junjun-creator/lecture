package com.newlecture.app.prj2.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import com.newlecture.app.prj2.canvas.ActionCanvas;

public class Tree {
	
	private double x;
	private double y;
	private Image img;
	private int w;
	private int h;
	
	public Tree() {
		this(100,100);
	}
	
	public Tree(double x, double y) {
		Toolkit tk = Toolkit.getDefaultToolkit();//알아서 현재 환경에 맞게 툴킷을 얻어줌
		//스태틱 함수. 이 함수에서 return new Toolkit();을 생성
		img = tk.getImage("res/tree.png");
		
		this.x = x;
		this.y = y;
		this.w = img.getWidth(null);
		this.h = img.getHeight(null);
		System.out.println(w);
	}
	
	public void paint(Graphics g) {
		int x = (int)this.x;
		int y = (int)this.y;
		
		g.drawImage(img, x, y, x+w, y+h, w*3, h*3, w*4, h*4, ActionCanvas.instance);
	}

}
