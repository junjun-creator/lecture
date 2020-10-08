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
	private int walkTemp = 15;//6�� ������ �ȱ�
	
	public Boy() {
		this(100,100);
	}
	
	public Boy(double x, double y) {
		//�̹��� �ҷ��ͼ� �ʱ�ȭ�ϱ�
		Toolkit tk = Toolkit.getDefaultToolkit();//�˾Ƽ� ���� ȯ�濡 �°� ��Ŷ�� �����
		//����ƽ �Լ�. �� �Լ����� return new Toolkit();�� ����
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
		/*//������ �ð����� �̵��ϴ� ��������
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
		
		if(vx != 0 || vy != 0) {//�̵� �������� ���� �ִ� == �̵����� �����̴�
			if(walkTemp == 0) {
				this.sxIndex++;
				this.sxIndex %= 4;
				sx = this.w*this.sxIndex;
				
				walkTemp = 15;
			}
			else
				walkTemp--;
		}
		else//�̵� �������� ���� ���� == ������ �����̴�.
			sx = 0;
		System.out.println(sx);
		//�׸���
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
		double offset = 1.0;//���������� �־���
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
