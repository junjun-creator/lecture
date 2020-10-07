package com.newlecture.app.prj3.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import com.newlecture.app.prj3.canvas.ActionCanvas;

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
		Toolkit tk = Toolkit.getDefaultToolkit();//�˾Ƽ� ���� ȯ�濡 �°� ��Ŷ�� �����
		//����ƽ �Լ�. �� �Լ����� return new Toolkit();�� ����
		img = tk.getImage("res/tree.png");
		
		this.x = x;
		this.y = y;
		this.w = 128;
		this.h = 128;
		System.out.println(w);
	}
	
	public void paint(Graphics g) {
		int x = (int)this.x;
		int y = (int)this.y;
		
		g.drawImage(img, x, y, x+w, y+h, w*3, h*3, w*4, h*4, ActionCanvas.instance);
	}

}
