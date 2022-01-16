package com.king.corejava;

import AlgorithmForJava.list.myList;

import java.util.ArrayList;
import java.util.List;

public class Student {
	private String name;
	private String major;
	private int id;
	private static String[] originalMajors={"math","chinese","computer","english"};
	private static String[] originalNames={"vinay","king","jack","marry"};

	public Student(String name, String major,int id) {
		this.name=name;
		this.major = major;
		this.id=id;
	}

	public int getId(){
		return id;
	}

	public String getName(){
		return name;
	}

	public String toString() {
		return name+" id:" +id+ " majoring in " + major;
	}

	public static myList<Student> giveMeExamples(int size){
		myList<Student> results=new myList<>();

		for (int i=0;i<size;i++){
			results.disorderdAdd(new Student(originalNames[(int)(Math.random()*originalNames.length)],
					originalMajors[(int)(Math.random()*originalMajors.length)],
					(int)(Math.random()*200+1)));
		}
		return results;
	}

	public static List<Student> giveMeExamplesToList(int size){
		List<Student> results=new ArrayList<>();

		for (int i=0;i<size;i++){
			results.add(new Student(originalNames[(int)(Math.random()*originalNames.length)],
					originalMajors[(int)(Math.random()*originalMajors.length)],
					(int)(Math.random()*200+1)));
		}
		return results;
	}

	public static Student[] giveMeExamplesToArray(int size){
		Student[] results=new Student[size];

		for (int i=0;i<size;i++)
			results[i]=new Student(originalNames[(int)(Math.random()*originalNames.length)],
					originalMajors[(int)(Math.random()*originalMajors.length)],
					(int)(Math.random()*200+1));

		return results;
	}

	public static void main(String[] args) {
		var students=Student.giveMeExamples(10);
		myList.printList(students);
	}
}
