package com.skilciti.springboot.tutorial.service;

import com.skilciti.springboot.tutorial.entity.Department;
import com.skilciti.springboot.tutorial.errors.ExceptionNotFound;
import com.skilciti.springboot.tutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long departmentId) throws ExceptionNotFound {

        Optional<Department> department =  departmentRepository.findById(departmentId);
        if(!department.isPresent()){
            throw new ExceptionNotFound("Department not found.");
        }

        return department.get();
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department departmentDB = departmentRepository.findById(departmentId).get();

        if (Objects.nonNull(department.getName()) &&
                !"".equalsIgnoreCase(department.getName())) {
            departmentDB.setName(department.getName());
        }
        if (Objects.nonNull(department.getAddress()) &&
                !"".equalsIgnoreCase(department.getAddress())) {
            departmentDB.setAddress(department.getAddress());
        }
        if (Objects.nonNull(department.getCode()) &&
                !"".equalsIgnoreCase(department.getCode())) {
            departmentDB.setCode(department.getCode());
        }
        return departmentRepository.save(departmentDB);
    }

    @Override
    public Department getDepartmentByName(String departmentName) {
        return departmentRepository.findByNameIgnoreCase(departmentName);
    }

}
