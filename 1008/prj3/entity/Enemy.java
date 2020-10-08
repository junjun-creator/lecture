package com.newlecture.app.prj3.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;

import com.newlecture.app.prj3.canvas.ActionCanvas;

public class Enemy {
	private double dx,dy,vx,vy;
	
	private double x;
	private double y;
	
	private Image img;
	private int w;
	private int h;
	
	private int sxIndex = 0;
	private int speed = 2;
	private int walkTemp = 6;

	private int timeoutForMoving = 120;
	private Random rand;
	
	public Enemy() {
		this(100, 100);
	}
	
	public Enemy(double x, double y) {
		Toolkit tk = Toolkit.getDefaultToolkit();//알아서 현재 환경에 맞게 툴킷을 얻어줌
		//스태틱 함수. 이 함수에서 return new Toolkit();을 생성
		img = tk.getImage("res/spaceship.gif");
		
		this.x = x;
		this.y = y;
		this.w = 58;
		this.h = 35;
		rand = new Random();
		this.move(rand.nextInt(1500-this.w), rand.nextInt(500-this.h));
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
		int sx = 0;
		
		int x = (int)this.x;
		int y = (int)this.y;
		
		if(walkTemp == 0) {
			sxIndex++;
			sxIndex %= 12;
			sx = this.w*sxIndex;
			
			walkTemp = 6;
		}
		walkTemp--;
		
		g.drawImage(img, x, y, x+w, y+h, sx, 0, w+sx, h, ActionCanvas.instance);
	}
	
	public void update() {
		
		timeoutForMoving--;
		if(timeoutForMoving ==0) {
			int canvasW = ActionCanvas.instance.getWidth();
			int canvasH = ActionCanvas.instance.getHeight();
			
			int x = rand.nextInt(canvasW-this.w);
			int y = rand.nextInt(canvasH-this.h);
			
			this.move(x,y);
			timeoutForMoving = rand.nextInt(60)+60;
		}
		
		double offset = 1.0;//오차범위를 둬야함
		double xMin = this.dx -offset;
		double xMax = this.dx +offset;
		double yMin = this.dy -offset;
		double yMax = this.dy +offset;
		
		if((this.x >= xMin && this.x <= xMax) && (this.y >= yMin && this.y <= yMax)) {
			this.vx=0;
			this.vy=0;
			timeoutForMoving = 1;// 도착하면 바로 움직이게 하기위해
		}
		this.x += this.vx;
		this.y += this.vy;
	}
}
