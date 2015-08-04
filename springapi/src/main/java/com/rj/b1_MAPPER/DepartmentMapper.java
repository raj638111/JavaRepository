package com.rj.b1_MAPPER;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import com.rj.a3_REPOSITORY.DepartmentRepository;
import com.rj.a7_DOMAIN.Department;

// Note : RowCallbackHandler can also be used, but it is stateful #117
public class DepartmentMapper implements RowMapper<Department> {
	
	final static Logger logger = Logger.getLogger(DepartmentMapper.class);
	
	@Override
	public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		logger.debug("Inside mapRow()");
		Department department = new Department();
		department.setDepartmentId(rs.getInt("departmentId"));
		department.setDepartmentName(rs.getString("departmentName"));
		
		return department;
	}

}
