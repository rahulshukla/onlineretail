package com.onlineretail.controller;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.onlineretail.DAO.CategoryDao;
import com.onlineretail.DAO.jdbc.JdbcCategoryDao;
import com.onlineretail.model.Category;
import com.onlineretail.service.*;
import com.onlineretail.service.impl.CategoryServiceImpl;

public class CategoryController {
	public CategoryService categoryService;
	public CategoryDao categoryDao;
	public Scanner scanner;

	public CategoryController() {
		scanner = new Scanner(System.in);
		categoryDao = new JdbcCategoryDao();
		categoryService = new CategoryServiceImpl();
	}

	public String addCategory() throws Exception {
		try {
			System.out.println("Add Category");
			System.out
					.println("----------------------------------------------------");
			String Name, Description;
			System.out.println("Enter Category Name:  ");
			Name = scanner.nextLine();
			System.out.println("Enter Description:  ");
			Description = scanner.nextLine();
			if (categoryService.AddCategory(Name, Description) == 1) {
				return "Category Added";
			} else {
				return "Category Not Added";
			}
		}  catch (Exception e) {
			return e.getMessage();
		}

	}
	
}
