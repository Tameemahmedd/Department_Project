package com.tameem.springFirstProject.repository;

import com.tameem.springFirstProject.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department=Department.builder().departmentName("ME").departmentCode("ME-01").departmentAddress("New York").build();
        entityManager.persist(department);//for persisting that is temporarily storing the data in DB
    }
    @Test
    public void whenFindBYID_thenReturnDepartment(){
        Department department=departmentRepository.findById(1L).get();
        assertEquals(department.getDepartmentName(),"ME");
    }
}