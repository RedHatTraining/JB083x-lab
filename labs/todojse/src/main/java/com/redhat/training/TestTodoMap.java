package com.redhat.training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestTodoMap {
	public static void main(String[] args) {
		TodoMap testMap=new TodoMap();

		boolean timeToQuit = false;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		do {
			try {
				timeToQuit = executeMenu(in, testMap);
			} catch (IOException e) {
				System.out.println("Could not read the input");
			}
		} while (!timeToQuit);

	}

	public static boolean executeMenu(BufferedReader in, TodoMap todo) throws IOException {

		String action;
		int id;

		System.out.println("\n\n[N]ew | [C]omplete | [R]ead | [D]elete | [L]ist | [Q]uit: ");
		action = in.readLine();
		if ((action.length() == 0) || action.toUpperCase().charAt(0) == 'Q') {
			return true;
		}

		switch (action.toUpperCase().charAt(0)) {
		// Create a new todo record
		case 'N':
			todo.addTodo();
			System.out.println("Successfully added new todo item: ");
			break;

		// Display an todo record
		case 'R':
			System.out.println("Enter int value for item id: ");
			id = new Integer(in.readLine().trim());
			todo.findItemTodo(id);
			break;

		// Mark an existing task as completed
		case 'C':
			System.out.println("Enter int value for item id: ");
			id = new Integer(in.readLine().trim());
			todo.completeTodo(id);
			break;


		// Delete an todo record
		case 'D':
			System.out.println("Enter int value for item id: ");
			id = new Integer(in.readLine().trim());
			todo.deleteTodo(id);
			System.out.println("Deleted item " + id);
			break;

		// Display a list (Read the records) of todo
		case 'L':
			todo.printTodo();
			break;
		}

		return false;
	}

	}
