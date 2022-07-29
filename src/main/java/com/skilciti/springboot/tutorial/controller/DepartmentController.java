package com.skilciti.springboot.tutorial.controller;

import com.skilciti.springboot.tutorial.entity.Department;
import com.skilciti.springboot.tutorial.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    public DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        LOGGER.info("DepartmentController: saveDepartment");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchAllDepartments() {
        LOGGER.info("DepartmentController: fetchAllDepartments");
        return departmentService.fetchAllDepartments();
    }

    @GetMapping("/departments/{id}")
    public Department getDepartmentById(@PathVariable("id") Long departmentId) {
        LOGGER.info("DepartmentController: getDepartmentById");
        return departmentService.getDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartment(@PathVariable("id") Long departmentId) {
        LOGGER.info("DepartmentController: deleteDepartment");
        departmentService.deleteDepartment(departmentId);
        return "Department deleted successfully";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department) {
        LOGGER.info("DepartmentController: updateDepartment");
        return departmentService.updateDepartment(departmentId, department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
        LOGGER.info("DepartmentController: fetchDepartmentByName");
        return departmentService.fetchDepartmentByName(departmentName);
    }

}
