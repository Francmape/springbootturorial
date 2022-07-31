package com.skilciti.springboot.tutorial.repository;

import com.skilciti.springboot.tutorial.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest //Alters and reverts the database
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .name("Music")
                .address("Malindi")
                .code("SC900")
                .build();

        testEntityManager.persist(department);
    }

    @Test
    public void whenFindById_thenReturnDepartment() {

        Department department = departmentRepository.findById(1L).get();
        assertEquals(department.getName(), "Music");
    }
}