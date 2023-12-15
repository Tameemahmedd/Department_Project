package com.tameem.springFirstProject.service;

import com.tameem.springFirstProject.entity.Department;
import com.tameem.springFirstProject.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DeparmentServiceTest {


    @Autowired
    private DeparmentService deparmentService;
    @MockBean//mockito annotation
    private DepartmentRepository departmentRepository;
    @BeforeEach
    void setUp() {
        Department department=Department.builder().departmentName("ce").departmentAddress("Kadapa").departmentCode("ce-93").departmentId(1L).build();
        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("ce")).thenReturn(department);
    }
    @Test
    @DisplayName("Get Data based on Valid Department Name")
    public void whenValidDepartmentName_thenDepartmentShouldFound(){
        String departmentName="ce";
        Department found=deparmentService.fetchDepartmentbyName(departmentName);

        assertEquals(departmentName,found.getDepartmentName());
    }
}