package com.newlecture.app.prj3.canvas;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;

import com.newlecture.app.prj3.entity.Boy;
import com.newlecture.app.prj3.entity.Tree;
import com.newlecture.app.prj3.service.BoyService;

public class ActionCanvas extends Canvas {
	
	private Boy boy;//캔버스에 일단 개체를 그려놓고 행위를 시킨다.
	public static Canvas instance;
	private BoyService boys;
	private Boy curBoy;
	private Boy[] otherBoys;
	private int otherIndex=0;
	private int firstClicked;
	private Tree tree;
	private Image buffI;
	private Graphics buffG;
	
	
	public ActionCanvas(Color color) {
		instance = this;
		
		//firstClicked=0;
		//boy = new Boy(100,200);
		
		boys = new BoyService();
		tree = new Tree(200,200);
		
		curBoy=boys.get(0);
		otherBoys = new Boy[2];
		otherBoys[0] = boys.get(1);
		otherBoys[1] = boys.get(2);
		
		this.setBackground(color);
	}

	@Override
	public void paint(Graphics g) {
		Image buffI = this.createImage(this.getWidth(), this.getHeight());
		Graphics buffG = buffI.getGraphics();
		
		for(int i=0;i<3;i++) {//해당 이미지에 해당 도구로 그림을 그림
			boys.get(i).paint(buffG);//새로만든 그래픽도구(그림그리는도구)로 그려서
		}
		
		tree.paint(buffG);
		g.drawImage(buffI,0,0,null);//그 그린 아이를 window 그래픽 도구로 그린다!
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
		

		if(firstClicked == 0) {//처음 선택됫을때에는 움직임 없이 선택만 되도록
			firstClicked = 1;
		}
		else if(firstClicked != 0 && curBoy != null) {/*
			if(buffG == null) {
				buffI = createImage(1500,500);
				if(buffI ==null)
					System.out.println("더블버퍼링용 오프 스크린 생성 실패");
				else
					buffG = buffI.getGraphics();
			}*/
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
						curBoy.update();
						if(curBoy != otherBoys[0])//기존에 curBoy였던 대상을 중복해서 클릭할 경우 방지
							otherBoys[0].update();
						if(curBoy != otherBoys[1])
							otherBoys[1].update();
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
