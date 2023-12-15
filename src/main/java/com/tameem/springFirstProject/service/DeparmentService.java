package com.tameem.springFirstProject.service;

import com.tameem.springFirstProject.entity.Department;
import com.tameem.springFirstProject.error.DepartmentNotFound;

import java.util.List;

public interface DeparmentService {

    public Department saveDepartment(Department department);

   public  List<Department> fetchDepartmentList();

    public Department fetchbyId(Long departmentId) throws DepartmentNotFound;
    void deleteDepartment(Long departmentId);

    Department updateDepartment(Long departmentId, Department department);

    Department fetchDepartmentbyName(String departmentName);
}
