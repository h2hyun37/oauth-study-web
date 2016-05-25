package com.h2hyun37.biz.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class RecursiveQuickSortWithGeneric {

	public class Employee implements Comparable<Employee> {

		private int id;
		private String name;

		public int getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public void setId(int id) {
			this.id = id;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Employee(int id, String name) {
			this.id = id;
			this.name = name;
		}

		@Override
		public int compareTo(Employee o) {

			return id - o.getId();
		}

		@Override
		public String toString() {
			return "id == " + id + "," + "name == " + name;
		}

	}

	public static void main(String[] args) {

		RecursiveQuickSortWithGeneric qs = new RecursiveQuickSortWithGeneric();

		List<Employee> list = new ArrayList<Employee>();

		Employee emp1 = qs.new Employee(6, "kook6");
		list.add(emp1);
		Employee emp2 = qs.new Employee(756, "kook756");
		list.add(emp2);
		Employee emp3 = qs.new Employee(79, "kook79");
		list.add(emp3);
		Employee emp4 = qs.new Employee(1, "kook1");
		list.add(emp4);
		Employee emp5 = qs.new Employee(9999, "kook9999");
		list.add(emp5);
		Employee emp6 = qs.new Employee(42, "kook42");
		list.add(emp6);

		List<Employee> sorted = qs.sort(list);

		for (Employee num : sorted) {
			System.out.println(num);
		}

	}

	public <T extends Comparable<T>> List<T> sort(List<T> list) {

		if (list.size() <= 1) {
			return list;
		}

		T pivot = list.get(0);

		List<T> left = new ArrayList<T>();
		List<T> right = new ArrayList<T>();


		for (int i = 1; i < list.size(); i++) {

			T element = list.get(i);

			if (element.compareTo(pivot) <= 0) {
				left.add(element);
			} else {
				right.add(element);
			}
		}

		List<T> sortedLeft = sort(left);
		List<T> sortedRight = sort(right);

		sortedLeft.add(pivot);
		sortedLeft.addAll(sortedRight);


		return sortedLeft;

    }
}