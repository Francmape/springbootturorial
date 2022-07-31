package com.skilciti.springboot.tutorial.controller;

import com.skilciti.springboot.tutorial.entity.Department;
import com.skilciti.springboot.tutorial.errors.ExceptionNotFound;
import com.skilciti.springboot.tutorial.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder()
                .id(1L)
                .name("Engineering")
                .address("Rabai")
                .code("SWEN900")
                .build();
    }

    @Test
    void saveDepartment() throws Exception {
        Department inputDepartment = Department.builder()
                .name("Engineering")
                .address("Rabai")
                .code("SWEN900")
                .build();

        Mockito.when(departmentService.saveDepartment(inputDepartment))
                .thenReturn(department);

        mockMvc.perform(post("/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"name\":\"SNAKE\",\n" +
                        "    \"address\":\"Baraton\",\n" +
                        "    \"code\":\"BR700\"\n" +
                        "}"))
                .andExpect(status().isOk());
    }

    @Test
    void getDepartmentById() throws Exception {

        Mockito.when(departmentService.getDepartmentById(1L))
                .thenReturn(department);

        mockMvc.perform(get("/departments/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(department.getName()));
    }
}