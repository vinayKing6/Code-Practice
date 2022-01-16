package com.king.corejava;

import java.util.*;
import java.time.*;
import static java.lang.System.*;
import static java.lang.Math.*;
import static java.lang.System.out;

public class overloading {
	static int nextId = 1;
	int num;
	String name;
	{
		num = assignId();// 有区域快{}则先编译此部分，否则先编译构造器
		name = " ";
	}

	public overloading() {
		this(LocalDate.now().toString(), nextId);
	}

	public overloading(String str, int number) {
		name = str;
		num = number;
	}

	private static int assignId() {
		return nextId++;
	}

	public static overloading Of(String str, int number) {
		overloading test = new overloading(str, number);
		return test;
	}

	public String toString() {
		String str = name + "-" + num;
		return str;
	}

	public static void main(String args[]) {
		overloading test;
		test = new overloading();
		System.out.println(test.name);
		System.out.println(test.num);
		System.out.println(test.nextId);
		var test1 = new overloading("king", 113);
		System.out.println(test1.name);
		System.out.println(test1.num);
		System.out.println(test1.nextId);
		overloading test2 = overloading.Of("Vinay", 114);
		System.out.println(test2.toString());
		System.out.println(test2.num + " " + test2.nextId);
		out.println("import static");
		out.println(sqrt(9));
		exit(0);
	}
}
