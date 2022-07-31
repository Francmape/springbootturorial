package com.skilciti.springboot.tutorial.service;

import com.skilciti.springboot.tutorial.entity.Department;
import com.skilciti.springboot.tutorial.errors.ExceptionNotFound;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchAllDepartments();

    public Department getDepartmentById(Long departmentId) throws ExceptionNotFound;

    public void deleteDepartment(Long departmentId);

    public Department updateDepartment(Long departmentId, Department department);

    public Department getDepartmentByName(String departmentName);
}
