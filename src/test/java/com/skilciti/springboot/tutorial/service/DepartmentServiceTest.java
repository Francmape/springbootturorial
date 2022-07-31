package com.skilciti.springboot.tutorial.service;

import com.skilciti.springboot.tutorial.entity.Department;
import com.skilciti.springboot.tutorial.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Description;

import static org.junit.jupiter.api.Assertions.*;


//SERVICE LAYER
@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .id(56L)
                .name("IT")
                .address("Mombasa")
                .code("KL900")
                .build();

        Mockito.when(departmentRepository.findByNameIgnoreCase("IT")).thenReturn(department);
    }

    @Test
    @DisplayName("Get Data based on valid Department name")
//    @Disabled
    public void whenValidDepartmentName_thenShouldReturnDepartment() {
        String departmentName = "IT";
        Department department = departmentService.getDepartmentByName(departmentName);
        assertEquals(department.getName(),departmentName);
    }
}