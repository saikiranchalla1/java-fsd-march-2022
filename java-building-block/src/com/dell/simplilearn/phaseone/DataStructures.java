package com.dell.simplilearn.phaseone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class DataStructures {

	public static void main(String[] args) {
		// 1D array
		// int arr[size] = new int[5]
		
		
		int myArray[] = new int[5];
		
		int my2D[][] = new int[5][5];
		
		// 2D =====>>>>> 1D on storage
		
		
		// a[m][n]
		// Row major ordering = Address(a[i][j]) = (i * n + j) * size 
		
		
		// Column major ordering
		
		// ArrayList
		
		
		List<String> list = new ArrayList<String>();
		
		list.add("Mangod");
		list.add("Apple");
		
		Collections.sort(list);
		
		
		for (String fruit: list) {
			System.out.println(fruit);
		}
		
		System.out.println(list.get(0));
		
		
		list.add(0, "Grape");
		
		
		
		
		LLNode head = new LLNode(1, new LLNode(2, new LLNode(3, new LLNode(4, null))));
		
		
		while (head != null) {
			System.out.println(head.data);
			head = head.next;
		}
		
		
		LinkedList<String> al = new LinkedList<String>();
		
		al.add("a");
		al.add("b");
		al.add("c");
		al.add("c");
		al.add("c");
		al.add("c");
		al.add("c");
		al.add("c");
		
		
		for (String string : al) {
			System.out.println(string);
		}
		
		al.addFirst("0");
		
		al.addLast("10");
		
		Set<String> hashSet = new HashSet<String>();
		
		hashSet.add("a");
		hashSet.add("b");
		hashSet.add("b");
		hashSet.add("b");
		hashSet.add("b");
		
		
		for (String string : hashSet) {
			System.out.println(string);
		}
		
		
		Set<String> treeSet = new TreeSet<String>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		});
		
		
		treeSet.add("z");
		treeSet.add("y");
		treeSet.add("x");
		treeSet.add("a");
		
		
		for (String string : treeSet) {
			System.out.println(string);
		}
		
		
		Map<Integer, String> myMap = new HashMap<Integer, String>();
		
		myMap.put(1, "Dell");
		myMap.put(2, "EMC");
		myMap.put(3, "Yahoo");
		
		for (Map.Entry<Integer, String> entrySet: myMap.entrySet()) {
			System.out.println(entrySet.getKey() + " " + entrySet.getValue());
		}
		
		System.out.println(myMap.containsKey(1));
		
		System.out.println(myMap.containsValue("Dell"));
		
		
		System.out.println("--------------------------");
		
		LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
		linkedHashSet.add("One");
		linkedHashSet.add("Two");
		linkedHashSet.add("Three");
		
		
		for (String string : linkedHashSet) {
			System.out.println(string);
		}
		
		System.out.println(linkedHashSet.remove("Two"));
		System.out.println(linkedHashSet.remove("Four"));
		
		LinkedHashSet<Book> lBooks = new LinkedHashSet<Book>();
		
		lBooks.add(new Book(1, "The Phoenix Project"));
		lBooks.add(new Book(2, "Learning Java"));
		
		for (Book b: lBooks) {
			System.out.println(b);
		}
		
		
		LinkedHashMap<Integer, String> hm = new LinkedHashMap<Integer, String>();
		hm.put(1, "Book 1");
		hm.put(2, "Book 2");
		hm.put(3, "Book 3");
		
		for (Entry<Integer, String> entry : hm.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		
		hm.remove(2);
		
		System.out.println("After removal");
		for (Entry<Integer, String> entry : hm.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		
		LinkedHashMap<Integer, Book> hashMapBooks = new LinkedHashMap<Integer, Book>();
		
		hashMapBooks.put(1, new Book(1, "Book 1"));
		hashMapBooks.put(2, new Book(2, "Book 2"));
		
		
		for (Entry<Integer, Book> entry : hashMapBooks.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		
		
		System.out.println("Demo for PQ");
		
		Queue<Book> queue = new PriorityQueue<Book>();
		
		queue.add(new Book(121, "Book 1"));
		queue.add(new Book(233, "Book 2"));
		queue.add(new Book(101, "Book 3"));
		
		
		for (Book b: queue) {
			System.out.println(b);
		}
		
		
		System.out.println("After removal");
		queue.remove();
		
		for (Book b: queue) {
			System.out.println(b);
		}
		
		System.out.println("Stack demo0-----");
		
		
		Stack<Integer> stack = new Stack<Integer>();
		
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		stack.push(4);
		
		
		System.out.println("Elements int eh stack: " + stack);
		
		System.out.println("Removing an elelent: " + stack.pop());
		
		System.out.println("Is stack empty? " + stack.isEmpty());
		
		Collections.sort(list);
		
	}
	

}

class LLNode {
	int data;
	LLNode next;
	
	
	public LLNode() {
		// TODO Auto-generated constructor stub
	}
	
	
	public LLNode(int data, LLNode next) {
		this.data = data;
		this.next = next;
	}
}



class Book implements Comparable<Book> {
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + "]";
	}

	int id;
	String name;
	
	public Book(int id, String name) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
	}

	@Override
	public int compareTo(Book o) {
		// TODO Auto-generated method stub
		if (id > o.id) {
			return 1;
		} else if (id < o.id) {
			return -1;
		} else {
			return 0;
		}
	}
}

/**
 * [2,7,11,15], 100 - (-1,-1)
 * target 9 (0, 1)
 * 
 * 
 * 
 * 
 * 
**/