package com.king.corejava;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

import javax.swing.Timer;


public class TimePrinter implements ActionListener{
	public void greet(ActionEvent event) {
		System.out.println("Testing time is "+Instant.ofEpochMilli(event.getWhen()));
	}
	public void actionPerformed(ActionEvent event) {
		System.out.println("At the tone, the time is "+Instant.ofEpochMilli(event.getWhen()));
		Toolkit.getDefaultToolkit().beep();
	}
	public static void messageRepeat(String text,int delay) {
		ActionListener listener=event->{
			System.out.println(text);
			Toolkit.getDefaultToolkit().beep();
		};
		var timer=new Timer(delay,listener);
		timer.start();
	}
}
