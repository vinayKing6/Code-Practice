package com.king.corejava;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

import javax.swing.Timer;

public class TalkingClock {
	private int interval;
	private boolean beep;
	
	public TalkingClock(int interval,boolean beep) {
		this.interval=interval;
		this.beep=beep;
	}
	public void start() {
		class TimePrinter implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("At the tone, the time is: "+Instant.ofEpochMilli(e.getWhen()));
				if(beep) {
					Toolkit.getDefaultToolkit().beep();
				}
			}			
		}
		var listener=new TimePrinter();
		var timer=new Timer(interval,listener);
		timer.start();
	}
// inner class:
//	public class TimePrinter implements ActionListener{
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			System.out.println("At the tone, the time is "+Instant.ofEpochMilli(e.getWhen()));
//			if(beep) {
//				Toolkit.getDefaultToolkit().beep();
//			}
//		}
//
//	}
}
