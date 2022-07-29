package com.skilciti.springboot.tutorial.repository;

import com.skilciti.springboot.tutorial.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    public Department findByName(String name);
    public Department findByNameIgnoreCase(String name);
}
