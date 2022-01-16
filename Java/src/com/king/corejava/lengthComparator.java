package com.king.corejava;

import java.util.Comparator;

public class lengthComparator implements Comparator<String>{
	public int compare(String first,String second) {
		System.out.println("method 1");
		return first.length()-second.length();
	}
	public static int compared(String fir,String sec) {
		System.out.println("method 2");
		return fir.length()-sec.length();
	}

}
