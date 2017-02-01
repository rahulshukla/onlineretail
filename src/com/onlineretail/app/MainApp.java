package com.onlineretail.app;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.onlineretail.DAO.CategoryDao;
import com.onlineretail.DAO.jdbc.JdbcCategoryDao;
import com.onlineretail.controller.*;

public class MainApp {

	static CategoryController categoryController;
	static CategoryDao categoryDao;

	static Scanner scanner;
	static int choice = 0;
	static String message = null;

	public static void main(String[] args) {
		int result = 0;
		try {
			initialize();
			System.out
					.println("************************************************************************");
			System.out.println("				Online Retail								");
			System.out
					.println("************************************************************************");
			System.out.println("1. Login");
			System.out.println("2. Register");
			System.out.println("3. Exit");
			System.out
					.println("----------------------------------------------------");
			System.out.println("Enter the Choice: ");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				adminOperation();
				break;
			case 2:
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void initialize() {
		scanner = new Scanner(System.in);
		categoryController = new CategoryController();
		categoryDao = new JdbcCategoryDao();
	}

	public static void adminOperation() {
		String ch = "y";
		int subChoice = 0;
		do {
			try {

				System.out.println("Main Menu");
				System.out
						.println("----------------------------------------------------");
				System.out.println("1. Category ");
				System.out.println("\t1. Add Category ");
				System.out.println("\t2. Back ");

				System.out.println("Enter the Choice for Admin Operation: ");
				choice = scanner.nextInt();

				switch (choice) {
				case 1:
					System.out
							.println("Enter the Choice for Category Operation: ");
					subChoice = scanner.nextInt();

					switch (subChoice) {
					case 1:
						try {
							message = categoryController.addCategory();
							System.out.println(message);
						} 
						catch (Exception e) {
							System.out.println(e.getMessage());
						}
						scanner.nextLine();
						break;
					case 2:
						scanner.nextLine();
						break;
					default:
						System.out.println("Invalid Choice");
						scanner.nextLine();
						break;
					}
					break;
				default:
					System.out.println("Invalid Choice");
					scanner.nextLine();
					break;
				}
				System.out.println("Do you want to continue Y/N");
				ch = scanner.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("Invalid Choice");
				scanner.nextLine();
				System.out.println("Enter Valid Choice: ");
				ch = scanner.nextLine();
			} catch (Exception e1) {

			}
		} while (ch.equals("Y") || ch.equals("y"));

	}
}
