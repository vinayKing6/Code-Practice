package com.king.corejava;

import java.text.*;
import java.util.*;
import java.time.*;

public class Employee extends Person implements Comparable<Employee>,Cloneable{
	private static int nextId = 1;
	private int id;
	private double salary;
	private LocalDate hireDay;

	public Employee(String n, double s, int year, int month, int day) {
		super(n);
		salary = s;
		hireDay = LocalDate.of(year, month, day);
	}
	public Employee(String n) {
		super(n);
		setId();
		salary=0;
		hireDay=LocalDate.now();
	}

	public double getSalary() {
		return salary;
	}

	public LocalDate getHireDay() {
		return hireDay;
	}

	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary += raise;
	}

	public double raise(double byPercent) {
		double raise = (salary * byPercent / 100) + salary;
		return raise;
	}

	public int hashCode() {
		return Objects.hash(id, getName(), salary);
	}

	public boolean equals(Object otherObject) {
		if (this == otherObject)
			return true;

		if (otherObject == null)
			return false;

		if (getClass() != otherObject.getClass())
			return false;
		Employee other = (Employee) otherObject;
		return hashCode() == other.hashCode();
	}

	private void setId() {
		id = nextId;
		nextId++;
	}

	public int id() {
		return id;
	}

	public static int getNextId() {
		return nextId;
	}

	public String getDescription() {
		return "Num." + this.id + " Name:" + super.getName() + " Salary:"
				+ NumberFormat.getCurrencyInstance().format(this.getSalary()) + " Hireday:" + this.getHireDay();
	}

	public String toString() {
		return getClass().getName() + "[ID=" + id + ",Name=" + getName() + ",Salary=" + salary + ",Hireday=" + hireDay
				+ "]";
	}
	@Override
	public int compareTo(Employee e) {
		return Double.compare(salary, e.getSalary());
	}
	@Override
	public Employee clone() throws CloneNotSupportedException{
		Employee cloned=(Employee)super.clone();
		return cloned;
	}
	public static void main(String args[]) {
		var e = new Employee("King", 10000, 1990, 3, 19);
		System.out.println(NumberFormat.getCurrencyInstance().format(e.getSalary()));
	}
}
