package com.newlecture.app.prj4.canvas;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;

import com.newlecture.app.prj4.entity.Background;
import com.newlecture.app.prj4.entity.Boy;
import com.newlecture.app.prj4.entity.Enemy;
import com.newlecture.app.prj4.entity.Item;
import com.newlecture.app.prj4.entity.Tree;
import com.newlecture.app.prj4.service.BoyService;

public class ActionCanvas extends Canvas {
	
	private Boy boy;//ĵ������ �ϴ� ��ü�� �׷����� ������ ��Ų��.
	public static Canvas instance;
	private BoyService boys;
	private Boy curBoy;
	private Boy[] otherBoys;
	private int otherIndex=0;
	private int firstClicked;
	private Tree tree;
	private Image buffI;
	private Graphics buffG;
	private Enemy enemy;
	private Background background;
	private Item[] items;
	private int itemSize=0;
		
	public ActionCanvas(Color color) {
		instance = this;
		
		//firstClicked=0;
		//boy = new Boy(100,200);
		
		boys = new BoyService();
		enemy = new Enemy(100,100);
		//tree = new Tree(200,200);
		
		curBoy=boys.get(0);
		otherBoys = new Boy[2];
		otherBoys[0] = boys.get(1);
		otherBoys[1] = boys.get(2);
		
		background = new Background();
		
		items = new Item[100];
		items[0] = background;
		items[1] = boys.get(0);
		items[2] = boys.get(1);
		items[3] = boys.get(2);
		items[4] = enemy;
		itemSize = 5;
		
		this.setBackground(color);
	}

	@Override
	public void paint(Graphics g) {
		Image buffI = this.createImage(this.getWidth(), this.getHeight());
		Graphics buffG = buffI.getGraphics();
		
		for(int i=0;i<itemSize;i++) {//�ش� �̹����� �ش� ������ �׸��� �׸�
			items[i].paint(buffG);//���θ��� �׷��ȵ���(�׸��׸��µ���)�� �׷���
		}
		
		//tree.paint(buffG);
		//enemy.paint(buffG);
		g.drawImage(buffI,0,0,null);//�� �׸� ���̸� window �׷��� ������ �׸���!
	}
	
	@Override
	public void update(Graphics g) {
		paint(g);
	}

	public boolean mouseDown(Event evt, int x, int y) {
	
		int isSelected = boys.find(x, y);
		
		if(isSelected != -1) {
			otherBoys[0]= curBoy;
			curBoy = boys.get(isSelected);
			//System.out.println(otherBoys[0].getVx());
			for(int i=0;i<3;i++) {
				if(i != isSelected && otherBoys[0] != boys.get(i))
					otherBoys[1] = boys.get(i);
			}
			firstClicked = 0;
		}
		

		if(firstClicked == 0) {//ó�� ���õ��������� ������ ���� ���ø� �ǵ���
			firstClicked = 1;
		}
		else if(firstClicked != 0 && curBoy != null) {
			curBoy.move(x, y);
		}
		
		repaint();
	      
		return super.mouseDown(evt, x, y);
	}

	public void start() {

		Runnable sub = new Runnable() {

			@Override
			public void run() {

				while (true) {
					if(curBoy != null) {
						for(int i=0;i<itemSize;i++) {
							items[i].update();
						}
					}
					repaint();
					try {
						Thread.sleep(17);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};

		Thread th = new Thread(sub);
		th.start();
	}

	
}
