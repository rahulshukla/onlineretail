package com.onlineretail.service.impl;

import java.util.*;

import com.onlineretail.DAO.*;
import com.onlineretail.DAO.jdbc.*;
import com.onlineretail.model.*;
import com.onlineretail.service.*;

public class CategoryServiceImpl implements CategoryService {

	private CategoryDao categorydao;

	public CategoryServiceImpl() {
		categorydao = new JdbcCategoryDao();
	}

	public int AddCategory(String Name, String Description) throws Exception {
		int result = 0;
				Category category = new Category(Name, Description);
				result = categorydao.Save(category);
		return result;
	}


}

