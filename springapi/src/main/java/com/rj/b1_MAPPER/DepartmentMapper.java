package com.rj.b1_MAPPER;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rj.a1_DOMAIN.Department;

public class DepartmentMapper implements RowMapper<Department> {

	@Override
	public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
		Department department = new Department();
		department.setDepartmentId(rs.getInt("departmentId"));
		department.setDepartmentName(rs.getString("departmentName"));
		
		return department;
	}

}
