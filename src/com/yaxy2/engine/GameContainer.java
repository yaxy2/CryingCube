package com.yaxy2.engine;

import java.awt.Color;

public class GameContainer implements Runnable {

	private Thread th;
	
	private Window gameWindow;
	
	private boolean running = false;
	
	Renderer r;
	
	public GameContainer() {
		
	}
	
	public void start() {
		
		gameWindow = new Window();
		
		r = new Renderer();
		
		th = new Thread(this);
		th.run();
	}
	
	public void stop() {
		
	}
	
	public void run() {

		running = true;
		
		boolean render = false;
		
		double frstTime = 0;
		double lstTime = System.nanoTime() / 1000000000.0;
		double pssdTime = 0;
		double unprTime = 0;
		
		double frameTime = 0;
		int frames = 0;
		int fps = 0;
		
		while(running){
			
			render = false;
			
			frstTime = System.nanoTime() / 1000000000.0;
			pssdTime = frstTime - lstTime;
			lstTime = frstTime;
			
			unprTime += pssdTime;
			
			frameTime += pssdTime;
			
			while(unprTime >= (1/GameAttributes.FRAMERATE)){
				
				unprTime -= (1/GameAttributes.FRAMERATE);
				render = true;
				//System.out.println("moin");
				
				if(frameTime >= 1.0) {
					
					frameTime = 0;
					fps = frames;
					frames = 0;
					
				}
			}
			
			if(render){
				
				frames++;
				
				//////////////////////////////////////////////////////////////////
				
				gameWindow.update(r.getP(),fps);
				//r.rainbow(0, 0.5);
				r.lsd();
				
				
				/////////////////////////////////////////////////////////////////
				
			}else{
			
				try{
				
					Thread.sleep(1);
				}catch(InterruptedException e){
					
					e.printStackTrace();
				}
			}
		}
		
		dispose();
	}
	
	private void dispose() {
		
	}
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		GameContainer gameContainer = new GameContainer();
		gameContainer.start();
		

	}

}
