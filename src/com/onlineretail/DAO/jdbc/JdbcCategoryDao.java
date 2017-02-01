package com.onlineretail.DAO.jdbc;

import com.onlineretail.DAO.CategoryDao;
import com.onlineretail.model.*;

import java.sql.*;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.onlineretail.DAO.jdbc.ConnectionHelper.*;

public class JdbcCategoryDao implements CategoryDao {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(JdbcCategoryDao.class);

	@Override
	public int Save(Category category) {
		Connection con = null;
		PreparedStatement stmt = null;
		int cnt = 0;
		try {
			con = getMySqlConnection();
			String query = "insert into category(cid,cname,description)"
					+ " values(category_seq.nextval,?,?)";
			stmt = con.prepareStatement(query);
			stmt.setString(1, category.getCname());
			stmt.setString(2, category.getDescription());
			cnt = stmt.executeUpdate();
			con.close();
		} catch (Exception e) {
			// LOGGER.error(e.getMessage());
			e.printStackTrace();
		} finally {
			cleanup(con, stmt, null);
		}
		return cnt;
	}
	
}
