package com.redhat.training;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TodoMap {

	Map<Integer, TodoItem> todoMap;
	static Integer count = 0;
	TodoItem item;
	Scanner scn;

	public TodoMap() {
		this.todoMap = new HashMap<Integer,TodoItem>();
	}

	public void addTodo() {
		String ans = "Y";
		do {

			item = new TodoItem();
			count++;
			scn = new Scanner(System.in);
			System.out.println("Enter item description:");
			item.setItem(scn.nextLine());
			System.out.println("Is todo item completed? [Y/N]:");
			String state = scn.nextLine();
			String status = "";

			if (state.toUpperCase().charAt(0) == 'Y')
				status = Status.COMPLETED.toString();
			else
				status = Status.PENDING.toString();

			item.setStatus(status);
			todoMap.put(new Integer(count), item);
			System.out.println("Do you want to add more items[Y/N]");
			ans = scn.next().toUpperCase();

		} while(ans.equalsIgnoreCase("Y"));

	}

	public void printTodo() {
		System.out.println("---- There are " + todoMap.size() + " items in the list ----");
		for (Integer key : todoMap.keySet()) {
			System.out
					.println(key + " - " + todoMap.get(key).getItem() + " - " + todoMap.get(key).getStatus());
		}

	}

	public void completeTodo(int key) {

		if (todoMap.get(key).getStatus().equals(Status.COMPLETED.toString()))
		{
			System.out.println("This item is already COMPLETED.\n");
		}
		else
		{
			item = new TodoItem();
			String i = todoMap.get(key).getItem();
			item.setItem(i);
			item.setStatus(Status.COMPLETED.toString());
			todoMap.replace(key, item);
			System.out.println("Marked item #" +key+ " as COMPLETE.\n");
			printTodo();
		}
	}


	public void deleteTodo(int id) {

		System.out.println("Enter id of item to be deleted");
		scn = new Scanner(System.in);
		todoMap.remove(id);
		System.out.println("Item removed\n");

	}

	public void findItemTodo(int id) {
		System.out.println("\n");
		System.out.println(id + " - " + todoMap.get(id).getItem() + " - " + todoMap.get(id).getStatus());

	}

}
