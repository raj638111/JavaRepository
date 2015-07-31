package com.rj.a3_REPOSITORY;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.rj.a1_DOMAIN.Department;
import com.rj.a2_DAO.DepartmentDAO;

@Repository								/*	
										 	+	Inherits @Component
											+	Generally used for Database related operations
										*/
public class DepartmentRepository implements DepartmentDAO {
	
	final static Logger logger = Logger.getLogger(DepartmentRepository.class);
	private Map<Integer, Department> departments = new HashMap<Integer, Department>();
	
	//@Autowired								
	//private DriverManagerDataSource ds;	
										/*
											+ 	Datasource to access database #107
											+	??? : Is it possible to use 'DataSource' here?
	 									*/
	@Autowired
	private JdbcTemplate template;		/*	+	Template acts as a wrapper around DataSource
										*/
	//-----------------------------------------------------------
	
	DepartmentRepository() {
		logger.debug("## Inside Constructor");
	}
	
	@PostConstruct			//Used to define Lifecycle call backs. Is a JSR-250 annotation(#@PostConstruct)(#62)
	public void setup() throws SQLException  { 
		logger.debug("## Inside setup()");
		//TODO : Optimize this 'cross cutting concern' using Spring aspect
		//departments.put(1, new Department(1, "ECE"));
		//Connection connection;
		//connection = ds.getConnection();
		//logger.debug("## Connection status -> " + connection.isClosed());
		//?? : What if I make a call to API before setup is initialized
		
		
		
		logger.debug("## Exitting setup()");
	}
	
	
	@PreDestroy
	public void destroy() {
		logger.debug("## Inside destroy()");
		
		logger.debug("## Exitting destroy()");
	}

	//-----------------------------------------------------------
	
	//Return all departments as a List
	public List<Department> getAll() {
		return new ArrayList<Department>(departments.values());
		
	}

	
	@Override
	public void insert(Department Department) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Department Department) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(List<Department> Departments) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long DepartmentId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Department> select() {
		// TODO Auto-generated method stub
		return null;
	}

}
