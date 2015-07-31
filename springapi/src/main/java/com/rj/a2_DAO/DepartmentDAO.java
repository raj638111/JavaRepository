package com.rj.a2_DAO;

import java.util.List;

import com.rj.a1_DOMAIN.Department;

public interface DepartmentDAO {
    public void insert(Department Department);
    public void update(Department Department);
    public void update(List<Department> Departments);
    public void delete(long DepartmentId);
    public List<Department> select();
    
    //public Department select(long DepartmentId);
    //public List<Department> find(List<Long> DepartmentIds);
    //public List<Department> find(String ownerName);
    //public List<Department> find(boolean locked);
}
