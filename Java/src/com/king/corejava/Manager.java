package com.king.corejava;

import java.util.*;
import java.time.*;
import java.text.*;

public class Manager extends Employee {
	private double bonus;

	public Manager(String name, double salary, int year, int month, int day) {
		super(name, salary, year, month, day);
		bonus = 0;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public double getSalary() {
		double baseSalary = super.getSalary();
		return baseSalary + bonus;
	}

	public String toString() {
		return super.toString() + "[Bonus=" + bonus + "]";
	}

	public static void main(String[] args) {
		var boss = new Manager("Vinay", 20000, 2021, 8, 5);
		boss.setBonus(5000);
		Employee staff[] = new Employee[3];
		staff[0] = boss;
		staff[1] = new Employee("King", 15000, 2021, 8, 6);
		staff[2] = new Employee("Jack", 18000, 2021, 7, 14);
		for (Employee e : staff) {
			System.out.println("Num." + e.id() + ": " + e.getName() + " Salary: "
					+ NumberFormat.getCurrencyInstance().format(e.getSalary()) + " Hireday: " + e.getHireDay());
		}
	}
}
