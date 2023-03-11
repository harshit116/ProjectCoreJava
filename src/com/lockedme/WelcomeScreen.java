package com.lockedme;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WelcomeScreen {
	static ArrayList<String> list = new ArrayList<>();

	public static void main(String[] args) {
		list.add("Harshit.txt");
		list.add("Mishra.txt");
		list.add("Adarsh.java");
		System.out.println("         	WELCOME TO LOCKEDME.COM");
		mainScreen();

	}

	public static void mainScreen() {

		// Printing the UI

		System.out.println();
		System.out.println("		Choose any of the below Option");
		System.out.println("Choose (1) for viewing all the files");
		System.out.println("Choose (2) for adding,deleting or searching the file");
		System.out.println("Choose (3) for closing the application");

		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		if (input == 1) {
			Collections.sort(list);
			System.out.println(list);
			mainScreen();
		} else if (input == 2) {
			deeper();
			mainScreen();
		} else if (input == 3) {
			System.out.println("Thanku you are out of the Application");
			System.exit(0);
		} else {
			System.out.println("Please Enter the valid Input");
			
			mainScreen();
		}
	}

	public static void deeper() {
		System.out.println("Please press (p) for Adding the file");
		System.out.println("Please press (q) for deleting the file");
		System.out.println("Please press (r) for Searching the file");
		System.out.println("Please press (s) for going back to Main Screen");
		Scanner sc = new Scanner(System.in);  
		String input = sc.next();
		if (input.equals("p") || input.equals("P")) {
			System.out.println("please enter the file name");
			String file = sc.next();
			list.add(file);
			System.out.println("Your file is succesfully added to record");
			deeper();
		} else if (input.equals("q") || input.equals("Q")) {
			System.out.println("Please Enter the file name to Delete");
			String file = sc.next();
			if (search(file)) {
				list.remove(file);
				System.out.println("Your file has been Deleted");
				deeper();
			} else {
				System.out.println("The file you want to delete is not present");
				deeper();
			}
		} else if (input.equals("r") || input.equals("R")) {
			System.out.println("Enter the file that you want to search");
			String file = sc.next();
			if (search(file)) {
				System.out.println("Your file is present in the record " + "(" + file + ")");
				deeper();
			} else {
				System.out.println("The file you want to search is not in the List");
				deeper();
			}
		} else if (input.equals("s") || input.equals("S")) {
			return;
		} else {
			System.out.println("Please Enter the valid Option");
			deeper();
		}

	}

	public static boolean search(String file) {
		if (list.contains(file)) {
			return true;
		} else {
			return false;
		}
	}
}
