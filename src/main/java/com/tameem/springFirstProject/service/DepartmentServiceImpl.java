package com.tameem.springFirstProject.service;

import com.tameem.springFirstProject.entity.Department;
import com.tameem.springFirstProject.error.DepartmentNotFound;
import com.tameem.springFirstProject.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DeparmentService{
   @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }


    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchbyId(Long departmentId) throws DepartmentNotFound {
        Optional<Department>department= departmentRepository.findById(departmentId);
        if (!department.isPresent())
            throw new DepartmentNotFound("Department not found");
        return department.get();

    }

    @Override
    public void deleteDepartment(Long departmentId) {
     departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department)
    {
        Department db=departmentRepository.findById(departmentId).get();
        if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName()))
        {
            db.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode()))
        {
            db.setDepartmentCode(department.getDepartmentCode());
        }
        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())) {
            db.setDepartmentAddress(department.getDepartmentAddress());
        }
        return departmentRepository.save(db);
    }

    @Override
    public Department fetchDepartmentbyName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);//created my own method{check for the naming convention ok}
    }
}
