package com.newlecture.app.prj1;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;

public class GameCanvas extends Canvas {
	
	private Image img;
	private int[] dIndex;
	private int[] sIndex;
	int imgCount;
	public GameCanvas(Color color) {
		imgCount = 6;
		dIndex = new int[]{1,2,3,4,5,6};
		sIndex = new int[]{1,2,3,4,5,6};
		Random rd = new Random();
		for(int i=0;i<100;i++) {
			int a = rd.nextInt(imgCount);
			int b = rd.nextInt(imgCount);
			int temp = dIndex[a];
			dIndex[a] = dIndex[b];
			dIndex[b] = temp;
		}
		
		Toolkit tk = Toolkit.getDefaultToolkit();//알아서 현재 환경에 맞게 툴킷을 얻어줌
					//스태틱 함수. 이 함수에서 return new Toolkit();을 생성
		img = tk.getImage("res/바다.jpg");
		
		this.setBackground(color);
	}
	
	@Override
	   public boolean mouseDown(Event evt, int x, int y) {
	      
	      System.out.printf("x:%d, y:%d\n", x, y);
	      
	      Random rand = new Random();
	      for(int i=0; i<100; i++) {
	         int p1 = rand.nextInt(6);
	         int p2 = rand.nextInt(6);
	         
	         int temp = dIndex[p1];
	         dIndex[p1] = dIndex[p2];
	         dIndex[p2] = temp;
	      }
	      
	      repaint();
	      
	      return super.mouseDown(evt, x, y);
	}

	
	@Override
	public void paint(Graphics g) {
		int dividedWidth = img.getWidth(this)/3;
		int dividedHeight = img.getHeight(this)/2;
		
		for(int i=0;i<6;i++) {
			int di = dIndex[i];
			int si = sIndex[i];
			
			if(di != 0) {
				
				int xOffset_d = (di-1)%3;
				int yOffset_d = (di-1)/3;
				
				int xOffset_s = (si-1)%3;
				int yOffset_s = (si-1)/3;
				
				int dx1 = dividedWidth*xOffset_d;
				int dy1 = dividedHeight*yOffset_d;
				int dx2 = dividedWidth*(xOffset_d+1);
				int dy2 = dividedHeight*(yOffset_d+1);
				
				int sx1 = dividedWidth*xOffset_s;
				int sy1 = dividedHeight*yOffset_s;
				int sx2 = dividedWidth*(xOffset_s+1);
				int sy2 = dividedHeight*(yOffset_s+1);
				
				//g.drawImage(img, 0+dividedWidth*((di-1)%3),0+dividedHeight*((di-1)/3),0+dividedWidth*((di-1)%3+1),0+dividedHeight*((di-1)/3+1), 0+dividedWidth*((si-1)%3),0+dividedHeight*((si-1)/3),0+dividedWidth*((si-1)%3+1),0+dividedHeight*((si-1)/3+1), this);
				g.drawImage(img, dx1/2, dy1/2, dx2/2, dy2/2, sx1, sy1, sx2, sy2, this);
			}
		}
			
		
		/*
		Random rd = new Random();
		int count = 0;
		
		while(count < 6) {
			int di = rd.nextInt(6)+1;
			int si = rd.nextInt(6)+1;
			
			if(this.dIndex[di-1]==0 || this.sIndex[si-1]==0)
				continue;
			else {
				System.out.println(di+" "+si);
				g.drawImage(img, 0+dividedWidth*((di-1)%3),0+dividedHeight*((di-1)/3),0+dividedWidth*((di-1)%3+1),0+dividedHeight*((di-1)/3+1), 0+dividedWidth*((si-1)%3),0+dividedHeight*((si-1)/3),0+dividedWidth*((si-1)%3+1),0+dividedHeight*((si-1)/3+1), this);
				this.dIndex[di-1] = 0;
				this.sIndex[si-1] = 0;
				count++;
			}
		}
		this.dIndex = new int[] {1,2,3,4,5,6};
		this.sIndex = new int[] {1,2,3,4,5,6};*/
		
		/*
		for(int i=0;i<2;i++) {
			for(int j=0;j<3;j++) {
				g.drawImage(img, 0+dividedWidth*(2-j),0+dividedHeight*i,dividedWidth*(3-j),dividedHeight*(i+1), 0+dividedWidth*j,0+dividedHeight*i,dividedWidth*(j+1),dividedHeight*(i+1), this);
			}
		}*/
		//g.drawImage(img, 0+(img.getWidth(this)/3)*2,0,img.getWidth(this),img.getHeight(this)/2, 0,0,(img.getWidth(this)/3),img.getHeight(this)/2, this);//observer는 기준을 어디로 둘 것인가
		//g.drawImage(img, 100,100,200,200, 100,0,200,100, this);
	}
}
